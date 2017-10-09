package com.niit.ecommerce_backend.dao;



import java.util.ArrayList;

import com.niit.ecommerce_backend.model.Product;

import antlr.collections.List;


public interface ProductDAO {
	public void saveProduct(Product product);
	public ArrayList<Product> getProdByscatId(int ca);
	public Product getProdById(int pr) ;
	public void deleteproduct(int id);
	public ArrayList<Product> getallproducts();
	public ArrayList<Product> listof_offerProducts();
	public void setoffers(int id,int offprice,int orgprice);
	public void deleteoffer(int id);
	public void updateproduct( Product p);
}
