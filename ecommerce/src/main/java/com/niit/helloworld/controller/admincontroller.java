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

import com.niit.ecommerce_backend.dao.CategoryDAO;
import com.niit.ecommerce_backend.dao.ProductDAO;
import com.niit.ecommerce_backend.dao.SubcategoryDAO;
import com.niit.ecommerce_backend.dao.SupplierDAO;
import com.niit.ecommerce_backend.dao.UserDAO;
import com.niit.ecommerce_backend.daoimpl.CategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ContactDAOImpl;
import com.niit.ecommerce_backend.daoimpl.OrderDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ProductDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ReviewDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SubcategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SupplierDAOImpl;
import com.niit.ecommerce_backend.daoimpl.UserDAOImpl;
import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Contact;
import com.niit.ecommerce_backend.model.Order;
import com.niit.ecommerce_backend.model.Subcategory;
import com.niit.ecommerce_backend.model.Supplier;
import com.niit.ecommerce_backend.model.User;
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
	@Autowired
	OrderDAOImpl odao;
	@Autowired
	private MailSender sendmail;
	@Autowired
	ContactDAOImpl ctdao;
 
	
	
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
	@RequestMapping("/orders")
	public ModelAndView orders() {

		ModelAndView mv1 = new ModelAndView("orders");	
		
		
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
			
			
			mv1.addObject("catego",l);
	ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
	 
	
			
			mv1.addObject("suppli",ll);
ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
	 
	
			
			mv1.addObject("subcatego",lll);
			
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
		
		
		
		 ArrayList<Order> ord=odao.getallundeliveredprods();
		
		 
		 
		 
		 
		 mv1.addObject("orders",ord);
		
		return mv1;
		
	}
	
	
@RequestMapping("/shipped")

	public ModelAndView shipped(@RequestParam("id") int id)
{
		
	ModelAndView mv1 = new ModelAndView("redirect:/orders");	
	
	
	
	 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		
		mv1.addObject("catego",l);
ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();


		
		mv1.addObject("suppli",ll);
ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();


		
		mv1.addObject("subcatego",lll);
		
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
	
	
	
	 
	
	Order o=odao.getorderbyid(id);
	
	o.setDelivered(1);
odao.updateorder(o);
	SimpleMailMessage emaill = new SimpleMailMessage();
    emaill.setTo(o.getEmail());
    emaill.setSubject("YOUR GIFT SHIPPED");
    
    emaill.setText("The gifts you ordered with giftery is already shipped and will reach you soon.\nThe Amouny you should pay is"+o.getTotal()+"\n Thanks for shopping from giftery .Expecting  you corporation further");
    // sends the e-mail
    sendmail.send(emaill);
	

	Order oo=odao.getorderbyid(id);
	odao.deleteorder(oo);
	
    
    ArrayList<Order> ord=odao.getallundeliveredprods();
	
	 
	 
	 
	 
	 mv1.addObject("orders",ord);
	
	
	
	
	
	
	
	
	return mv1;
		
		
		
		
	}



@RequestMapping("/messages")

public ModelAndView messages()
{
	
ModelAndView mv1 = new ModelAndView("contact");	



ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();


mv1.addObject("catego",l);
ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();



mv1.addObject("suppli",ll);
ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();



mv1.addObject("subcatego",lll);

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


ArrayList<Contact> con=ctdao.getallmessages();
mv1.addObject("contacts", con);

return mv1;
}

@RequestMapping("/contact")

public ModelAndView contact(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("subject") String subject,@RequestParam("message") String message)
{
	ModelAndView mv1 = new ModelAndView("redirect:/");	

	ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
	
	
	mv1.addObject("catego",l);
ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();


	
	mv1.addObject("suppli",ll);
ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();


	
	mv1.addObject("subcatego",lll);
	
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
	
	Contact c=new Contact();
c.setEmail(email);
c.setMessage(message);
c.setSubject(subject);
c.setName(name);
ctdao.savecontact(c);
return mv1;


}
@RequestMapping("/deletecon")

public ModelAndView deletecon(@RequestParam("id") int id)
{
	
ModelAndView mv1 = new ModelAndView("redirect:/messages");	

ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();


mv1.addObject("catego",l);
ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();



mv1.addObject("suppli",ll);
ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();



mv1.addObject("subcatego",lll);

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


ctdao.deletecontactbyid(id);
ArrayList<Contact> con=ctdao.getallmessages();
mv1.addObject("contacts", con);

return mv1;
}


}