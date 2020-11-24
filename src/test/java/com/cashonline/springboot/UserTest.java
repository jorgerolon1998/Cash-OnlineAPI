package com.cashonline.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import com.cashonline.springboot.exception.ResourceNotFoundException;
import com.cashonline.springboot.model.User;

public class UserTest {

    @Test
    public void canCreateUser() throws ResourceNotFoundException {
        User user = new User("jorge@hotmail.com", "jorge", "rolon");
        assertThat(user.getEmail() == "jorge@hotmail.com");
        assertThat(user.getFirstName() == "jorge");
        assertThat(user.getLastName() == "rolon");  
    }

    @Test
    public void cannotCreateUserWithInvalidParameters() {
        try {
            new User("jorge@hotmail.com", null, "rolon");
            fail("Error al crear Usuario");
        } catch (ResourceNotFoundException e) {
        	assertThat(e.getMessage() == "Parametro nulo o vacio :firstName");
        }
        try {
            new User("jorge@hotmail.com", "jorge", null);
            fail("Error al crear Usuario");
        } catch (ResourceNotFoundException e) {
        	assertThat(e.getMessage() == "Parametro nulo o vacio :lastName");
        }
        try {
            new User(null, "jorge", "rolon");
            fail("Error al crear Usuario");
        } catch (ResourceNotFoundException e) {
        	assertThat(e.getMessage() == "Parametro nulo o vacio :email");
        }
    }

}

