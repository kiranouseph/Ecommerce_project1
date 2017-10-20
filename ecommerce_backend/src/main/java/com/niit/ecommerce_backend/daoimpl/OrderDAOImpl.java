package com.niit.ecommerce_backend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.OrderDAO;
import com.niit.ecommerce_backend.model.Cart;
import com.niit.ecommerce_backend.model.Order;

@Repository("OrderDAOImpl")
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public OrderDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	
	
	public void addorder(Order o)
	{
		
		
		
		
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(o);
		t.commit();
		ssn.close();

		
	}
	
	public void updateorder(Order o)
	{
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.update(o);
		t.commit();
		ssn.close();	
		
	}


	public ArrayList<Order> getorderbyemail(String namees) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Order where email='"+namees+"'");
		ArrayList<Order> l=(ArrayList<Order>) q.list();
		
	    t.commit();
	    ssn.close();
	 
		
		return l;
	}
	
}
