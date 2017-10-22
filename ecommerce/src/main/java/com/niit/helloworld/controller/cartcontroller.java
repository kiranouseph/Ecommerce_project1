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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.ecommerce_backend.dao.CategoryDAO;
import com.niit.ecommerce_backend.dao.ProductDAO;
import com.niit.ecommerce_backend.dao.SubcategoryDAO;
import com.niit.ecommerce_backend.dao.SupplierDAO;
import com.niit.ecommerce_backend.dao.UserDAO;
import com.niit.ecommerce_backend.daoimpl.CartDAOImpl;
import com.niit.ecommerce_backend.daoimpl.CategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.OrderDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ProductDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ReviewDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SubcategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SupplierDAOImpl;
import com.niit.ecommerce_backend.daoimpl.UserDAOImpl;
import com.niit.ecommerce_backend.model.Cart;
import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Order;
import com.niit.ecommerce_backend.model.Product;
import com.niit.ecommerce_backend.model.User;
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
	@Autowired
	OrderDAOImpl odao;
	
	//redirection to cart from header
	@RequestMapping("/cart")
	public ModelAndView cart() {
		
 int total=0;
//for getting the email of the logined user and to find the role whether admni user or supplier
 org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 String name = auth.getName();
 
		ModelAndView mv1 = new ModelAndView("cart");
		ArrayList<Cart> cartt=new ArrayList<Cart>();
	
		cartt=cartdao.getcartitemsbyname(name);
		mv1.addObject("cartt", cartt);
		//for calculating the subtotal of the cart of a user by email
		for(Cart ca:cartt)
		{
		int tot=ca.getPrice()*ca.getQuantity();
		total=total+tot;	
		}
		
		mv1.addObject("total",total);
		
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
	

	
	
	//for adding items to cart 
	@RequestMapping("/addcart")
	public ModelAndView addcart(@RequestParam("id") int id,@RequestParam("quan") int quan)
	{ 
		//for getting the email of the logined user and to find the role whether admni user or supplier
		 org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName();
	     Cart cart=new Cart();
		
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
	
	//if the product exist the quantity is incremented by 1
	if(flag==1)
	{
		
		Cart ct=cartdao.getcartitembyid(imp);
		int quant=ct.getQuantity();
		quant=quant+quan;
		
		cartdao.updatequan(imp,quant);
	}
	
	//new product new row is created in cart table
	else
	{
		cart.setUsername(name);
cart.setQuantity(quan);
		
		
		Product p=new Product();
		p=cartdao.getprodbyid(id);
		if(p.getOfferprice()!=0)
		{
		cart.setPrice(p.getOfferprice()); //price if there is a offer 	
		}
		else
		{
			cart.setPrice(p.getPrice());  //price if no offer
		}
		
		cart.setProduct(p);
		
		cartdao.addcart(cart);
			
		
	}
	Product p=new Product();
	p=pdao.getProdById(id);
	p.setStock(p.getStock()-quan);
	pdao.updateproduct(p);
	
	
		
		
		
		ModelAndView mv1 = new ModelAndView("redirect:/cart");
		Product ll=new Product();
		ll=pdao.getProdById(id);
		
		mv1.addObject("prod",ll);
		
		
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
	
	

//for updating cart 
	@RequestMapping("/cartretrieve")
	public ModelAndView cartretrieve(@RequestParam("id") int cartid) {
		
		ModelAndView mv1 = new ModelAndView("updatecart");
		Cart car=new Cart();
		car=cartdao.getcartitembyid(cartid);
		mv1.addObject("cartt", car);
		
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
		 
		
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
			
		 
			
			mv1.addObject("catego",l);
		return mv1;
	
	

	}
	
	
	@RequestMapping("/cartupdate")
	public ModelAndView cartupdate(@RequestParam("id") int cartid,@RequestParam("quantity") int quan,@RequestParam("prid") int prid) {
		
		ModelAndView mv1 = new ModelAndView("redirect:/cart");

		Cart car =cartdao.getcartitembyid(cartid);
		
	
		Product pp=pdao.getProdById(prid);
		pp.setStock(pp.getStock()-(quan-car.getQuantity()));
		pdao.updateproduct(pp);
		
		//for getting the email of the logined user and to find the role whether admni user or supplier
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String namee = auth.getName();
	    car.setCartid(cartid);
	     car.setUsername(namee); 
		car.setQuantity(quan);
		Product p=new Product();
		p=cartdao.getprodbyid(prid);
		car.setProduct(p);
		car.setPrice(p.getPrice());
		cartdao.updatecartitem(car);
		
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
		 
		
		 ArrayList<Cart> cartt=new ArrayList<Cart>();
			
			cartt=cartdao.getcartitemsbyname(namees);
			mv1.addObject("cartt", cartt);
			
			
			ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
			
			 
			
			mv1.addObject("catego",l);
		return mv1;
	
	

	}
	
	
	
	
	
	
	//for deleting cart item by cartid
	@RequestMapping("/cartdelete")
	public ModelAndView cartdelete(@RequestParam("id") int cartid) {
		
	
		Cart c=cartdao.getcartitembyid(cartid);
		Product pp=pdao.getProdById(c.getProduct().getId());
		pp.setStock(pp.getStock()+c.getQuantity());
		pdao.updateproduct(pp);
		cartdao.deletecartitem(cartid);
		
		ModelAndView mv1 = new ModelAndView("redirect:/cart");
ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		
		 org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName();
	     ArrayList<Cart> cartt=new ArrayList<Cart>();
	     cartt=cartdao.getcartitemsbyname(name);
			mv1.addObject("cartt", cartt);
			int total=0;
			
			//for calcluating the sumtotal of the products of the cart
			for(Cart ca:cartt)
			{
			int tot=ca.getPrice()*ca.getQuantity();
			total=total+tot;	
			}
			
			mv1.addObject("total",total);
			
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
	
	

	@RequestMapping("/checkout")
	public ModelAndView checkout(@RequestParam("st") int st)
	{
		int total=0;
		ModelAndView mv1 = new ModelAndView("orderconfirm");
		
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
			mv1.addObject("status",2);
			
			ArrayList<Cart> cartt=new ArrayList<Cart>();
			
			cartt=cartdao.getcartitemsbyname(namees);
			mv1.addObject("cartt", cartt);
			for(Cart c:cartt )
			{
			total=total+(c.getPrice()*c.getQuantity());	
			}
		 mv1.addObject("total",total);
		 
		 
		 if(st==10)
		 {
				ArrayList<Order> or=new ArrayList<Order>();
				or=odao.getorderbyemail(namees);
				for(Order s:or)
				{
					mv1.addObject("bill",s.getBaddress());
					mv1.addObject("bcon",s.getBcon());
					mv1.addObject("scon",s.getScon());
					mv1.addObject("paycon",s.getPaycon());
				}	
				 
			 
		 }
		 else
		 {
		 mv1.addObject("bcon",0);
		 mv1.addObject("scon",0);
		 mv1.addObject("paycon",0);
		 }
		return mv1;
	}
	

}
