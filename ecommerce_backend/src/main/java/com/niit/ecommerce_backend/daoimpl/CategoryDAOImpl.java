package com.niit.ecommerce_backend.daoimpl;


import java.util.*;
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
	@Override
	public void saveProduct(Category category) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(category);
		t.commit();
		ssn.close();	
		
	}
	@Override
	public ArrayList<Category> getallcategories() {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Category");
		ArrayList<Category> l=(ArrayList<Category>) q.list();
		
        t.commit();
        ssn.close();
		for(Category c:l)
		{
			System.out.println(c);
		}
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
}
