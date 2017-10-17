package com.niit.helloworld.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce_backend.daoimpl.CartDAOImpl;
import com.niit.ecommerce_backend.daoimpl.CategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ProductDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ReviewDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SubcategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SupplierDAOImpl;
import com.niit.ecommerce_backend.daoimpl.UserDAOImpl;
import com.niit.ecommerce_backend.model.Cart;
import com.niit.ecommerce_backend.model.User;
@Controller
public class paymentcontroller {
	
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
	private MailSender sendmail;
	
	
	
	@RequestMapping("/badd")
	public ModelAndView badd(@RequestParam("name") String name,@RequestParam("add1") String add1,@RequestParam("add2") String add2,@RequestParam("city") String city,@RequestParam("state") String state,@RequestParam("pin") int pin)
	{ModelAndView mv1=new ModelAndView();
		String badd=name+" "+add1+" "+add2+" "+city+" "+state+" "+pin;
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
		 String prid="";
		 String quantity="";
		 String price="";
		 String total="";
		
		 ArrayList<Cart> cartt=new ArrayList<Cart>();
			cartt=cartdao.getcartitemsbyname(namees);
			mv1.addObject("cartt", cartt);
			for(Cart c:cartt )
			{
			prid=prid+" "+c.getProduct().getId();
			quantity=quantity+" "+c.getQuantity();
			price=price+" "+c.getPrice();
			total=total+" "+(c.getPrice()*c.getQuantity());
			}
		
			
		
		
		
		
		
		
		
		mv1.addObject("addr",1);
		return mv1;
		
	}
	
	
	@RequestMapping("/sadd")
	public ModelAndView sadd(@RequestParam("name") String name,@RequestParam("add1") String add1,@RequestParam("add2") String add2,@RequestParam("city") String city,@RequestParam("state") String state,@RequestParam("pin") int pin)
	{ModelAndView mv1=new ModelAndView();
		String sadd=name+" "+add1+" "+add2+" "+city+" "+state+" "+pin;
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
		 
		
			
		
		
		
		
		
		
		
		 mv1.addObject("addr",2);
		return mv1;
	}
	
		@RequestMapping("/pay")
		public ModelAndView pay(@RequestParam("cardnum") String cardnum,@RequestParam("cardexp") String cardexp,@RequestParam("cardcv") String cardcv,@RequestParam("coupencode") String coupencode)
		{ModelAndView mv1=new ModelAndView();
			
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
			 
			
				
			
			
			
			
			
			
			
			 mv1.addObject("addr",3);
			return mv1;
		
	}
		
		@RequestMapping("/placeorder")
		public ModelAndView placeorder()
		{ModelAndView mv1=new ModelAndView();
			
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
			 
			
				
			
			
			
			
			
			
			
			 SimpleMailMessage emaill = new SimpleMailMessage();
		        emaill.setTo(namees);
		        emaill.setSubject("Placed order");
		        emaill.setText("order placed successfully");
		        // sends the e-mail
		        sendmail.send(emaill);
			    
			return mv1;
		
	}
		
	
		
	
	
	
	

}
