package com.niit.ecommerce_backend.dao;

import com.niit.ecommerce_backend.model.Subcategory;

public interface SubcategoryDAO {
	public void saveProduct(Subcategory Subcategory) ;
	public Subcategory getscatbyid(int scat);
	public void deletesubcategory(int id);
}
