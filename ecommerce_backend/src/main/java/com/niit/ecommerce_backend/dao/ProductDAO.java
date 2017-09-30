package com.niit.ecommerce_backend.dao;



import java.util.ArrayList;

import com.niit.ecommerce_backend.model.Product;

import antlr.collections.List;


public interface ProductDAO {
	public void saveProduct(Product product);
	public ArrayList<Product> getProdByCatId(int ca);
	public Product getProdById(int pr) ;
	public void deleteproduct(int id);
}
