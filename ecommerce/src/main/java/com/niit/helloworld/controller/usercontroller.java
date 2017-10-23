package com.niit.helloworld.controller;
 
import java.util.ArrayList;
import java.util.Random;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.niit.ecommerce_backend.model.Product;
import com.niit.ecommerce_backend.model.Subcategory;
import com.niit.ecommerce_backend.model.Supplier;
import com.niit.ecommerce_backend.model.User;

import antlr.collections.List;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
@SuppressWarnings("unused")
//home controller For the important redirections and operations
@Controller
public class usercontroller {
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
	private MailSender sendmail;
 
	
	
	
	
	
	
	
	
	
	//for loading the landing page at the start
	@RequestMapping("/")
	public ModelAndView home() {
		
		Random random= new Random();
		
		ModelAndView mv1 = new ModelAndView("index");
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
				
				mv1.addObject("catego",l);
//for retreiving the top offer of each category to shown in the dropdown carousel of header
				/*ArrayList<Product> topoff=new ArrayList<Product>();
				for(Category tpof:l)
				{
				
					topoff.add(pdao.gettopoffer(tpof.getId()));
					
				}
				for(Product pr:topoff)
				{
					System.err.println(pr);
				}
				mv1.addObject("topoff",topoff);

*/
				
				ArrayList<Product> prod=new ArrayList<Product>();			
	prod=pdao.listof_offerProducts();
	mv1.addObject("offproducts",prod);
	
	 ArrayList<Product> pp=new ArrayList<Product>();
	 pp=(ArrayList<Product>)pdao.listof_offerProducts();
	//for displaying special offers randomly from the offer list
	int index1 = random.nextInt(pp.size());
	 Product p1=pp.get(index1);
	 mv1.addObject("offp1",p1);
	 pp.remove(p1);
	 int index2 = random.nextInt(pp.size());
	 Product p2=pp.get(index2);
	 mv1.addObject("offp2",p2);
	 pp.remove(p2);
	 int index3 = random.nextInt(pp.size());
	 Product p3=pp.get(index3);
	 mv1.addObject("offp3",p3);
	 pp.remove(p3);
	 int index4 = random.nextInt(pp.size());
	 Product p4=pp.get(index4);
	 mv1.addObject("offp4",p4);
	 pp.remove(p4);
	 
	 
	 
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
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	
	//for redirections to login page from home page
	@RequestMapping("/login")
	public ModelAndView login() {
	
 
		ModelAndView mv1 = new ModelAndView("login");
		
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
	
	//for redirecting to password change page for supplier at first login
	@RequestMapping("/supd")
	public ModelAndView supplogin() {
	
 
		ModelAndView mv1 = new ModelAndView("supd");
		
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
	
	
	
	
		
		
		
		
		
		
		
		
		
		
	// for redirecting to register page
	@RequestMapping("/signup")
	public ModelAndView register() {
		
 
		
		 
		  
	
		
		
		
		
		
		
		
		
		
		
		ModelAndView mv1 = new ModelAndView("register");
		
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
	
	
	
	
	@RequestMapping("/about")
	public ModelAndView about() {
		
 
		
		 
		  
	/*
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("plavinpaul11@gmail.com");
        email.setSubject("ORDER CONFIRMATION");
        email.setText("YOUR OPRDER IS PLACED BE READY WITH 250 rs FOR THE ROSE BOUQUET OUR REPRESENTATIVES WILL CONTACT YOU SHORTLY KEEP BUYING FROM GIFTERY ");
         
        // sends the e-mail
        sendmail.send(email);
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		ModelAndView mv1 = new ModelAndView("about");
		
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
	
	
	
	
	
	
	
	
	
	

	//for adding the user details to database at time of sign in
	@RequestMapping("/addUser")
	public ModelAndView addUser(@RequestParam("name") String name,@RequestParam("mobno") long mobno,@RequestParam("email") String email, @RequestParam("password") String password) {
		
		
		User user=new User();
		user.setName(name);
		user.setMobno(mobno);
		user.setEmail(email);
		user.setPassword(password);
        user.setRole("ROLE_USER"); 
		udao.saveUser(user);
		ModelAndView mv1 = new ModelAndView("redirect:/login");
		
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
	
	
	//if username or password entered incorrect redirect to here
	@RequestMapping("/err")
	public ModelAndView logfail()
	{
		
		ModelAndView mv1 = new ModelAndView("login");
		mv1.addObject("MESSAGE", "INVALID USERNAME OR POSSWORD");
		
		
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
	
	
	
	//for submitting new password from supplier
	@RequestMapping("/spasupd")
	public ModelAndView passupd(@RequestParam("pass") String pass)
	
	{
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String name = auth.getName();
	udao.changepassword(name,pass);	
		
		
		
		ModelAndView mv1 = new ModelAndView("index");
		
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
	

	
	//redirection when an unauthorized access comes
	@RequestMapping("/error")
	public ModelAndView unauthoroized()
	{
		
		ModelAndView mv1 = new ModelAndView("error");
		
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
	
	
	
	
	
	
		
	/*for loading the product list ,category list,supplier list,subcategory list based on the 
	number send like 1,2,3,4
	1=product list
	2=category list
	3=subcategory list
	4=supplier list
	
	*/
	
	
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam("num") int ca,@RequestParam("f") String st) 
	{
		ArrayList<Product> p=new ArrayList<Product>();
		ArrayList<Category> c=new ArrayList<Category>();
		ArrayList<Subcategory> sc=new ArrayList<Subcategory>();
		ArrayList<Supplier> sup=new ArrayList<Supplier>();
		System.out.println(ca);
		ModelAndView mv1 = new ModelAndView("list");
		if(ca==1)
		{
			if(st==" ")
			{
				mv1.addObject("msg"," ");
				
			}
			else
			{
				mv1.addObject("msg",st);
			}
			 p=(ArrayList<Product>)pdao.getallproducts();
			 mv1.addObject("list",p);	
			 mv1.addObject("status",1);
		}
		else if(ca==2)
		{   if(st==" ")
		{
			mv1.addObject("msg"," ");
			
		}
		else
		{
			mv1.addObject("msg",st);
		} 
			
			 c=(ArrayList<Category>)cdao.getallcategories();
			 mv1.addObject("list",c);	
			 mv1.addObject("status",2);
					}
		else if(ca==3)
		{    if(st==" ")
		{
			mv1.addObject("msg"," ");
			
		}
		else
		{
			mv1.addObject("msg",st);
		}
			 sc=(ArrayList<Subcategory>)scdao.getallsubcategories();
			 mv1.addObject("list",sc);	
			 mv1.addObject("status",3);
					}
		
		
		else{ 
			if(st==" ")
			{
				mv1.addObject("msg"," ");
				
			}
			else
			{
				mv1.addObject("msg",st);
			}
			 sup=(ArrayList<Supplier>)sdao.getallsuppliers();
			 mv1.addObject("list",sup);	
			 mv1.addObject("status",4);
	
		}
		
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
	
	
	
	/*for loading the data of a specific product,subcategory,category,supplier( for displaying in the page 
	 in which updations are done  based on the 
	number send like 1,2,3,4 and the respective id of the item 
	1=product list
	2=category list
	3=subcategory list
	4=supplier list
	
	*/

	
	
	@RequestMapping("/retrieve")
	public ModelAndView retrieve(@RequestParam("id") int id,@RequestParam("num") int num) {
		Product p=new Product();
		Category c=new Category();
		Subcategory sc=new Subcategory();
		Supplier sup=new Supplier();
		ModelAndView mv1 = new ModelAndView("update");
		if(num==1)
	{
		
		
			p=pdao.getProdById(id);
			mv1.addObject("listt",p);
			mv1.addObject("status",1);
			ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
	
			
					
					mv1.addObject("catego",l);
					
					
					
					ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
			
					
							
							mv1.addObject("subcatego",lll);
			 ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
			
			
					mv1.addObject("suppli",ll);
	}
	else if(num==2)
	{
		
		c=cdao.getcatbyid(id);
		
		mv1.addObject("listt",c);
		mv1.addObject("status",2);
		
	}
	else if(num==3)
	{
		sc=scdao.getscatbyid(id);
		
		mv1.addObject("listt",sc);
		mv1.addObject("status",3);
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 
		
				
				mv1.addObject("catego",l);
		
	}
	else if(num==4)
	{
		
	
		sup=sdao.getsuppbyid(id);
		
		mv1.addObject("listt",sup);
		mv1.addObject("status",4);
		
		
	}
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
	
	
	
	
	/*for deleting a product or supplier  or subcategory or product  based on the 
	number send like 1,2,3,4 and the id of the item to be deleted
	1=product list
	2=category list
	3=subcategory list
	4=supplier list
	
	*/

	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id,@RequestParam("num") int num){	
		
		
		
		
		
		
		String msg="";
		ArrayList<Product> p=new ArrayList<Product>();
		ArrayList<Category> c=new ArrayList<Category>();
		ArrayList<Subcategory> sc=new ArrayList<Subcategory>();
		ArrayList<Supplier> sup=new ArrayList<Supplier>();
		ModelAndView mv1 = new ModelAndView("list");
		if(num==1)
	{
			try
			{pdao.deleteproduct(id);
			p=(ArrayList<Product>)pdao.getallproducts();
		    msg="Deleted Successfully";
			mv1.addObject("status",1);
			}
			catch(Exception e)
			{
			p=(ArrayList<Product>)pdao.getallproducts();
		    msg="This product is in some ones cart.You cannot delete";
			}
			return "redirect:/list?f="+msg+"&&num="+1;
	}
	else if(num==2)
	{
	try{	
	cdao.deletecategory(id);	
	c=(ArrayList<Category>)cdao.getallcategories();
	msg="Deleted Successfully";
	mv1.addObject("status",2);
	
	}
	catch(Exception e)
	{c=(ArrayList<Category>)cdao.getallcategories();
	 msg="Thsi category has some products.You cannot delete";
	}
	return "redirect:/list?f="+msg+"&&num="+2;
	}
	else if(num==3)
	{
		
		try{
		scdao.deletesubcategory(id);
		sc=(ArrayList<Subcategory>)scdao.getallsubcategories();
		msg="Deleted Successfully";
		mv1.addObject("status",3);
		
	}
		catch(Exception e)
		{sc=(ArrayList<Subcategory>)scdao.getallsubcategories();
		 msg="This Subcategory has some products.You cannot delete";
		}
		return "redirect:/list?f="+msg+"&&num="+3;
	}
	else if(num==4)
	{
		
	try{	
		
		ArrayList<User> us=udao.getUserByUsername(sdao.getsuppbyid(id).getSuppemail());
		for(User u:us)
		{
			udao.deleteuserbyemail(u.getEmail());
		}
		sdao.deletesupplier(id);
		sup=(ArrayList<Supplier>)sdao.getallsuppliers();
		msg="Deleted Successfully";
		mv1.addObject("status",4);
		
	}
	catch(Exception e)
	{		sup=(ArrayList<Supplier>)sdao.getallsuppliers();
	 msg="This supplier provides some products.You cannot delete";
	}
	return "redirect:/list?f="+msg+"&&num="+4;
	}
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
		 
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}	


