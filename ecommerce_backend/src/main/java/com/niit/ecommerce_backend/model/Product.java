package com.niit.ecommerce_backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Set;

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
   

	public int getOfferper() {
		return offerper;
	}

	public void setOfferper(int offerper) {
		this.offerper = offerper;
	}

	public int getCatnum() {
		return catnum;
	}

	public void setCatnum(int catnum) {
		this.catnum = catnum;
	}

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
	@Column(name = "offerper", nullable =false)
    private int offerper;
	@Column(name = "cate", nullable =false)
    private int catnum;
	@Column(name = "image", nullable =false)
    private String image;
	
	


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prodname=" + prodname + ", proddecs=" + proddecs + ", price=" + price
				+ ", stock=" + stock + ", offer=" + offer + ", offerprice=" + offerprice + ", offerper=" + offerper
				+ ", catnum=" + catnum + ", subcategory=" + subcategory + ", supplier=" + supplier + "]";
	}

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
    
	@OneToMany(targetEntity=Cart.class,mappedBy="product",cascade = CascadeType.DETACH,fetch=FetchType.EAGER)
    private Set<Cart> cart ;
   

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

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


