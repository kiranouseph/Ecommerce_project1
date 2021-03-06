package com.niit.helloworld.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce_backend.dao.CartDAO;
import com.niit.ecommerce_backend.dao.CategoryDAO;
import com.niit.ecommerce_backend.dao.ContactDAO;
import com.niit.ecommerce_backend.dao.OrderDAO;
import com.niit.ecommerce_backend.dao.ProductDAO;
import com.niit.ecommerce_backend.dao.ReviewDAO;
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
import com.niit.ecommerce_backend.model.Order;
import com.niit.ecommerce_backend.model.Product;
import com.niit.ecommerce_backend.model.User;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;


import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Controller
public class paymentcontroller {
	
	@Autowired
	CartDAO cartdao;
	@Autowired
	UserDAO udao;
	@Autowired
	ProductDAO pdao;
	@Autowired
	CategoryDAO cdao;
	@Autowired
	SupplierDAO sdao;
	@Autowired
	SubcategoryDAO scdao;
	@Autowired
	ReviewDAO rdao;
	@Autowired
	OrderDAO odao;
	@Autowired
	private MailSender sendmail;
	@Autowired
	ContactDAO ctdao;
	
	 public static final String ACCOUNT_SID = "AC5381736be1859ec166d3fbe215597f47";
	    public static final String AUTH_TOKEN = "dd376562416ceb96cb898e01449a240c";
	    public static final String TWILIO_NUMBER = "+15037412491";

	
	@RequestMapping("/badd")
	public ModelAndView badd(@RequestParam("name") String name,@RequestParam("add1") String add1,@RequestParam("add2") String add2,@RequestParam("city") String city,@RequestParam("state") String state,@RequestParam("pin") int pin)
	{ModelAndView mv1=new ModelAndView("redirect:/checkout?st="+10);
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
		mv1.addObject("existorder",0);
		
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
				mv1.addObject("existorder",0);
				
			return mv1;
		
	}
		
		@RequestMapping("/placeorder")
		public ModelAndView placeorder()
		{ModelAndView mv1=new ModelAndView("successorder");
		long mob;
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
			
		
			ArrayList<User> u=udao.getUserByUsername(namees);
			
			
			ArrayList<Order> orrd=odao.getorderbyemail(namees);
			mv1.addObject("orrdd",orrd);
			SimpleMailMessage emaill = new SimpleMailMessage();
		    emaill.setTo(namees);
		    emaill.setSubject("YOUR ORDER IS PLACED");
		    emaill.setText("YOUR ORDERE FOR\n"+name1+"\n is placed and the total amount is"+ tota);
		    // sends the e-mail
		    sendmail.send(emaill);
for(User us:u)
{
	


			 try {
			        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
			 
			        // Build a filter for the MessageList
			        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			        params.add(new BasicNameValuePair("Body", "THANKS FOR SHOPPING FROM GIFTERY!\n"+"YOUR ORDERE FOR\n"+name1+"\n is placed and the total amount is"+ tota));
			        params.add(new BasicNameValuePair("To","918129925706")); //Add real number here
			        params.add(new BasicNameValuePair("From", TWILIO_NUMBER));
			 
			        MessageFactory messageFactory = client.getAccount().getMessageFactory();
			        Message message = messageFactory.create(params);
			        System.out.println(message.getSid());
			    } 
			    catch (TwilioRestException e) {
			        System.out.println(e.getErrorMessage());
		    }

			
}
return mv1;
		
	}
		
	
		
	
	

	

}
