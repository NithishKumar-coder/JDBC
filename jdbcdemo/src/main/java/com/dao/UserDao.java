package com.dao;

import com.model.User;

public interface UserDao {

	public abstract User createUserDao(User user);

	public abstract User readUserByIdDao(int userId);

	public abstract String authenticateUserIdAndPasswordDao(int userId, String password);

	public abstract int updateUserDao(User user);

	public abstract int deleteByIdDao(int userId);

}