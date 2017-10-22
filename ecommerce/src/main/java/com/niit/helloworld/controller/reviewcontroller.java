package com.niit.helloworld.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.ecommerce_backend.dao.CategoryDAO;
import com.niit.ecommerce_backend.dao.ProductDAO;
import com.niit.ecommerce_backend.dao.ReviewDAO;
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
import com.niit.ecommerce_backend.model.Product;
import com.niit.ecommerce_backend.model.Review;
import com.niit.ecommerce_backend.model.User;
//for controlling the reviews of the product
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
	
	//for setting the review for a product with the name of the customer
	@RequestMapping("/review")
	public ModelAndView offer(@RequestParam("prid") int id,@RequestParam("name") String name,@RequestParam("desc") String rev) {
		ModelAndView mv1 = new ModelAndView("redirect:/prod?id+"+id);
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
			
			//for getting the email of the logined user and to find the role whether admni user or supplier
			org.springframework.security.core.Authentication authent = SecurityContextHolder.getContext().getAuthentication();
			 String namees = authent.getName();
			 if(namees!="anonymousUser")
			 {
			 ArrayList<User> userer=udao.getUserByUsername(namees);
			 for(User u:userer)
			 {
				 mv1.addObject("role", u.getRole());
			 }
			 }
			 else
			 {
				 mv1.addObject("role","ROLE_USER");
			 }
			 
		return mv1;
	
	}
	



	

}

