package com.niit.helloworld.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
import com.niit.ecommerce_backend.daoimpl.OrderDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ProductDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ReviewDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SubcategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SupplierDAOImpl;
import com.niit.ecommerce_backend.daoimpl.UserDAOImpl;
import com.niit.ecommerce_backend.model.Cart;
import com.niit.ecommerce_backend.model.Order;
import com.niit.ecommerce_backend.model.Product;
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
	OrderDAOImpl odao;
	@Autowired
	private MailSender sendmail;
	
	
	
	@RequestMapping("/badd")
	public ModelAndView badd(@RequestParam("name") String name,@RequestParam("add1") String add1,@RequestParam("add2") String add2,@RequestParam("city") String city,@RequestParam("state") String state,@RequestParam("pin") int pin)
	{ModelAndView mv1=new ModelAndView("orderconfirm");
		String badd=name+","+add1+","+add2+","+city+","+state+","+pin;
		
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
			int total=0;
			
			for(Cart c:cartt )
			{
			     total=total+(c.getPrice()*c.getQuantity());
			
			}
		Order o =new Order();
		o.setBaddress(badd);
		o.setTotal(total);
		o.setEmail(namees);
		o.setBcon(1);
		
		
	
	
		
		odao.addorder(o);
	
		ArrayList<Order> or=new ArrayList<Order>();
		or=odao.getorderbyemail(namees);
		for(Order s:or)
		{
			mv1.addObject("bill",s.getBaddress());
			mv1.addObject("bcon",s.getBcon());
			mv1.addObject("scon",s.getScon());
			mv1.addObject("paycon",s.getPaycon());
		}	
		
		
		
		
		
		
		mv1.addObject("status",2);
		mv1.addObject("total",total);

		return mv1;
		
	}
	
	
	@RequestMapping("/sadd")
	public ModelAndView sadd(@RequestParam("name") String name,@RequestParam("add1") String add1,@RequestParam("add2") String add2,@RequestParam("city") String city,@RequestParam("state") String state,@RequestParam("pin") int pin)
	{ModelAndView mv1=new ModelAndView("orderconfirm");
		String sadd=name+","+add1+","+add2+","+city+","+state+","+pin;
		
	
		org.springframework.security.core.Authentication authent = SecurityContextHolder.getContext().getAuthentication();
		 String namees = authent.getName();
		 
		 ArrayList<Order> or=new ArrayList<Order>();
			or=odao.getorderbyemail(namees);
			for(Order s:or)
			{
				s.setSaddress(sadd);
				s.setScon(1);
				odao.updateorder(s);
				
			}
		 
		 
		 
		 
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
		 
			ArrayList<Order> orr=new ArrayList<Order>();
		orr=odao.getorderbyemail(namees);
		for(Order s:orr)
		{
			mv1.addObject("bill",s.getBaddress());
			mv1.addObject("ship",s.getSaddress());
			System.err.println(s.getSaddress());
			mv1.addObject("bcon",s.getBcon());
			mv1.addObject("scon",s.getScon());
			mv1.addObject("paycon",s.getPaycon());
		}
	
		
		
		
		
		
		
		 ArrayList<Cart> cartt=new ArrayList<Cart>();
			cartt=cartdao.getcartitemsbyname(namees);
			mv1.addObject("cartt", cartt);
		
			
int total=0;
			
			for(Cart c:cartt )
			{
			     total=total+(c.getPrice()*c.getQuantity());
			
			}
		mv1.addObject("status",2);
		mv1.addObject("total",total);
		
		return mv1;
	}
	
		@RequestMapping("/pay")
		public ModelAndView pay(@RequestParam("cardnum") int cardnum,@RequestParam("cardexp") int cardexp,@RequestParam("cardcv") int cardcv,@RequestParam("coupencode") int coupencode)
		{ModelAndView mv1=new ModelAndView("orderconfirm");
			String card=cardnum+","+cardexp+","+cardcv+","+coupencode;
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
			 
			
			 ArrayList<Order> or=new ArrayList<Order>();
				or=odao.getorderbyemail(namees);
				for(Order s:or)
				{
					
					s.setCarddetaisl(card);
					s.setPaycon(1);
					odao.updateorder(s);
				
				}	
			
			
			
				 
				ArrayList<Order> orr=new ArrayList<Order>();
			orr=odao.getorderbyemail(namees);
			for(Order s:orr)
			{
				mv1.addObject("bill",s.getBaddress());
				mv1.addObject("ship",s.getSaddress());
				mv1.addObject("paym",s.getCarddetaisl());
				mv1.addObject("bcon",s.getBcon());
				mv1.addObject("scon",s.getScon());
				mv1.addObject("paycon",s.getPaycon());
			}
			
			
			 ArrayList<Cart> cartt=new ArrayList<Cart>();
				cartt=cartdao.getcartitemsbyname(namees);
				int total=0;
				
				for(Cart c:cartt )
				{
				     total=total+(c.getPrice()*c.getQuantity());
				
				}
				
				mv1.addObject("cartt", cartt);
				mv1.addObject("total",total);
				mv1.addObject("status",2);
			
			return mv1;
		
	}
		
		@RequestMapping("/placeorder")
		public ModelAndView placeorder()
		{ModelAndView mv1=new ModelAndView("successorder");
			
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
			 
			String ship=null;
			String bill = null;
			 ArrayList<Order> or=new ArrayList<Order>();
				or=odao.getorderbyemail(namees);
				for(Order s:or)
				{
					
					
					s.setPlacecon(1);
					s.setDelivered(0);
					odao.updateorder(s);
					
					
					
					
					
					 ship=s.getSaddress();
					 bill=s.getBaddress();
				
				}	
				
			int tota=0;
				String name="";
				String name1="";
				ArrayList<Cart> cartt=new ArrayList<Cart>();
				cartt=cartdao.getcartitemsbyname(namees);
				for(Cart ca:cartt)
				{
				int tot=ca.getPrice()*ca.getQuantity();
				name=name+"&nbsp&nbsp&nbsp"+ca.getProduct().getProdname()+"&nbsp&nbsp&nbsp"+ca.getPrice()+"rs"+"&nbsp&nbsp&nbsp"+ca.getQuantity()+"no's"+"&nbsp&nbsp&nbsp"+"Total"+tot+"<br>";
				name1=name1+"       "+ca.getProduct().getProdname()+"         "+ca.getPrice()+"rs"+"       "+ca.getQuantity()+"no's"+"       "+"Total"+tot+"\n";
				cartdao.deletecartitem(ca.getCartid());
				tota=tota+tot;	
				}
			
			
				ArrayList<Order> orr=odao.getorderbyemail(namees);
				for(Order s:orr)
				{
					s.setOrderdetails(name);
					
					odao.updateorder(s);
				}
			
		
			
			ArrayList<Order> orrd=odao.getorderbyemail(namees);
			mv1.addObject("orrdd",orrd);
			SimpleMailMessage emaill = new SimpleMailMessage();
		    emaill.setTo(namees);
		    emaill.setSubject("YOUR ORDER IS PLACED");
		    emaill.setText("YOUR ORDERE FOR\n"+name1+"\n is placed and the total amount is"+ tota);
		    // sends the e-mail
		    sendmail.send(emaill);
			return mv1;
		
	}
		
	
		
	
	
	
	

}
