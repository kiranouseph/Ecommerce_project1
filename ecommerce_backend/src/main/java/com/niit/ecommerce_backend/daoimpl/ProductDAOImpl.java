package com.niit.ecommerce_backend.daoimpl;


import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.ProductDAO;
import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Product;

import antlr.collections.List;



@Repository("ProductDAOImpl")
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public ProductDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	public void saveProduct(Product product) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(product);
		t.commit();
		ssn.close();	
		
	}
	public ArrayList<Product> getProdByCatId(int ca) {
		System.out.println("in impl;"+ca);
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Product where C_ID="+ca);
		ArrayList<Product> l=(ArrayList<Product>) q.list();
		
        t.commit();
        ssn.close();
        System.out.println("Daoimpl reached");
		
		return l;
	}
	public ArrayList<Product> getProdById(int pr) {
		System.out.println("in impl;"+pr);
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Product where ID="+pr);
		ArrayList<Product> l=(ArrayList<Product>) q.list();
		
        t.commit();
        ssn.close();
        System.out.println("Daoimpl reached");
		
		return l;
	}
	public ArrayList<Product> getallproducts() {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Query q= ssn.createQuery("from Product");
		ArrayList<Product> l=(ArrayList<Product>) q.list();
		
        t.commit();
        ssn.close();
		
		return l;
	}
	


	

	

}
