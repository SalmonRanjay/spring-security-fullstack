package com.ranjay.spring.nhssytems.repository;

import java.util.List;

import com.ranjay.spring.nhssytems.models.Task;
import com.ranjay.spring.nhssytems.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user);
    
}