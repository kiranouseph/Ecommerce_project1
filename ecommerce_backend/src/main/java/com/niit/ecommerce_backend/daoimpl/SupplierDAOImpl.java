package com.niit.ecommerce_backend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.SupplierDAO;
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

}
