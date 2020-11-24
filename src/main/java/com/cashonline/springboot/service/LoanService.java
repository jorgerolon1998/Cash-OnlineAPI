package com.cashonline.springboot.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cashonline.springboot.model.Loan;

public interface LoanService {
	
	Page<Loan> getLoansByUserId(Optional <Long> userId, Pageable pageable);
	
}
