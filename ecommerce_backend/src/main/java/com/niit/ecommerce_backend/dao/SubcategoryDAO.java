package com.niit.ecommerce_backend.dao;

import java.util.ArrayList;

import com.niit.ecommerce_backend.model.Subcategory;

public interface SubcategoryDAO {
	public void savesubcategory(Subcategory Subcategory) ;
	public Subcategory getscatbyid(int scat);
	public void deletesubcategory(int id);
	public ArrayList<Subcategory> getallsubcategories();
	public ArrayList<Subcategory> getsubcatByCatId(int ca);
	public void updatesubcategory(Subcategory sc);}
