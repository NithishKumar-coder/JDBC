package com.service;

import com.exception.UserException;
import com.model.User;

public interface UserService {
	public abstract User creatUser(User user) throws UserException;

	public abstract User readUserById(int userId) throws UserException;

	public abstract String authenticateUserIdAndPassword(int userId, String password) throws UserException;

	public abstract int updateUser(User user) throws UserException;

	public abstract int deleteById(int userId) throws UserException;

}