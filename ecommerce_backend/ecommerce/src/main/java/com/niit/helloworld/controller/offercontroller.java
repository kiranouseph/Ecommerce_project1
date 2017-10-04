package com.niit.helloworld.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce_backend.daoimpl.CategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ProductDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SubcategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SupplierDAOImpl;
import com.niit.ecommerce_backend.daoimpl.UserDAOImpl;
import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Product;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
@SuppressWarnings("unused")
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
	
	
	
	@RequestMapping("offers")
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
	
	
	
	@RequestMapping("/offers/{prid}")
	public ModelAndView offerprice(@PathVariable("prid") int prid,@RequestParam("offerprice") int offprice) 
	{
		ModelAndView mv1 = new ModelAndView("offer");
		pdao.setoffers(prid,offprice);
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
	@RequestMapping("/offers/delete/{prid}")
	public ModelAndView offerdelete(@PathVariable("prid") int id) 
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
