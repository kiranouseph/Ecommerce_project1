package com.niit.ecommerce_backend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
	
	//for adding the user credentials to the database
	public void saveUser(User user) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(user);
		t.commit();
		ssn.close();
		
	}
	
	
	
	//for getting the user details by user email
	public ArrayList<User> getUserByUsername(String email){
		
		ArrayList<User> userr=new ArrayList<User>();
		
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    org.hibernate.Query q= session.createQuery("from User where email='"+email+"'");
		userr=(ArrayList<User>) q.list();
		
	    session.getTransaction().commit();
	    session.close();
	   
		
		return userr;
	}
//for changing password for the first login of supplier
	public void changepassword(String email, String pass) {
		
		
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		
		 Query qry1 = ssn.createQuery("update User  set password='"+pass+"'where email='"+email+"'");
		
				          
				          qry1.executeUpdate();
				         
				         
 				
		
        t.commit();
        
        ssn.close();
		
		
		
	}

	
	

	public void deleteuserbyemail(String email) {
		
ArrayList<User> userr=new ArrayList<User>();
		
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    org.hibernate.Query q= session.createQuery("from User where email='"+email+"'");
		userr=(ArrayList<User>) q.list();
		for(User u:userr)
		{
			session.delete(u);
		}
	    session.getTransaction().commit();
	    session.close();	
	}

	public ArrayList<User> getallusers() {
		
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Query q= ssn.createQuery("from User");
		ArrayList<User> l=(ArrayList<User>) q.list();
		
        t.commit();
        ssn.close();
		
		return l;
		
	}

	

}
