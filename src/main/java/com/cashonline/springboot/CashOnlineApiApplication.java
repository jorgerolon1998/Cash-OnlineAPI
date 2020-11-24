package com.cashonline.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cashonline.springboot.exception.ResourceNotFoundException;
import com.cashonline.springboot.model.Loan;
import com.cashonline.springboot.model.User;
import com.cashonline.springboot.repository.UserRepository;

@SpringBootApplication
public class CashOnlineApiApplication {

	public static void main(String[] args) throws ResourceNotFoundException, BeansException {
		ConfigurableApplicationContext configurableApplicationContext = 
				SpringApplication.run(CashOnlineApiApplication.class, args);
	
		UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);
		
		User user = new User("jorge@rolon.com", "JORGE", "ROLON");
		Loan loan1 = new Loan(3400.15, user);
		Loan loan2 = new Loan(7800.00, user);
		List<Loan> loans = Arrays.asList(loan1, loan2);
		user.setLoans(loans);
		userRepository.save(user);
		
	}

}
