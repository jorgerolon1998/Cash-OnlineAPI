package com.cashonline.springboot.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cashonline.springboot.exception.ResourceNotFoundException;

@Entity
@Table(name ="User")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Loan> loans = new ArrayList<>();
	
	public User() {
	}
	
	public User(String email, String firstName, String lastName) throws ResourceNotFoundException {
        assertStringParamIsValid(email);
        assertStringParamIsValid(firstName);
        assertStringParamIsValid(lastName);
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
    private static void assertStringParamIsValid(String param) throws ResourceNotFoundException {
        if (param == null || param.isEmpty()) {
            throw new ResourceNotFoundException("Parametro nulo o vacio: " + param );
        }
    }

			
}
