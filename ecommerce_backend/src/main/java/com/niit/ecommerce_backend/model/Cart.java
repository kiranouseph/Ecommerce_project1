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
	@Column(name = "CART_ID", nullable = false) 
	
   	private int cartid;
@Column(name = "Orderid", nullable = false) 
	
   	private int orderid;

@Column(name = "quantity", nullable = false) 

	private int quantity;

@Column(name = "price", nullable = false) 

	private int price;


@Column(name = "productid", nullable = false) 

private int productid;

@Column(name = "username", nullable = false) 

private String username;

@Column(name = "status", nullable = false) 

private int status;


@ManyToOne
@JoinColumn(name="useremail",updatable=true,insertable=true,nullable=false)
private User user;

	public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
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
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
	public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
   
    
   

}
