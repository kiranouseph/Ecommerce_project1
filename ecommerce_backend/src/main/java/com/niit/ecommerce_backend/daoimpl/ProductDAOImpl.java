package com.niit.ecommerce_backend.daoimpl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

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
import com.niit.ecommerce_backend.model.User;

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
	//for saving product
	public void saveProduct(Product product) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(product);
		t.commit();
		ssn.close();	
		
	}
	
	//for retrieving the list of products based on subcategory
	public ArrayList<Product> getProdByscatId(int ca) {
	
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
	
	
	//for retrieving the product based on the id passed
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
	
	
	//for retrieving all the products
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
	//for deleting a product based on the id passed
	public void deleteproduct(int id) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Product l = (Product) ssn.get(Product.class, id);
		ssn.delete(l);
				
		
        t.commit();
        
        ssn.close();
		
	}
	//for setting offers and offerpercentage based on the offerprice orginal price passed
	public void setoffers(int id,int offprice,int orgprice) {
		System.err.println(offprice+" "+orgprice);
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		int per=100-(100*offprice/orgprice);
		System.err.println(per);
		 Query qry1 = ssn.createQuery("update Product  set offer="+1+"where id="+id);
		 Query qry2 = ssn.createQuery("update Product  set offerprice="+offprice+"where id="+id);
		 Query qry3 = ssn.createQuery("update Product  set offerper="+per+"where id="+id); 
				       
				          
				          qry1.executeUpdate();
				          qry2.executeUpdate();
				          qry3.executeUpdate();
 				
		
        t.commit();
        
        ssn.close();
		
	}
	//for retrieving the list of offer products
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
	//for deleting an offer
	public void deleteoffer(int id) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		 Query qry1 = ssn.createQuery("update Product  set offer="+0+"where id="+id);
		 Query qry2 = ssn.createQuery("update Product  set offerprice="+0+"where id="+id); 
		 Query qry3 = ssn.createQuery("update Product  set offerper="+0+"where id="+id); 
				       
		 qry2.executeUpdate(); 
				          qry1.executeUpdate();
				          qry3.executeUpdate();			
		
        t.commit();
        
        ssn.close();
	
	
	}
	
	//for updating a product
	public void updateproduct( Product p) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		 ssn.update(p);
		
        t.commit();
        
        ssn.close();
}
	
	
	
	
//for product's top offer in a category	
 public Product gettopoffer(int id) {
Session ssn=sessionFactory.openSession();
Transaction t=ssn.getTransaction();

String q="Select max(offerper) FROM Product where CATE="+id;
Query minQuery = ssn.createQuery(q);
Product pro=(Product) minQuery.list();

t.commit();

ssn.close();
return pro;





}
 
 //products by supplier id
public ArrayList<Product> getprodbysid(int sid) {

	
	ArrayList<Product> pro=new ArrayList<Product>();
	
	Session session = sessionFactory.openSession();
    session.beginTransaction();
    org.hibernate.Query q= session.createQuery("from Product where S_ID="+sid);
	pro=(ArrayList<Product>) q.list();
	
    session.getTransaction().commit();
    session.close();
   
	
	return pro;
	

}
}
