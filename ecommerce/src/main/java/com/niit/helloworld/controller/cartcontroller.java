package com.niit.helloworld.controller;

import java.lang.annotation.Annotation;
import java.security.Security;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce_backend.dao.CategoryDAO;
import com.niit.ecommerce_backend.dao.ProductDAO;
import com.niit.ecommerce_backend.dao.SubcategoryDAO;
import com.niit.ecommerce_backend.dao.SupplierDAO;
import com.niit.ecommerce_backend.dao.UserDAO;
import com.niit.ecommerce_backend.daoimpl.CartDAOImpl;
import com.niit.ecommerce_backend.daoimpl.CategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ProductDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ReviewDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SubcategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SupplierDAOImpl;
import com.niit.ecommerce_backend.daoimpl.UserDAOImpl;
import com.niit.ecommerce_backend.model.Cart;
import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Product;
@SuppressWarnings("unused")
@Controller
public class cartcontroller {
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
	@Autowired
	CartDAOImpl cartdao;
	
	
	@RequestMapping("/user/cart")
	public ModelAndView cart(@RequestParam("name") String name) {
		
 
		ModelAndView mv1 = new ModelAndView("cart");
		ArrayList<Cart> cartt=new ArrayList<Cart>();
	
		cartt=cartdao.getcartitemsbyname(name);
		mv1.addObject("cartt", cartt);
		
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
	
		return mv1;
	}
	@RequestMapping("user/addcart")
	public ModelAndView addcart(@RequestParam("id") int id,@RequestParam("name") String name)
	{ Cart cart=new Cart();
		
 if(name==null)
 {
	 
	String namee=SecurityContextHolder.getContext().getAuthentication().getName();
	cart.setUsername(namee);
 }
 else
 {
	 cart.setUsername(name); 
 }
	
		
		cart.setQuantity(1);
		
		
		Product p=new Product();
		p=cartdao.getprodbyid(id);
		
		cart.setPrice(p.getPrice());
		cart.setProduct(p);
		
		cartdao.addcart(cart);
		
		ModelAndView mv1 = new ModelAndView("cart");
		
		
	
	
		return mv1;
	}

	
	
	
	

}
