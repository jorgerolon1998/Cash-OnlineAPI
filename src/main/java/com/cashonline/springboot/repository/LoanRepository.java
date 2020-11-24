package com.cashonline.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cashonline.springboot.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{
	
	@Query("select l from Loan l where user_id = ?1")
	Page<Loan> findByUserId(Long userId, Pageable pageable);
	
	@Query("select l from Loan l")
	Page<Loan> findAll(Pageable pageable);
	
}
