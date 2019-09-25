package com.ranjay.spring.nhssytems.repository;

import com.ranjay.spring.nhssytems.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    
}