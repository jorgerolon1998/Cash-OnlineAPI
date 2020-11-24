package com.cashonline.springboot.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cashonline.springboot.model.Loan;
import com.cashonline.springboot.service.LoanService;

@RestController
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping("/loans")
	public ResponseEntity<Map<String, Object>> findAll(Pageable pageable, @RequestParam Optional<Long> user_id){
		Page<Loan> loans = loanService.getLoansByUserId(user_id, pageable);
		
	     Map<String, Object> response = new HashMap<>();
	     Map<String, Object> paging = new HashMap<>();
	     paging.put("page", loans.getNumber());
	     paging.put("total", loans.getTotalElements());
	     paging.put("size", loans.getTotalPages());
	     response.put("paging", paging);
	     response.put("items", loans.getContent());

	      
	     return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
