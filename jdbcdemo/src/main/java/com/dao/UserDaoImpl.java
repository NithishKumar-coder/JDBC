package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User createUserDao(User user) {
		User userDetail = null;
		Connection connection = MySQLConnectionCheck.getConnection();
		String readQuery = "INSERT INTO user (user_id,user_name,password)" + "values(?,?,?)";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(readQuery);
			prepareStatement.setInt(1, userDetail.getId());
			prepareStatement.setString(2, userDetail.getName());
			prepareStatement.setString(3, userDetail.getPassword());
			int rowsAffected = prepareStatement.executeUpdate();
			// iteration for all records
			userDetail = new User(userDetail.getId(), userDetail.getName(), userDetail.getPassword());
			if (rowsAffected > 0) {
				System.out.println(rowsAffected + " Rows in set");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userDetail;
	}

	@Override
	public User readUserByIdDao(int userId) {
		User user = null;
		Connection connection = MySQLConnectionCheck.getConnection();
		String readQuery = "SELECT * from user where user_id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(readQuery);
			prepareStatement.setInt(1, userId);
			ResultSet resultSet = prepareStatement.executeQuery();
			user = new User();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("user_id"));
				// - user_id
				user.setId(resultSet.getInt("user_id"));
				System.out.println(resultSet.getString("user_name"));
				// table - user_name
				user.setName(resultSet.getString("user_name"));
				System.out.println(resultSet.getString("password"));
				// table - password
				user.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String authenticateUserIdAndPasswordDao(int userId, String password) {
		String result = "";
		Connection connection = MySQLConnectionCheck.getConnection();
		String readQuery = "select user_id, password from user where user_id = ? and password = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(readQuery);
			prepareStatement.setInt(1, userId);
			prepareStatement.setString(2, password);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				result = resultSet.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateUserDao(User user) {
		String result = "";
		User user1 = null;
		Connection connection = MySQLConnectionCheck.getConnection();
		String readQuery = "UPDATE user set user_name = ? , password = ? where user_id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(readQuery);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setInt(3, user.getId());
			int resultSet = prepareStatement.executeUpdate();
			user = new User();
			if (resultSet == 1) {
				System.out.println("Data Updated");
			} else {
				System.out.println(" no.of records found and updated");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int deleteByIdDao(int userId) {
		int result = -1;
		Connection connection = MySQLConnectionCheck.getConnection();
		String readQuery = "DELETE from user where user_id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(readQuery);
			prepareStatement.setInt(1, userId);
			result = prepareStatement.executeUpdate();
			System.out.println(result);
			if (result == 0) {
				System.out.println("Data not found");
			} else {
				System.out.println(result + " no.of record(s) found and deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
