package com.niit.ecommerce_backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import java.io.*;

@Entity
@Component
@Table(name="CART")
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	
   	private int cartid;

	
	@Column(name = "Quantity", nullable = false) 
	private int quantity;

@Column(name = "price", nullable = false) 

	private int price;



@Column(name = "username", nullable = false) 

private String username;




@ManyToOne
@JoinColumn(name="prid",updatable=true,insertable=true,nullable=false)
private Product product;

	
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}


public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

	
	public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
   
    
   

}
