package com.niit.ecommerce_backend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.UserDAO;

import com.niit.ecommerce_backend.model.User;
@Repository("UserDAOImpl")
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public UserDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}

	@Override
	public void saveUser(User user) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(user);
		t.commit();
		ssn.close();
		
	}

}
