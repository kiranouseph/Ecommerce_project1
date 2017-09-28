package com.niit.ecommerce_backend.daoimpl;


import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.CategoryDAO;
import com.niit.ecommerce_backend.dao.SubcategoryDAO;
import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Product;
import com.niit.ecommerce_backend.model.Subcategory;


@Repository("SubcategoryDAOImpl")

public class SubcategoryDAOImpl implements SubcategoryDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public SubcategoryDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	public void saveProduct(Subcategory Subcategory) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(Subcategory);
		t.commit();
		ssn.close();	

		
	}
	public ArrayList<Subcategory> getallsubcategories() {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Query q= ssn.createQuery("from Subcategory");
		ArrayList<Subcategory> l=(ArrayList<Subcategory>) q.list();
		
        t.commit();
        ssn.close();
		
		return l;
	}
	public Subcategory getscatbyid(int scat) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Subcategory l = (Subcategory) ssn.get(Subcategory.class, scat);

		
        t.commit();
        
        ssn.close();
		
		return l;
		
		
		
	}
	public ArrayList<Subcategory> getsubcatByCatId(int ca) {
		
			
			Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			org.hibernate.Query q= ssn.createQuery("from Subcategory where C_ID="+ca);
			ArrayList<Subcategory> l=(ArrayList<Subcategory>) q.list();
			
	        t.commit();
	        ssn.close();
	        System.out.println("Daoimpl reached");
			
			return l;
		
	}
	public void deletesubcategory(int id) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Subcategory l = (Subcategory) ssn.get(Subcategory.class, id);
		ssn.delete(l);
				
		
        t.commit();
        
        ssn.close();
		
	}
	

	
}
