package com.niit.ecommerce_backend.dao;

import java.util.ArrayList;

import com.niit.ecommerce_backend.model.Cart;
import com.niit.ecommerce_backend.model.Product;

public interface CartDAO {

	
	 public void addcart(Cart cart);
	 public Product getprodbyid(int id);
	 public ArrayList<Cart> getcartitemsbyname(String name) ;
	 public void deletecartitem(int cartid);
	 public Cart getcartitembyid(int cartid);
	 public void updatecartitem(Cart cart);
	 public void updatequan(int imp, int i) ;
}
