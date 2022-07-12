package com.maveric.bankapp.services;


import com.maveric.bankapp.model.User;

import java.util.List;

public interface UserService {

	User findById(Long id);

	User findByName(String name);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(Long id);

	List<User> findAllUsers();

	boolean isUserExist(User user);
}