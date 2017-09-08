package com.niit.ecommerce_backend.dao;

import java.util.List;

import com.niit.ecommerce_backend.model.Product;


public interface ProductDAO {
	void saveProduct();
	List<Product> getAllProducts();
	Product getProductById();

}
