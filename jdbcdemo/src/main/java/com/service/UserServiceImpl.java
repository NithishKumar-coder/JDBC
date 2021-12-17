package com.service;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.exception.UserException;
import com.model.User;

public class UserServiceImpl implements UserService {

	@Override
	public User creatUser(User user) throws UserException {
User user2=null;
UserDao userDao=new UserDaoImpl();
user2= userDao.createUserDao(user);
if (user2 != null) {
	return user2;
} else {
	throw new UserException("No user is created");
}
	}

	@Override
	public User readUserById(int userId) throws UserException {

		User user2=null;
		UserDao userDao=new UserDaoImpl();
		user2= userDao.readUserByIdDao(userId);
		if (user2 != null) {
			return user2;
		} else {
			throw new UserException("No Such user");}
	}

	@Override
	public String authenticateUserIdAndPassword(int userId, String password) throws UserException {
		String user2=null;
		UserDao userDao=new UserDaoImpl();
		user2= userDao.authenticateUserIdAndPasswordDao(userId, password);
		if (user2 != null) {
			return user2;
		} else {
			throw new UserException("No Such user");}

	}

	@Override
	public int updateUser(User user) throws UserException {
		UserDao userDao=new UserDaoImpl();
		int user21= userDao.updateUserDao(user);
		if (user21 != 0) {
			return user21;
		} else {
			throw new UserException("Data not updated");
		}
	}

	@Override
	public int deleteById(int userId) throws UserException {
		int result = -1;
		UserDao userDao = new UserDaoImpl();
		result = userDao.deleteByIdDao(userId);

		if (result > 0) {
			return result;
		} else {
			throw new UserException("No user is deleted");
		}
	}

}
