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
	//for adding supplier
	public void savesupplier(Supplier supplier) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(supplier);
		t.commit();
		ssn.close();	
	}
	//for retrieving the all suppliers 
	public ArrayList<Supplier> getallsuppliers() {
		
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Supplier");
		ArrayList<Supplier> l=(ArrayList<Supplier>) q.list();
		
        t.commit();
        ssn.close();
		
		return l;
	
	}
//for retrieving the detaisl of the supplier by the supplier id passed
	public Supplier getsuppbyid(int supp) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Supplier l = (Supplier) ssn.get(Supplier.class,supp);

		
        t.commit();
        
        ssn.close();
		
		return l;

}
	//for deleting the supplier
	public void deletesupplier(int id) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Supplier l = (Supplier) ssn.get(Supplier.class, id);
		ssn.delete(l);
				
		
        t.commit();
        
        ssn.close();
		
	}
	//for updating the supplier
	public void updatesupplier(Supplier s) {
		
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		
		ssn.update(s);
				
		
        t.commit();
        
        ssn.close();
				
	}
}
