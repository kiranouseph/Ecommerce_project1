package com.niit.helloworld.controller;
 
import java.util.ArrayList;

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

import com.niit.ecommerce_backend.dao.ProductDAO;
import com.niit.ecommerce_backend.dao.UserDAO;
import com.niit.ecommerce_backend.daoimpl.CategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ProductDAOImpl;
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
 
@SuppressWarnings("unused")
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
	
	
 
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		
	
		
		ModelAndView mv1 = new ModelAndView("index");
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
				
				mv1.addObject("catego",l);
				ArrayList<Product> prod=new ArrayList<Product>();			
	prod=pdao.listof_offerProducts();
	mv1.addObject("offproducts",prod);
	
		return mv1;
	}
	
	

	
	
	@RequestMapping("/login")
	public ModelAndView login() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("login");
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
		return mv1;
	}
	
	
	
	
		/*@RequestMapping("/loginn")
		public ModelAndView getin(@RequestParam("email") String email,@RequestParam("password") String password) {
			System.out.println(email+password);
	 int s=udao.checklogin(email,password);
	 System.out.println("Status"+s);
	 if(s==1)
	 {
			ModelAndView mv1 = new ModelAndView("index");
			return mv1;
	 }
	 else
	 {
		 ModelAndView mv1 = new ModelAndView("login");
		 return mv1;
	 }
			
		
			
	}*/
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	@RequestMapping("/signup")
	public ModelAndView register() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("register");
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
		return mv1;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getMobno());
		
		
         udao.saveUser(user);
		ModelAndView mv1 = new ModelAndView("login");
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
		return mv1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam("num") int ca) 
	{
		ArrayList<Product> p=new ArrayList<Product>();
		ArrayList<Category> c=new ArrayList<Category>();
		ArrayList<Subcategory> sc=new ArrayList<Subcategory>();
		ArrayList<Supplier> sup=new ArrayList<Supplier>();
		System.out.println(ca);
		ModelAndView mv1 = new ModelAndView("list");
		if(ca==1)
		{
			 p=(ArrayList<Product>)pdao.getallproducts();
			 mv1.addObject("list",p);	
			 mv1.addObject("status",1);
		}
		else if(ca==2)
		{
			 c=(ArrayList<Category>)cdao.getallcategories();
			 mv1.addObject("list",c);	
			 mv1.addObject("status",2);
					}
		else if(ca==3)
		{
			 sc=(ArrayList<Subcategory>)scdao.getallsubcategories();
			 mv1.addObject("list",sc);	
			 mv1.addObject("status",3);
					}
		
		
		else{
			 sup=(ArrayList<Supplier>)sdao.getallsuppliers();
			 mv1.addObject("list",sup);	
			 mv1.addObject("status",4);
	
		}
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l); 
		return mv1;
	}
	
	
	
	
	
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
			 System.out.println("printing");
			
					
					mv1.addObject("catego",l);
					
					
					
					ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
					 System.out.println("printing");
					
							
							mv1.addObject("subcatego",lll);
			 ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
			 System.out.println("printing");
			
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
		 System.out.println("printing");
		
				
				mv1.addObject("catego",l);
		
	}
	else if(num==4)
	{
		
		System.err.println("in else if 4");
		sup=sdao.getsuppbyid(id);
		System.err.println(sup);
		mv1.addObject("listt",sup);
		mv1.addObject("status",4);
		
		
	}
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		return mv1;
	}
	
	
	
	
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") int id,@RequestParam("num") int num){	
		
		ArrayList<Product> p=new ArrayList<Product>();
		ArrayList<Category> c=new ArrayList<Category>();
		ArrayList<Subcategory> sc=new ArrayList<Subcategory>();
		ArrayList<Supplier> sup=new ArrayList<Supplier>();
		ModelAndView mv1 = new ModelAndView("list");
		if(num==1)
	{
			pdao.deleteproduct(id);
			p=(ArrayList<Product>)pdao.getallproducts();
			mv1.addObject("list",p);
			mv1.addObject("status",1);
			
	}
	else if(num==2)
	{
	cdao.deletecategory(id);	
	c=(ArrayList<Category>)cdao.getallcategories();
	mv1.addObject("list",c);	
	mv1.addObject("status",2);
		
	}
	else if(num==3)
	{
		
		
		scdao.deletesubcategory(id);
		sc=(ArrayList<Subcategory>)scdao.getallsubcategories();
		mv1.addObject("list",sc);
		mv1.addObject("status",3);
	}
	else if(num==4)
	{
		
		
		sdao.deletesupplier(id);
		sup=(ArrayList<Supplier>)sdao.getallsuppliers();
		mv1.addObject("list",sup);
		mv1.addObject("status",4);
		
	}
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		return mv1;
	}
	
	
	
	
	
	
	
	
	
	
}	


