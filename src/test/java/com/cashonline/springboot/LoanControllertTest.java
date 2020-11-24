package com.cashonline.springboot;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cashonline.springboot.controller.LoanController;
import com.cashonline.springboot.exception.ResourceNotFoundException;
import com.cashonline.springboot.model.Loan;
import com.cashonline.springboot.model.User;
import com.cashonline.springboot.service.LoanService;

@WebMvcTest(value= LoanController.class)
public class LoanControllertTest {
	
	@MockBean
	private LoanService loanService;
	
	private User user;
	
	@BeforeAll
	public void before() throws ResourceNotFoundException {
		
		user = new User("jorge@rolon.com", "JORGE", "ROLON");

		new Loan(1300.00, user);
		
	}

	

}
