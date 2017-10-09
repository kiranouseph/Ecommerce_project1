package com.niit.helloworld.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce_backend.dao.CategoryDAO;
import com.niit.ecommerce_backend.dao.ProductDAO;
import com.niit.ecommerce_backend.dao.SubcategoryDAO;
import com.niit.ecommerce_backend.dao.SupplierDAO;
import com.niit.ecommerce_backend.dao.UserDAO;
import com.niit.ecommerce_backend.daoimpl.CategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ProductDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ReviewDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SubcategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SupplierDAOImpl;
import com.niit.ecommerce_backend.daoimpl.UserDAOImpl;
import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Subcategory;
import com.niit.ecommerce_backend.model.Supplier;
@SuppressWarnings("unused")
@Controller


//admin level controller 
public class admincontroller {
	@Autowired
	UserDAOImpl udao;
	@Autowired
	ProductDAOImpl pdao;
	@Autowired
	CategoryDAOImpl cdao;
	@Autowired
	SupplierDAOImpl sdao;
	@Autowired
	SubcategoryDAOImpl scdao;
	@Autowired
	ReviewDAOImpl rdao;
	
	
	// if the admin link in home page is clicked it will be redirected to here 

	@RequestMapping("/admin")
	public ModelAndView admin() {
		
		ModelAndView mv1 = new ModelAndView("admin");
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
	
				mv1.addObject("catego",l);
		ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
		 
		
				
				mv1.addObject("suppli",ll);
ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
		 
		
				
				mv1.addObject("subcatego",lll);
		
		return mv1;
	}
	

}
