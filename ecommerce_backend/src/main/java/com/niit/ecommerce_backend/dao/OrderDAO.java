package com.niit.ecommerce_backend.dao;

import java.util.ArrayList;

import com.niit.ecommerce_backend.model.Order;

public interface OrderDAO {
	
	public void addorder(Order o);
	public void updateorder(Order o);
	public ArrayList<Order> getorderbyemail(String namees);
	public ArrayList<Order> getallundeliveredprods();
	public void deleteorder(Order namees); 
	public Order getorderbyid(int id); 
}
