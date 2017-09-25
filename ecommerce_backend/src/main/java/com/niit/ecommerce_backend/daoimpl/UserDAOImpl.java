package com.niit.ecommerce_backend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.UserDAO;
import com.niit.ecommerce_backend.model.Product;
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

	public int checklogin(String email,String password) {
		int re=0;
		System.out.println("in checklogin"+email+password);
		User userr = getUserByUsername(email);
		if(userr != null && password.equals(userr.getPassword()))
			{re = 1;}
		System.out.println("status"+re);
		return re;
	}
	public User getUserByUsername(String email){
		System.out.println("in getuserbyname"+email);
		User userr=null;
		try{
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    org.hibernate.Query q= session.createQuery("from Product where email=:email ");
		userr=(User) q.list();
		System.out.println("after retrievel"+userr.getEmail()+userr.getPassword());
	    session.getTransaction().commit();
	    session.close();
	   
		}catch(Exception e){
			System.out.println("in catch");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return userr;
	}


}
