package com.cashonline.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.cashonline.springboot.exception.ResourceNotFoundException;
import com.cashonline.springboot.model.Loan;
import com.cashonline.springboot.model.User;

public class LoanTest {

    @Test
    public void canCreateLoan() throws ResourceNotFoundException {
		User user = new User("jorge@rolon.com", "JORGE", "ROLON");
		Loan loan = new Loan(3400.15, user);
        assertThat(loan.getTotal() == 3400.15);
        assertThat(loan.getUser().getId() == user.getId());

    }

    @Test
    public void cannotCreateLoanWithInvalidParameters() {
    	
        try {
    		User user = new User("jorge@rolon.com", "JORGE", "ROLON");
            new Loan(null, user);
            fail("Error al crear Prestamo");
        } catch (ResourceNotFoundException e) {
        	assertThat(e.getMessage() == "Parametro nulo o vacio :total");
        }
        try {
            new Loan(3400.15, null);
            fail("Error al crear Prestamo");
        } catch (ResourceNotFoundException e) {
        	assertThat(e.getMessage() == "Parametro nulo o vacio :user");
        }
    }

}

