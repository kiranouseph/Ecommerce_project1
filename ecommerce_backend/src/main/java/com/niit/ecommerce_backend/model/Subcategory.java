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
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Set;
@Entity
@Component
@Table(name="SUBCATEGORY")
public class Subcategory implements Serializable {

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
  
   	private int id;
	@Column(name = "Subcategoryname", nullable = false)
    private String Subcategoryname;
	
	@OneToMany(targetEntity=Product.class,mappedBy="subcategory",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Product> product ;
	 @ManyToOne
	    @JoinColumn(name="c_id",updatable=true,insertable=true,nullable=false)
	    private  Category category;
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
	public String getSubcategoryname() {
		return Subcategoryname;
	}
	public void setSubcategoryname(String subcategoryname) {
		Subcategoryname = subcategoryname;
	}
	
	

}
