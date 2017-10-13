package com.niit.ecommerce_backend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.model.Cart;
import com.niit.ecommerce_backend.model.Product;

@Repository("CartDAOImpl")
public class CartDAOImpl {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public CartDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	
 public void addcart(Cart cart)
 {
	 Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(cart);
		t.commit();
		ssn.close();
	 
	 
	 
	 
 }

public Product getprodbyid(int id) {
	
		Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
	Product l = (Product) ssn.get(Product.class,id);
	
    t.commit();
    ssn.close();
    System.out.println("Daoimpl reached");
	
	return l;
}

public ArrayList<Cart> getcartitemsbyname(String name) {
	Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
	org.hibernate.Query q= ssn.createQuery("from Cart where username='"+name+"'");
	ArrayList<Cart> l=(ArrayList<Cart>) q.list();
	
    t.commit();
    ssn.close();
 
	
	return l;
}
}
