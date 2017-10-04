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
import com.niit.ecommerce_backend.model.Subcategory;
import com.niit.ecommerce_backend.model.Supplier;
@SuppressWarnings("unused")
@Controller
public class categorycontroller {
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
	
	

	@RequestMapping("/selcat")
	public ModelAndView ca(@RequestParam("id") int ca) {
		System.out.println("in contoller"+ca);
		ArrayList<Subcategory> ll=new ArrayList<Subcategory>();
		ll=scdao.getsubcatByCatId(ca);
		
		ModelAndView mv1 = new ModelAndView("subcategorylist");
		mv1.addObject("subcats",ll);
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		
		for(Subcategory s:ll)
		{
			System.out.println(s);
		}
		return mv1;
		
	}
	
	@RequestMapping("/category")
	public ModelAndView addcat(@RequestParam("catid") int id ,@RequestParam("catname") String name) {
		System.out.println("in controller");
		System.out.println(id+name);
		Category c=new Category();
		c.setId(id);
		c.setCategoryname(name);
		
		cdao.savecategory(c);
		
		
		ModelAndView mv1 = new ModelAndView("addtobasket");
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 System.out.println("printing");
		
				
				mv1.addObject("catego",l);
				ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
				 System.out.println("printing");
				
						
						mv1.addObject("suppli",ll);
						 ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
						 System.out.println("printing");
						
								
								mv1.addObject("subcatego",lll);
				
		
	
		return mv1;
	}
	
	
	
	@RequestMapping("/{id}/2/update")
	public ModelAndView updatecategory() {
	
		ModelAndView mv1 = new ModelAndView("addtobasket");
	
		
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
		return mv1;
	}
	
	
		
	

}
