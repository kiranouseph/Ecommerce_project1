package com.niit.ecommerce_backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="Category")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
  
   	private int id;
	@Column(name = "Categoryname", nullable = false)
    private String Categoryname;
	@OneToMany(targetEntity=Product.class,mappedBy="category",cascade=CascadeType.ALL)
    private Set<Product> product ;
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryname() {
		return Categoryname;
	}
	public void setCategoryname(String categoryname) {
		Categoryname = categoryname;
	}
	

}
