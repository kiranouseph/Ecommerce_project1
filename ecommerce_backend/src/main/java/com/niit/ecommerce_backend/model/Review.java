package com.niit.ecommerce_backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


import java.io.*;
import java.util.Set;
@Entity
@Component
@Table(name="REVIEW")
public class Review implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)

   	private int id;
	@Column(name = "CUSTOMER_NAME", nullable = false)
    private String Custname;
	@Column(name = "Product_id", nullable = false)
    private int prid;
	@Column(name = "starrating", nullable = false)
    private int star;
	
	
	

	public int getPrid() {
		return prid;
	}
	public void setPrid(int prid) {
		this.prid = prid;
	}
	@Column(name = "review", nullable = false)
    private String review;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustname() {
		return Custname;
	}
	public void setCustname(String custname) {
		Custname = custname;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	
	
	
	

}