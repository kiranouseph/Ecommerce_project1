package com.niit.ecommerce_backend.daoimpl;


import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.CategoryDAO;
import com.niit.ecommerce_backend.model.Category;


@Repository("CategoryDAOImpl")
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public CategoryDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	public void savecategory(Category category) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(category);
		t.commit();
		ssn.close();
		
	}
	public ArrayList<Category> getallcategories() {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Query q= ssn.createQuery("from Category");
		ArrayList<Category> l=(ArrayList<Category>) q.list();
		
        t.commit();
        ssn.close();
		
		return l;
	}
	public Category getcatbyid(int cat) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Category l = (Category) ssn.get(Category.class, cat);
System.out.println(l.getCategoryname()+l.getId());
		
        t.commit();
        
        ssn.close();
		
		return l;
		
		
		
		
		
		
	}
	public void deletecategory(int id) {
	
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Category l = (Category) ssn.get(Category.class, id);
		ssn.delete(l);
				
		
        t.commit();
        
        ssn.close();
		
		
		
		
	}
	
	
	
	
	
}
