package com.cashonline.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cashonline.springboot.controller.LoanController;
import com.cashonline.springboot.controller.UserController;


@SpringBootTest
class CashOnlineApiApplicationTests {
	
	@MockBean
	private UserController userController;
	
	@MockBean 
	private LoanController loanController;
	
	
	@Test
	void contextLoads() {
		assertThat(userController).isNotNull();
		assertThat(loanController).isNotNull();

	}
	

		
	

}
