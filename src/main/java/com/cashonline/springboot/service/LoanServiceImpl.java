package com.cashonline.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cashonline.springboot.model.Loan;
import com.cashonline.springboot.repository.LoanRepository;

@Service
@Transactional
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	private LoanRepository loanRepository;

	@Override
	public Page<Loan> getLoansByUserId(Optional <Long> userId, Pageable pageable) {
				
		if(userId.isPresent()) {
			return this.loanRepository.findByUserId(userId.get(), pageable);
		}else {
			return this.loanRepository.findAll(pageable);			
		}
		
	}
}
