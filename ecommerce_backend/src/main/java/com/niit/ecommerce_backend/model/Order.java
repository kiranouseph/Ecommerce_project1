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
@Table(name="ORDERR")
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
	@Column(name = "bconfirm", nullable =  true) 
	private int bcon;
	@Column(name = "sconfirm", nullable =  true) 
	private int scon;
	@Column(name = "Payconfirm", nullable =  true) 
	private int paycon;
	@Column(name = "placeconfirm", nullable =  true) 
	private int placecon;
	
	public String getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(String orderdetails) {
		this.orderdetails = orderdetails;
	}

	@Column(name = "email", nullable =  true) 
	private String email;
	@Column(name = "orderdetails", nullable =  true) 
	private String orderdetails;
	
	


	public int getBcon() {
		return bcon;
	}

	public void setBcon(int bcon) {
		this.bcon = bcon;
	}

	public int getScon() {
		return scon;
	}

	public void setScon(int scon) {
		this.scon = scon;
	}

	public int getPaycon() {
		return paycon;
	}

	public void setPaycon(int paycon) {
		this.paycon = paycon;
	}

	public int getPlacecon() {
		return placecon;
	}

	public void setPlacecon(int placecon) {
		this.placecon = placecon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	
	
	
	

}
