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
import com.niit.ecommerce_backend.model.Product;

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


	public ArrayList<Order> getallundeliveredprods() {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Order where delivered="+0+"AND placeconfirm="+1);
		ArrayList<Order> l=(ArrayList<Order>) q.list();
		
	    t.commit();
	    ssn.close();
		
		
		return l;
	}


	public void deleteorder(Order namees) {
	
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.delete(namees);
		t.commit();
		ssn.close();	
	}


	public Order getorderbyid(int id) {
		
		
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Order l = (Order) ssn.get(Order.class,id);
		
        t.commit();
        ssn.close();
        
		
		return l;
	}
	
}
