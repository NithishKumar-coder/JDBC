/**
 * 
 */
package com.main;
import java.util.Scanner;

import com.exception.UserException;
import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;
/**
 * @author nithish.kumarb
 *
 */
public class UserMain {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
Scanner scanner=new Scanner(System.in);
UserService userService=new UserServiceImpl();
System.out.println("what do you want to do");
String input="";
input= scanner.nextLine();
if (input=="create") {
	int userId = -1;
	String userName = "nullname";
	String password = "nullpassword";
	System.out.println("Enter Id : ");
	userId = scanner.nextInt();
	System.out.println("Enter name : ");
	userName = scanner.next();
	System.out.println("Enter password : ");
	password = scanner.next();
	User user1 = new User(userId, userName, password);
	User userResult1 = new User();

	try {
		userResult1 = userService.creatUser(user1);
		if (userResult1 != null) // success
		{
			System.out.println("User is created :" + userResult1.toString());
		}
	} catch (UserException e) {
		System.err.println(e.getMessage());
	} finally {
		userService = null; // dereference
	}
}
else if (input=="read") {
	int userIdToRead = -1;
	System.out.println("Enter Id : ");
	userIdToRead = scanner.nextInt();

	User userResult2;
	try {
		userResult2 = userService.readUserById(userIdToRead);
		if (userResult2.getId() != 0) 
		{
			System.out.println("User Found :" + userResult2);
		} else {
			System.err.println("User not exist");
		}
	} catch (UserException e) {
		System.err.println(e.getMessage());
	} finally {
		userService = null; // dereference
	}
}
else if (input=="update") {
	int userIdToUpdate = -1;
	String userNameToUpdate = "";
	String passwordToUpdate = "";

	System.out.println("Enter Id : ");
	userIdToUpdate = scanner.nextInt();
	System.out.println("Enter name : ");
	userNameToUpdate = scanner.next();
	System.out.println("Enter password : ");
	passwordToUpdate = scanner.next();

	User user5 = new User(userIdToUpdate, userNameToUpdate, passwordToUpdate);
	int userResult5;
	try {
		userResult5 = userService.updateUser(user5);
		if (userResult5 != 0) {
			System.out.println("User is updated ");
		}
	} catch (UserException e) {
		System.err.println(e.getMessage());
	} finally {
		userService = null; 
	}
}
else if (input=="delete") {
	int userIdToDelete = -1;
	int result = -1;
	System.out.println("Enter Id : ");
	userIdToDelete = scanner.nextInt();

	// User userResult6;
	try {
		result = userService.deleteById(userIdToDelete);
		if (result != 0) {
			System.out.println("User is deleted ");
		}
	} catch (UserException e) {
		System.err.println(e.getMessage());
	} finally {
		userService = null; 
	}
}
else {
	System.out.println("Not a valid operation");
}
	}

}
