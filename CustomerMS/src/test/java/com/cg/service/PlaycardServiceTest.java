package com.cg.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.CustomerMsApplication;
import com.cg.dao.PlaycardDAO;
import com.cg.entity.PlayCard;
import com.cg.services.PlaycardService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomerMsApplication.class)
@WebMvcTest(value = PlaycardService.class)

public class PlaycardServiceTest {

		@Autowired
		private PlaycardService playcardServices;

		@MockBean
		private PlaycardDAO playcardDao;
		
		@BeforeEach
		void setUp() throws Exception {
		}

		@AfterEach
		void tearDown() throws Exception {
		}
		
	
		
		@Test
		void testbuyPlaycardController() throws Exception {
			PlayCard playcard = getPlaycard();
		   
		    Mockito.when(playcardDao.save(Mockito.any(PlayCard.class))).thenReturn(playcard);
		    
		    PlayCard result = (PlayCard) playcardServices.buyPlaycard(playcard);
		    
		    assertThat(playcard).isEqualTo(result);

		}
		
		@Test
		void testViewPlaycardByIdController() throws Exception {
			
			Optional<PlayCard> playcard = Optional.of(getPlaycard());

		    Mockito.when(playcardDao.findById(Mockito.anyInt())).thenReturn(playcard);

		    PlayCard result = playcardServices.getPlaycardById(101);
		    
		    assertThat(playcard).isEqualTo(result);

		}
		
		@Test
		void testBuyPlaycardController() throws Exception {
			
			Optional<PlayCard> p = Optional.of(getPlaycard());
			PlayCard playcard = getPlaycard();
		  
		    Mockito.when(playcardDao.findById(Mockito.anyInt())).thenReturn(p);
		    Mockito.when(playcardDao.save(Mockito.any(PlayCard.class))).thenReturn(playcard);
		    
		    PlayCard result = playcardServices.rechargePlaycard(playcard, 101);
		    
		    assertThat(playcard).isEqualTo(result);
		}
		
		
		private PlayCard getPlaycard() {
			PlayCard p = new PlayCard();
			
			p.setPlaycardId(101);
			p.setPlaycardName("abc");
			
			return p;
		}
}


