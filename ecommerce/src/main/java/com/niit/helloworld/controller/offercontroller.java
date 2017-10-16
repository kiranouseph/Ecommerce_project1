package com.niit.helloworld.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.niit.ecommerce_backend.model.Supplier;
import com.niit.ecommerce_backend.model.User;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
@SuppressWarnings("unused")
//controlling the offer related operations like add offer edit offer
@Controller
public class offercontroller {
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
	
	
	//for redirecting to offer page with the offer products from database
	@RequestMapping("/offers")
	public ModelAndView offer() {
		ModelAndView mv1 = new ModelAndView("offer");
		ArrayList<Product> p=new ArrayList<Product>();
		 p=(ArrayList<Product>)pdao.getallproducts();
		 mv1.addObject("prods",p);	
		 
		 //for getting the offer product list
		 ArrayList<Product> pp=new ArrayList<Product>();
		 pp=(ArrayList<Product>)pdao.listof_offerProducts();
		 mv1.addObject("offproducts",pp);
		 
ArrayList<Category> c =new ArrayList<Category>();
c=cdao.getallcategories();
mv1.addObject("catego",c);
		 
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
	
	
	//for setting offer to a product
	
	@RequestMapping("/offersset")
	public ModelAndView offerprice(@RequestParam("prid") int prid,@RequestParam("offerprice") int offprice,@RequestParam("orgprice") int orgprice) 
	{ 
		ModelAndView mv1 = new ModelAndView("offer");
		pdao.setoffers(prid,offprice,orgprice);
		ArrayList<Product> p=new ArrayList<Product>();
		 p=(ArrayList<Product>)pdao.getallproducts();
		 mv1.addObject("prods",p);	
		 //for getting offer product list
		 ArrayList<Product> pp=new ArrayList<Product>();
		 pp=(ArrayList<Product>)pdao.listof_offerProducts();
		 mv1.addObject("offproducts",pp);
		ArrayList<Category> c =new ArrayList<Category>();
		c=cdao.getallcategories();
		mv1.addObject("catego",c);
		
		
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
	
	//for deleting a offer
	@RequestMapping("/offersdel")
	public ModelAndView offerdelete(@RequestParam("prid") int id) 
	{
		ModelAndView mv1 = new ModelAndView("offer");
		pdao.deleteoffer(id);
		ArrayList<Product> p=new ArrayList<Product>();
		 p=(ArrayList<Product>)pdao.getallproducts();
		 mv1.addObject("prods",p);	
		 
		 //for retrieving th offerproducts
		 ArrayList<Product> pp=new ArrayList<Product>();
		 pp=(ArrayList<Product>)pdao.listof_offerProducts();
		 mv1.addObject("offproducts",pp);
		 
		 
		ArrayList<Category> c =new ArrayList<Category>();
		c=cdao.getallcategories();
		mv1.addObject("catego",c);
		
		
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
	
	//for getting products of the specific loginned supplier
	@RequestMapping("/suppoffers")
	public ModelAndView suppoffer() {
		ModelAndView mv1 = new ModelAndView("supplierpage");
		
		
		
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

		 
		 //for retrieving the products of specifric supplier by email and supplier id
		 ArrayList<Supplier> suu=new ArrayList<Supplier>();
		 suu=sdao.getsuppbyname(namees);
		 
		 ArrayList<Product> supppro=new ArrayList<Product>();
		 for(Supplier sss:suu)
		 {supppro=pdao.getprodbysid(sss.getId());}
		 
		 mv1.addObject("suppproo", supppro);
		
	
ArrayList<Category> c =new ArrayList<Category>();
c=cdao.getallcategories();
mv1.addObject("catego",c);
		 
		

		
		
		return mv1;
	
	}

	
	
	
	
	@RequestMapping("/suppoffersset")
	public ModelAndView suppoffersset(@RequestParam("prid") int prid,@RequestParam("offerprice") int offprice,@RequestParam("orgprice") int orgprice) {
		ModelAndView mv1 = new ModelAndView("supplierpage");
		pdao.setoffers(prid,offprice,orgprice);
		
		
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

		 
		 //for retrieving the products of specifric supplier by email and supplier id
		 ArrayList<Supplier> suu=new ArrayList<Supplier>();
		 suu=sdao.getsuppbyname(namees);
		 
		 ArrayList<Product> supppro=new ArrayList<Product>();
		 for(Supplier sss:suu)
		 {supppro=pdao.getprodbysid(sss.getId());}
		 
		 mv1.addObject("suppproo", supppro);
		
	
ArrayList<Category> c =new ArrayList<Category>();
c=cdao.getallcategories();
mv1.addObject("catego",c);
		 
		

		
		
		return mv1;
	
	}
	
	
	@RequestMapping("/suppoffersdel")
	public ModelAndView suppoffersdel(@RequestParam("prid") int prid) {
		ModelAndView mv1 = new ModelAndView("supplierpage");
		pdao.deleteoffer(prid);
		
		
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

		 
		 //for retrieving the products of specifric supplier by email and supplier id
		 ArrayList<Supplier> suu=new ArrayList<Supplier>();
		 suu=sdao.getsuppbyname(namees);
		 
		 ArrayList<Product> supppro=new ArrayList<Product>();
		 for(Supplier sss:suu)
		 {supppro=pdao.getprodbysid(sss.getId());}
		 
		 mv1.addObject("suppproo", supppro);
		
	
ArrayList<Category> c =new ArrayList<Category>();
c=cdao.getallcategories();
mv1.addObject("catego",c);
		 
		

		
		
		return mv1;
	
	}


}