package com.cashonline.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cashonline.springboot.exception.ResourceNotFoundException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"user"})
@Table(name ="loan")
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Double total;

	@JoinColumn(name = "user_id")
	@ManyToOne(targetEntity = User.class)
	private User user;
	
	@Column(name = "user_id" , insertable = false, updatable = false)
	private Long userId;	
	
	public Loan() {
	}
	
	public Loan(Double total, User user) throws ResourceNotFoundException {
		assertUserParamIsValid(user);
		assertDoubleParamIsValid(total);
		this.total = total;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Long getUserId() {
		return userId;
	}
	
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private static void assertDoubleParamIsValid(Double param) throws ResourceNotFoundException {
        if (param == null || param.isNaN()) {
            throw new ResourceNotFoundException("Parametro nulo o vacio: " + param );
        }
    }
    
    private static void assertUserParamIsValid(User param) throws ResourceNotFoundException {
        if (param == null) {
            throw new ResourceNotFoundException("Parametro nulo o vacio: " + param );
        }
    }
    
}
