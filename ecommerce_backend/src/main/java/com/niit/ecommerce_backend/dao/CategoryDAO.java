package com.niit.ecommerce_backend.dao;

import java.util.ArrayList;

import com.niit.ecommerce_backend.model.Category;

public interface CategoryDAO {
	public void saveProduct(Category category);
	public ArrayList<Category> getallcategories();
	

}
