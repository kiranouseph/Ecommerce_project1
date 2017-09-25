package com.niit.ecommerce_backend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.SupplierDAO;
import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Supplier;

@Repository("SupplierDAOImpl")
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public SupplierDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}

	@Override
	public void saveProduct(Supplier supplier) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(supplier);
		t.commit();
		ssn.close();	
		
	}

	@Override
	public ArrayList<Supplier> getallsuppliers() {
		
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Supplier");
		ArrayList<Supplier> l=(ArrayList<Supplier>) q.list();
		
        t.commit();
        ssn.close();
		for(Supplier s:l)
		{
			System.out.println(s);
		}
		return l;
	
	}

	public Supplier getsuppbyid(int supp) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Supplier l = (Supplier) ssn.get(Supplier.class,supp);

		
        t.commit();
        
        ssn.close();
		
		return l;
	}

}
