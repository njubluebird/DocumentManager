package edu.nju.onlinedoc.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.onlinedoc.dao.UserDao;
import edu.nju.onlinedoc.exceptions.PasswordNotMatchException;
import edu.nju.onlinedoc.exceptions.UsernameExistException;
import edu.nju.onlinedoc.model.User;

public interface UserService {
	
	public UserDao getUserDao();
	public void setUserDao(UserDao userDao);
	
	public User validateUser(String userid);
	
	public String registerUser(User user);
	
	public String validateUpdateUser(User user);
	

	public Integer validateNumber(String number);
	

	public void sentErrorMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
					throws ServletException,IOException;

	public void sentMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
					throws ServletException,IOException;

	//public void forwardPage(String page,HttpServletRequest req,HttpServletResponse resp) 
	//				throws ServletException,IOException;
}
