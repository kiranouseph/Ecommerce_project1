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
@Table(name="PRODUCTS")
public class Product implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id

   	private int id;
    @Column(name = "productname", nullable = false)
    private String prodname;
   

	@Column(name = "proddecs", nullable = false)
    private String proddecs;
	@Column(name = "price", nullable = false)
    private int price;
	@Column(name = "stock", nullable = false)
    private int stock;
	@Column(name = "offer", nullable =false)
    private int offer;
	@Column(name = "offerprice", nullable =false)
    private int offerprice;
	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public int getOfferprice() {
		return offerprice;
	}

	public void setOfferprice(int offerprice) {
		this.offerprice = offerprice;
	}

	@ManyToOne
    @JoinColumn(name="sc_id",updatable=true,insertable=true,nullable=false)
    private Subcategory subcategory;
	
    @ManyToOne
    @JoinColumn(name="s_id",updatable=true,insertable=true,nullable=false)
    private Supplier supplier;
    
	

	public Supplier getSupplier() {
		return supplier;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	
    public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	

	

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	
	public String getProddecs() {
		return proddecs;
	}

	public void setProddecs(String proddecs) {
		this.proddecs = proddecs;
	}



	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	


	

	

	
}


