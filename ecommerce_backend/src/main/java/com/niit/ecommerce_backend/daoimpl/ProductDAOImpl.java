package com.niit.ecommerce_backend.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce_backend.dao.ProductDAO;
import com.niit.ecommerce_backend.model.Product;


@SuppressWarnings("unused")
public class ProductDAOImpl implements ProductDAO{
	

	public boolean saveProduct(Product product) {
		 	
		 	
		 	
		 	return true;
		 }

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProductById() {
		
		return null;
	}

	

}
