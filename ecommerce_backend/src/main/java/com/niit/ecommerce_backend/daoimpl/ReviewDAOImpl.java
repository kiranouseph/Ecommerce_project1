package com.niit.ecommerce_backend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.ReviewDAO;
import com.niit.ecommerce_backend.model.Product;
import com.niit.ecommerce_backend.model.Review;
@Repository("ReviewDAOImpl")

public class ReviewDAOImpl implements ReviewDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public ReviewDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	//for saving the review
	public void savereview(Review r) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(r);
		t.commit();
		ssn.close();

		
	}
	
	//for retreiving the reviews of a specific product based on the product id passed
	public ArrayList<Review> getrevbyprid(int pr) {
		
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Review where Product_id="+pr);
		ArrayList<Review> l=(ArrayList<Review>) q.list();

		
        t.commit();
        ssn.close();
        return l;
		
	}
	
	
	

}