package com.niit.ecommerce_backend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.OrderDAO;
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
	
}
