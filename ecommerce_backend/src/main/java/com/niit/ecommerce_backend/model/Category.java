package com.niit.ecommerce_backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Set;
@Entity
@Component
@Table(name="Category")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
  
   	private int id;
	@Column(name = "Categoryname", nullable = false)
    private String Categoryname;
	@Column(name = "Categorydesc", nullable = false)
    private String Categorydesc;
	public String getCategorydesc() {
		return Categorydesc;
	}
	public void setCategorydesc(String categorydesc) {
		Categorydesc = categorydesc;
	}
	@OneToMany(targetEntity=Subcategory.class,mappedBy="category",cascade = CascadeType.DETACH,fetch=FetchType.EAGER)
    private Set<Subcategory> ssubcategory ;
	
	
	public Set<Subcategory> getSsubcategory() {
		return ssubcategory;
	}
	public void setSsubcategory(Set<Subcategory> ssubcategory) {
		this.ssubcategory = ssubcategory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryname() {
		return Categoryname;
	}
	public void setCategoryname(String categoryname) {
		Categoryname = categoryname;
	}
	

}
