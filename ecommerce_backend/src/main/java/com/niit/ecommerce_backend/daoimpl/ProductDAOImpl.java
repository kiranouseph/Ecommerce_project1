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
import com.niit.ecommerce_backend.model.Supplier;

import antlr.collections.List;
import sun.net.www.content.text.plain;



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
	public ArrayList<Product> getProdByscatId(int ca) {
		System.out.println("in impl;"+ca);
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Product where SC_ID="+ca);
		ArrayList<Product> l=(ArrayList<Product>) q.list();
		
        t.commit();
        ssn.close();
        System.out.println("Daoimpl reached");
		
		return l;
	}
	public Product getProdById(int pr) {
		System.out.println("in impl;"+pr);
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Product l = (Product) ssn.get(Product.class,pr);
		
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
	public void deleteproduct(int id) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Product l = (Product) ssn.get(Product.class, id);
		ssn.delete(l);
				
		
        t.commit();
        
        ssn.close();
		
	}
	
	public void setoffers(int id,int offprice) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		 Query qry1 = ssn.createQuery("update Product  set offer="+1+"where id="+id);
		 Query qry2 = ssn.createQuery("update Product  set offerprice="+offprice+"where id="+id);
		 
				       
				          
				          qry1.executeUpdate();
				          qry2.executeUpdate();
				
		
        t.commit();
        
        ssn.close();
		
	}
	
	public ArrayList<Product> listof_offerProducts() {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		
		org.hibernate.Query q= ssn.createQuery("from Product where offer="+1);
		ArrayList<Product> l=(ArrayList<Product>) q.list();
				       
				        
				
		
        t.commit();
        
        ssn.close();
        return l;
		
	}
	
	public void deleteoffer(int id) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		 Query qry1 = ssn.createQuery("update Product  set offer="+0+"where id="+id);
		 Query qry2 = ssn.createQuery("update Product  set offerprice="+0+"where id="+id); 
		 
				       
		 qry2.executeUpdate(); 
				          qry1.executeUpdate();
				         				
		
        t.commit();
        
        ssn.close();
		
	
	

	

	

}
}
