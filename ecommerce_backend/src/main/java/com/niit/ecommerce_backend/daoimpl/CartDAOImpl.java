package com.niit.ecommerce_backend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.CartDAO;
import com.niit.ecommerce_backend.model.Cart;
import com.niit.ecommerce_backend.model.Product;

@Repository("CartDAOImpl")
public class CartDAOImpl implements CartDAO {
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

public void deletecartitem(int cartid) {
	Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
	Cart l = (Cart) ssn.get(Cart.class, cartid);
	ssn.delete(l);
			
	
    t.commit();
    
    ssn.close();
	
}

public Cart getcartitembyid(int cartid) {
	Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
	Cart l = (Cart) ssn.get(Cart.class, cartid);
	
			
	
    t.commit();
    
    ssn.close();
    return l;
	
}


public void updatecartitem(Cart cart) {
	Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
ssn.update(cart);
	
    t.commit();
    
    ssn.close();
	
}

public void updatequan(int imp, int i) {
	Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
	 Query qry1 = ssn.createQuery("update Cart  set quantity="+i+"where cartid="+imp);
	  
	 
			       
	
			          qry1.executeUpdate();
			         				
	
    t.commit();
    
    ssn.close();
	
}
}
