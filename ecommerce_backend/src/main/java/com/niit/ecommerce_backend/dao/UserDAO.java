package com.niit.ecommerce_backend.dao;


import java.util.ArrayList;

import com.niit.ecommerce_backend.model.User;

public interface UserDAO {
	public void saveUser(User user);
	public ArrayList<User> getUserByUsername(String email);
	public void changepassword(String email, String pass);
	public void deleteuserbyemail(String email);
	public ArrayList<User> getallusers();
}