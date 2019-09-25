package com.ranjay.spring.nhssytems.repository;

import com.ranjay.spring.nhssytems.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String>{

}