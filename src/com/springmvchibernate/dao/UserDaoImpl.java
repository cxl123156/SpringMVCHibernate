package com.springmvchibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springmvchibernate.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0,id);
		return (User) query.uniqueResult();
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String hql ="from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public boolean delUser(int id) {
		// TODO Auto-generated method stub
		String hql = "delete User u where u.id = ?";  
	    Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	    query.setInteger(0, id);  
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		String hql="from User u where u.userName = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0,username);
		return (User) query.uniqueResult();
	}

}
