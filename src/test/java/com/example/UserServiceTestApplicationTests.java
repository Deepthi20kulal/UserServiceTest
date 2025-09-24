package com.example;

import com.example.controller.ControllerDeepthi;
import com.example.entity.UserEntityDeepthi;
import com.example.service.UserServiceDeepthi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class UserServiceTestApplicationTests {

	@Autowired
	ControllerDeepthi controller;

	@Autowired
	UserServiceDeepthi userService;

	@Test
	void testGetUserById() {
		UserEntityDeepthi user = new UserEntityDeepthi(2, "Priya");
		userService.addUserDeepthi(user);

		UserEntityDeepthi fetchedUser = userService.getUserByIdDeepthi(2);
		assertNotNull(fetchedUser);
		assertEquals("Priya", fetchedUser.getUsername());
	}


	@Test
	void testAddUserDeepthi() {
		UserEntityDeepthi user = new UserEntityDeepthi(1, "Deepthi");

		ResponseEntity<UserEntityDeepthi> response = controller.addUserDeepthi(user);

		assertEquals(200, response.getStatusCodeValue());
		assertNotNull(response.getBody());
		assertEquals(1, response.getBody().getId());
		assertEquals("Deepthi", response.getBody().getUsername());
	}

	// Test for GET /users/{id} when user exists
	@Test
	void testGetUserByIdDeepthi() {
		// Arrange: add user first
		UserEntityDeepthi user = new UserEntityDeepthi(2, "Priya");
		controller.addUserDeepthi(user);

		// Act
		ResponseEntity<UserEntityDeepthi> response = controller.getUserByIdDeepthi(2);

		// Assert
		assertEquals(200, response.getStatusCodeValue());
		assertNotNull(response.getBody());
		assertEquals(2, response.getBody().getId());
		assertEquals("Priya", response.getBody().getUsername());
	}

	@Test
	void testGetUserByIdDeepthi_NotFound() {
		Exception exception = assertThrows(Exception.class, () -> {
			controller.getUserByIdDeepthi(99);
		});

		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains("No value present")); // because service uses .get()
	}


}
