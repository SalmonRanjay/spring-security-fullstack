package com.ranjay.spring.nhssytems.service;

import java.util.List;

import com.ranjay.spring.nhssytems.models.Task;
import com.ranjay.spring.nhssytems.models.User;
import com.ranjay.spring.nhssytems.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserTask(User user){
        return taskRepository.findByUser(user);
    }
}