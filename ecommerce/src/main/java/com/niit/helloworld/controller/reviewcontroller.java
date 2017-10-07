package com.niit.helloworld.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce_backend.daoimpl.CategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ProductDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ReviewDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SubcategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SupplierDAOImpl;
import com.niit.ecommerce_backend.daoimpl.UserDAOImpl;
import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Product;
import com.niit.ecommerce_backend.model.Review;

@Controller

public class reviewcontroller {
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
	
	
	@RequestMapping("/review")
	public ModelAndView offer(@RequestParam("prid") int id,@RequestParam("name") String name,@RequestParam("desc") String rev) {
		ModelAndView mv1 = new ModelAndView("product");
		Review r= new Review();
		r.setPrid(id);
		r.setCustname(name);
		r.setReview(rev);
		rdao.savereview(r);
		Product ll=new Product();
		ll=pdao.getProdById(id);
		mv1.addObject("prod",ll);
		ArrayList<Review> rr= new ArrayList<Review>();
		rr=rdao.getrevbyprid(id);
		
		

		
		
		
		
		
		mv1.addObject("rev",rr);
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
			
		 
			
			mv1.addObject("catego",l);
		return mv1;
	
	}
	


	
	
	

}

