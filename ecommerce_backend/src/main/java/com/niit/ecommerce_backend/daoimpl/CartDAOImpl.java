package com.niit.ecommerce_backend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("CartDAOImpl")
public class CartDAOImpl {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public CartDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	
 public void addcart(int id,String name)
 {
	 
 }
}
