package com.maveric.bankapp.controller;

import com.maveric.bankapp.exceptions.ConflictException;
import com.maveric.bankapp.exceptions.ResourceNotFoundException;
import com.maveric.bankapp.model.User;
import com.maveric.bankapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer/")
@RequiredArgsConstructor
public class UsersApiController {

	private static final Logger logger = LoggerFactory.getLogger(UsersApiController.class);

	@Autowired
	private final UserService userService;

	// -------------------Retrieve All Users---------------------------------------------

	@GetMapping(value = "/user/")
	public ResponseEntity listAllUsers() {
		logger.info("Fetching All User lists");
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}


	/***
	 * This method is used to Retrieve the user fo the given id
	 * @param id
	 * @return User
	 * @throws ResourceNotFoundException
	 */
	@GetMapping(value = "/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") long id) throws ResourceNotFoundException {
		logger.info("Fetching User with id {}", id);
		User user = userService.findById(id);
		if (user == null) {
			logger.error("User with id {} not found.", id);
			throw new ResourceNotFoundException("User with id " + id + " not found");
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	/***
	 * This method is used to Create the user
	 * @param user
	 * @return ResponseEntity
	 * @throws ConflictException
	 */
	@PostMapping(value = "/user/")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user, UriComponentsBuilder ucBuilder) throws ConflictException {
		logger.info("Creating User : {}", user);

		if (userService.isUserExist(user)) {
			logger.error("Unable to create. A User with name {} already exist", user.getFirstName());
			throw new ConflictException("Unable to create. A User with name " + user.getFirstName() + " already exist.");
		}
		userService.saveUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/customer/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	/***
	 * This method is used to Update the user
	 * @param user
	 * @return ResponseEntity
	 * @throws ResourceNotFoundException
	 */
	@PutMapping(value = "/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) throws ResourceNotFoundException {
		logger.info("Updating User with id {}", id);
		User currentUser = userService.findById(id);

		if (currentUser == null) {
			logger.error("Unable to update. User with id {} not found.", id);
			throw new ResourceNotFoundException("Unable to upate. User with id " + id + " not found.");
		}
		userService.updateUser(currentUser);
		return new ResponseEntity<>(currentUser, HttpStatus.OK);
	}

	/***
	 * This method is used to Delete the user for the given ID
	 * @param id
	 * @return ResponseEntity
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) throws ResourceNotFoundException {
		logger.info("Fetching & Deleting User with id {}", id);
		User user = userService.findById(id);
		if (user == null) {
			logger.error("Unable to delete. User with id {} not found.", id);
			throw new ResourceNotFoundException("Unable to delete. User with id " + id + " not found.");
		}
		userService.deleteUserById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}