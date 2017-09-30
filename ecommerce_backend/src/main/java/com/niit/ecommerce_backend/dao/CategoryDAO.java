package com.niit.ecommerce_backend.dao;

import java.util.ArrayList;

import com.niit.ecommerce_backend.model.Category;

public interface CategoryDAO {
	public void savecategory(Category category);
	public ArrayList<Category> getallcategories();
	public Category getcatbyid(int cat);
	public void deletecategory(int id);
}
