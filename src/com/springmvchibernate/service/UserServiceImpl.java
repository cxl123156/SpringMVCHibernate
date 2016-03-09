package com.springmvchibernate.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvchibernate.dao.UserDao;
import com.springmvchibernate.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	UserDao userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try{
			userDao.updateUser(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean login(HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user = userDao.findUserByName(username);
		if(user.getPassword().equals(password)){
			session.setAttribute("currentUser", user);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try{
			userDao.addUser(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		try{
			userDao.delUser(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
