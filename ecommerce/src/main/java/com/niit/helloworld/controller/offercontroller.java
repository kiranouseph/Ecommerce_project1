package com.niit.helloworld.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping("/admin/offers")
	public ModelAndView offer() {
		ModelAndView mv1 = new ModelAndView("offer");
		ArrayList<Product> p=new ArrayList<Product>();
		 p=(ArrayList<Product>)pdao.getallproducts();
		 mv1.addObject("prods",p);	
		 ArrayList<Product> pp=new ArrayList<Product>();
		 pp=(ArrayList<Product>)pdao.listof_offerProducts();
		 mv1.addObject("offproducts",pp);
ArrayList<Category> c =new ArrayList<Category>();
c=cdao.getallcategories();
mv1.addObject("catego",c);
		 
		
		
		
		
		return mv1;
	
	}
	
	
	//for setting offer to a product
	
	@RequestMapping("/admin/offersset")
	public ModelAndView offerprice(@RequestParam("prid") int prid,@RequestParam("offerprice") int offprice,@RequestParam("orgprice") int orgprice) 
	{ 
		ModelAndView mv1 = new ModelAndView("offer");
		pdao.setoffers(prid,offprice,orgprice);
		ArrayList<Product> p=new ArrayList<Product>();
		 p=(ArrayList<Product>)pdao.getallproducts();
		 mv1.addObject("prods",p);	
		 ArrayList<Product> pp=new ArrayList<Product>();
		 pp=(ArrayList<Product>)pdao.listof_offerProducts();
		 mv1.addObject("offproducts",pp);
		ArrayList<Category> c =new ArrayList<Category>();
		c=cdao.getallcategories();
		mv1.addObject("catego",c);
		
		
		return mv1;
	
	}
	
	//for deleting a offer
	@RequestMapping("/admin/offersdel")
	public ModelAndView offerdelete(@RequestParam("prid") int id) 
	{
		ModelAndView mv1 = new ModelAndView("offer");
		pdao.deleteoffer(id);
		ArrayList<Product> p=new ArrayList<Product>();
		 p=(ArrayList<Product>)pdao.getallproducts();
		 mv1.addObject("prods",p);	
		 ArrayList<Product> pp=new ArrayList<Product>();
		 pp=(ArrayList<Product>)pdao.listof_offerProducts();
		 mv1.addObject("offproducts",pp);
		ArrayList<Category> c =new ArrayList<Category>();
		c=cdao.getallcategories();
		mv1.addObject("catego",c);
		
		
		return mv1;
	
	}

}