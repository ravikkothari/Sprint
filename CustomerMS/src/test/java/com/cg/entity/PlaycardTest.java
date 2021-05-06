package com.cg.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.CustomerMsApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomerMsApplication.class)
@WebMvcTest(value = PlayCard.class)
public class PlaycardTest {

	private PlayCard playcard = new PlayCard();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetPlaycardId() {
		int mockId = 10;
		playcard.setPlaycardId(mockId);
		int id = playcard.getPlaycardId();

		assertThat(id).isEqualTo(mockId);

	}

	@Test
	void testSetPlaycardId() {
		int mockId = 10;
		playcard.setPlaycardId(mockId);
		int id = playcard.getPlaycardId();

		assertThat(id).isEqualTo(mockId);
	}

	@Test
	void testGetPlaycardName() {
		String mockName = "Shroff";
		playcard.setPlaycardName(mockName);
		String name = playcard.getPlaycardName();

		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testSetPlaycardName() {
		String mockName = "Shroff";
		playcard.setPlaycardName(mockName);
		String name = playcard.getPlaycardName();

		assertThat(name).isEqualTo(mockName);
	}
}
