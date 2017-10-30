package com.niit.ecommerce_backend.dao;

import java.util.ArrayList;

import com.niit.ecommerce_backend.model.Contact;

public interface ContactDAO {
	
	public void savecontact(Contact c);
	public ArrayList<Contact> getallmessages() ;
	public void deletecontactbyid(int id) ;
}
