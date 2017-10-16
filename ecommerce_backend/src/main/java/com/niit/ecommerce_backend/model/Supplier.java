package com.niit.ecommerce_backend.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Set;
@SuppressWarnings("unused")
@Entity
@Component
@Table(name="SUPPLIER")
public class Supplier {
	
	@Id
   

	private int id;
    @Column(name = "Suppliername", nullable = false)
    private String suppname;
    
    @Column(name = "Supplieraddress", nullable = false)
    private String suppdesc;
    @Column(name = "suppemail", nullable = false)
    private String suppemail;
    public String getSuppemail() {
		return suppemail;
	}
	public void setSuppemail(String suppemail) {
		this.suppemail = suppemail;
	}
	@OneToMany(cascade = CascadeType.DETACH,targetEntity=Product.class,mappedBy="supplier",fetch=FetchType.EAGER)
    private Set<Product> product;
  
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
	
	public String getSuppname() {
		return suppname;
	}
	public void setSuppname(String suppname) {
		this.suppname = suppname;
	}
	public String getSuppdesc() {
		return suppdesc;
	}
	public void setSuppdesc(String suppdesc) {
		this.suppdesc = suppdesc;
	}
	
   

}
