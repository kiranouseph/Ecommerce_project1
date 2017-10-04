package com.niit.ecommerce_backend.dao;


import com.niit.ecommerce_backend.model.User;

public interface UserDAO {
	public void saveUser(User user);
	public User getUserByUsername(String email);
	public int checklogin(String email,String password);
}
