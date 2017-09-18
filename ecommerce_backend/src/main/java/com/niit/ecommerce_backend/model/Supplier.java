package com.niit.ecommerce_backend.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import java.io.*;
@SuppressWarnings("unused")
@Entity
@Component
@Table(name="SUPPLIER")
public class Supplier {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	

	private int id;
    @Column(name = "Suppliername", nullable = false)
    private String suppname;
    
    @Column(name = "Supplieraddress", nullable = false)
    private String suppdesc;
  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSuppname() {
		return suppname;
	}
	public void setSuppname(String suppname) {
		this.suppname = suppname;
	}
	public String getSuppdesc() {
		return suppdesc;
	}
	public void setSuppdesc(String suppdesc) {
		this.suppdesc = suppdesc;
	}
	
   

}
