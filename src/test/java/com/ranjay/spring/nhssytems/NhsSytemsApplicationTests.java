package com.ranjay.spring.nhssytems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.ranjay.spring.nhssytems.models.Task;
import com.ranjay.spring.nhssytems.models.User;
import com.ranjay.spring.nhssytems.service.TaskService;
import com.ranjay.spring.nhssytems.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NhsSytemsApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@Before
	public void initDB(){
		{
			User newUser = new User("testUser@gmail.com","testuser", "1234563");
			userService.createUser(newUser);
		}
		{
			User newUser = new User("testAdmin@gmail.com","testAdmin", "1234563");
			userService.createUser(newUser);
		}

		Task userTask = new Task("03/01/2018","00:11", "11:00", "You need to work today" );
		User user = userService.findOne("testUser@gmail.com");
		taskService.addTask(userTask, user);

	}

	@Test
	public void testUser(){
		User user = userService.findOne("testUser@gmail.com");
		assertNotNull(user);
		User admin = userService.findOne("testAdmin@gmail.com");
		assertEquals(admin.getEmail(), "testAdmin@gmail.com");
	}

	@Test
	public void testTask(){
		User user = userService.findOne("testUser@gmail.com");
		List<Task> task = taskService.findUserTask(user);
		assertNotNull(task);
	}

	@Test
	public void contextLoads() {
	}

}
