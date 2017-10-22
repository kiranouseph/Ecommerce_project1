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
@Table(name="CONTACT")
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)

  	private int id;
	@Column(name = "EMAILID", nullable = false)
   private String email;
	@Column(name = "NAME", nullable = false)
   private String name;
	@Column(name = "Subject", nullable = false)
   private String subject;
	@Column(name = "MESSAGE", nullable = false)
	   private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
