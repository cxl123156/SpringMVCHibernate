package com.springmvchibernate.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.springmvchibernate.model.User;

public interface UserService {

	public boolean login(HttpServletRequest request,HttpSession session);
	public boolean addUser(User user);
	public List<User> findAllUser();
	public boolean updateUser(User user);
	public User findUserById(int id);
	public boolean deleteUserById(int id);
	
}
