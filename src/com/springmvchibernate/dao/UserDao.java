package com.springmvchibernate.dao;

import java.util.List;

import com.springmvchibernate.model.User;

public interface UserDao {

    public User getUser(int id);  
    
    public List<User> getAllUser();  
      
    public void addUser(User user);  
      
    public boolean delUser(int id);  
      
    public boolean updateUser(User user); 

    public User findUserByName(String username);
}
