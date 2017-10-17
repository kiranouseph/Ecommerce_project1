package com.niit.ecommerce_backend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.OrderDAO;

@Repository("OrderDAOImpl")
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public OrderDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	
	
}
