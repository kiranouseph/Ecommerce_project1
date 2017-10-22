package com.niit.ecommerce_backend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.ContactDAO;
import com.niit.ecommerce_backend.model.Contact;
import com.niit.ecommerce_backend.model.Product;
@Repository("ContactDAOImpl")
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public ContactDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	public void savecontact(Contact c) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(c);
		t.commit();
		ssn.close();
		
	}
	public ArrayList<Contact> getallmessages() {
	
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Query q= ssn.createQuery("from Contact");
		ArrayList<Contact> l=(ArrayList<Contact>) q.list();
		
        t.commit();
        ssn.close();
		
		return l;
	}
	public void deletecontactbyid(int id) {
	
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Contact l = (Contact) ssn.get(Contact.class, id);
		ssn.delete(l);
				
		
        t.commit();
        
        ssn.close();
        
	}

}
