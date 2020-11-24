package com.cashonline.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cashonline.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
