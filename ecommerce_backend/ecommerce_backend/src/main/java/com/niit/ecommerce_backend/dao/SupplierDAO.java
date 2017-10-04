package com.niit.ecommerce_backend.dao;


import java.util.ArrayList;

import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Supplier;

public interface SupplierDAO {
	public void saveProduct(Supplier supplier);
	public ArrayList<Supplier> getallsuppliers();
	public void deletesupplier(int id);
	public void updatesupplier(Supplier s);
}
