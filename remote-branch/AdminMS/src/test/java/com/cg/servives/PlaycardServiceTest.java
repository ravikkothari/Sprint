package com.cg.servives;

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

import com.cg.AdminMSApplication;
import com.cg.dao.PlaycardDao;
import com.cg.entity.Admin;
import com.cg.entity.PlayCard;
import com.cg.services.PlaycardService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AdminMSApplication.class)
@WebMvcTest(value = PlaycardService.class)
public class PlaycardServiceTest {

	@Autowired
	private PlaycardService playcardServices;

	@MockBean
	private PlaycardDao playcardDao;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testCreatePlaycardController() throws Exception {
		PlayCard playcard = getPlaycard();
	   
	    Mockito.when(playcardDao.save(Mockito.any(PlayCard.class))).thenReturn(playcard);
	    
	    List<PlayCard> result = playcardServices.addPlaycard(playcard);
	    
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
	void testUpdatePlaycardController() throws Exception {
		
		Optional<PlayCard> p = Optional.of(getPlaycard());
		PlayCard playcard = getPlaycard();
	  
	    Mockito.when(playcardDao.findById(Mockito.anyInt())).thenReturn(p);
	    Mockito.when(playcardDao.save(Mockito.any(PlayCard.class))).thenReturn(playcard);
	    
	    PlayCard result = playcardServices.updatePlaycard(playcard, 101);
	    
	    assertThat(playcard).isEqualTo(result);
	}
	
	@Test
	void testDeletePlaycardByIdController() throws Exception {
		Optional<PlayCard> p = Optional.of(getPlaycard());

	    boolean b = true;
	    
	    Mockito.when(playcardDao.findById(Mockito.anyInt())).thenReturn(p);
	    Mockito.doNothing().when(playcardDao).deleteById(Mockito.anyInt());
	    
	    boolean result = playcardServices.deletePlaycardById(101);
	    
	    assertThat(b).isEqualTo(result);
	}
	
	@Test
	void testListAllPlaycardController() throws Exception {

		List<PlayCard> p = new ArrayList<PlayCard>();
		
		PlayCard playcard = getPlaycard();
		p.add(playcard);
	    
	    Mockito.when(playcardDao.findAll()).thenReturn(p);
	   
	    List<PlayCard> result = playcardServices.getAllPlaycard();
	    
	    
	    assertThat(p).isEqualTo(result);
	}
	
	
	private PlayCard getPlaycard() {
		PlayCard p = new PlayCard();
		
		p.setPlaycardId(101);
		p.setPlaycardName("abc");
		
		
		return p;
	}
}
