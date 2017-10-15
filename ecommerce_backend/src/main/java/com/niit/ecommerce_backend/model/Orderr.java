package com.niit.ecommerce_backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="ORDERR")
public class Orderr implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getSaddress() {
		return saddress;
	}

	public void setSaddress(int saddress) {
		this.saddress = saddress;
	}

	public int getBaddress() {
		return baddress;
	}

	public void setBaddress(int baddress) {
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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
   	private int orderid;
	
	@Column(name = "Shipping_address", nullable = false) 
	private int saddress;
	
	@Column(name = "Billing address", nullable = false) 
	private int baddress;
	
	@Column(name = "prid", nullable = false) 
	private int prid;
	@Column(name = "Quantity", nullable = false) 
	private int quantity;
	
	@Column(name = "price", nullable = false) 
	private int price;
	
	@Column(name = "total", nullable = false) 
	private int total;
	
	@Column(name = "cardnumber", nullable = false) 
	private int cardnumber;
	
	@Column(name = "cvnumber", nullable = false) 
	private int cvnumber;
	
	@Column(name = "expdate", nullable = false) 
	private int expdate;
	
	@Column(name = "couponcode", nullable = false) 
	private int ccode;	
	

}
