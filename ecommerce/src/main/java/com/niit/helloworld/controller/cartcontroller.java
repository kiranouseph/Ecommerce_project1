package com.niit.helloworld.controller;

import java.lang.annotation.Annotation;
import java.security.Security;
import java.util.ArrayList;

import org.apache.tomcat.util.net.jsse.openssl.Authentication;
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
	
	//redirection to cart from header
	@RequestMapping("/user/cart")
	public ModelAndView cart(@RequestParam("name") String name) {
		
 int total=0;
 
		ModelAndView mv1 = new ModelAndView("cart");
		ArrayList<Cart> cartt=new ArrayList<Cart>();
	
		cartt=cartdao.getcartitemsbyname(name);
		mv1.addObject("cartt", cartt);
		for(Cart ca:cartt)
		{
		int tot=ca.getPrice()*ca.getQuantity();
		total=total+tot;	
		}
		
		mv1.addObject("total",total);
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
	
		return mv1;
	}
	
	
	//for adding items to cart
	@RequestMapping("user/addcart")
	public ModelAndView addcart(@RequestParam("id") int id,@RequestParam("name") String name)
	{ Cart cart=new Cart();
		
int flag=0,imp=0;
	ArrayList<Cart> cartt=new ArrayList<Cart>();
	
	cartt=cartdao.getcartitemsbyname(name);
	for(Cart cr:cartt )
	{
		Product ppp=cr.getProduct();
		if(ppp.getId()==id)
		{
			flag=1;
			imp=cr.getCartid();
		}
	}
	if(flag==1)
	{
		
		Cart ct=cartdao.getcartitembyid(imp);
		int quant=ct.getQuantity();
		quant=quant+1;
		cartdao.updatequan(imp,quant);
	}
	else
	{
		cart.setUsername(name);
cart.setQuantity(1);
		
		
		Product p=new Product();
		p=cartdao.getprodbyid(id);
		
		cart.setPrice(p.getPrice());
		cart.setProduct(p);
		
		cartdao.addcart(cart);
			
		
	}
		
		
		
		ModelAndView mv1 = new ModelAndView("product");
		Product ll=new Product();
		ll=pdao.getProdById(id);
		
		mv1.addObject("prod",ll);
		
		
ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
	
		return mv1;
	}
//for updating cart
	@RequestMapping("/user/cartretrieve")
	public ModelAndView cartretrieve(@RequestParam("id") int cartid) {
		
		ModelAndView mv1 = new ModelAndView("updatecart");
		Cart car=new Cart();
		car=cartdao.getcartitembyid(cartid);
		mv1.addObject("cartt", car);
		
		
		
		
	
		return mv1;
	
	

	}
	
	
	@RequestMapping("/user/cartupdate")
	public ModelAndView cartupdate(@RequestParam("id") int cartid,@RequestParam("quantity") int quan) {
		
		ModelAndView mv1 = new ModelAndView("cart");

		Cart car =new Cart();
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String namee = auth.getName();
	     car.setUsername(namee); 
		car.setQuantity(quan);
		Product p=new Product();
		p=cartdao.getprodbyid(cartid);
		car.setProduct(p);
		car.setPrice(p.getPrice());
		cartdao.updatecartitem(car);
		
		
	
		
		
		return mv1;
	
	

	}
	
	
	
	
	
	
	//for deleting cart item by cartid
	@RequestMapping("/user/cartdelete")
	public ModelAndView cartdelete(@RequestParam("id") int cartid) {
		
		cartdao.deletecartitem(cartid);
		ModelAndView mv1 = new ModelAndView("cart");
ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		
		 org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName();
	     ArrayList<Cart> cartt=new ArrayList<Cart>();
	     cartt=cartdao.getcartitemsbyname(name);
			mv1.addObject("cartt", cartt);
			int total=0;
			for(Cart ca:cartt)
			{
			int tot=ca.getPrice()*ca.getQuantity();
			total=total+tot;	
			}
			
			mv1.addObject("total",total);
			
		
		
		
		return mv1;
		
	
	

	}
	

}
