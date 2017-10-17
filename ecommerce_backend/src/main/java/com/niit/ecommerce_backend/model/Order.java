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
@Table(name="ORDER")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
   	private int orderid;
	
	@Column(name = "Shippingaddress", nullable = true) 
	private String saddress;
	
	@Column(name = "Billingaddress", nullable = true) 
	private String baddress;
	
	@Column(name = "prid", nullable = true)
	private int prid;
	@Column(name = "Quantity", nullable = true) 
	private int quantity;
	
	@Column(name = "price", nullable =  true) 
	private int price;
	
	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getBaddress() {
		return baddress;
	}

	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}

	public int getPrid() {
		return prid;
	}

	public void setPrid(int prid) {
		this.prid = prid;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}

	public int getCvnumber() {
		return cvnumber;
	}

	public void setCvnumber(int cvnumber) {
		this.cvnumber = cvnumber;
	}

	public int getExpdate() {
		return expdate;
	}

	public void setExpdate(int expdate) {
		this.expdate = expdate;
	}

	public int getCcode() {
		return ccode;
	}

	public void setCcode(int ccode) {
		this.ccode = ccode;
	}

	@Column(name = "total", nullable = true) 
	private int total;
	
	@Column(name = "cardnumber", nullable =  true) 
	private int cardnumber;
	
	@Column(name = "cvnumber", nullable =  true) 
	private int cvnumber;
	
	@Column(name = "expdate", nullable =  true) 
	private int expdate;
	
	@Column(name = "couponcode", nullable =  true) 
	private int ccode;
	

}
