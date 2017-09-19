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
	@Column(name = "Suppliername", nullable = false)
    private String Supplier;
	@Column(name = "Categoryname", nullable = false)
    private String Category;
	@Column(name = "stock", nullable = false)
    private int stock;
    public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSupplier() {
		return Supplier;
	}

	public void setSupplier(String supplier) {
		Supplier = supplier;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

