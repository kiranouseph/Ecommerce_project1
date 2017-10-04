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
import com.niit.ecommerce_backend.model.Subcategory;
import com.niit.ecommerce_backend.model.Supplier;
@SuppressWarnings("unused")
@Controller
public class subcategorycontroller {
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
	
	
	
	@RequestMapping("/selsubcat")
	public ModelAndView pr(@RequestParam("id") int sca) {
	
		ModelAndView mv1 = new ModelAndView("productlist");
	ArrayList<Product> ll =new ArrayList<Product>();
		ll=pdao.getProdByscatId(sca);
		mv1.addObject("prods",ll);
		
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		mv1.addObject("catego",l);
		
		return mv1;
	}
	
	@RequestMapping("/subcategory")
	public ModelAndView addscat(@RequestParam("scatid") int id ,@RequestParam("scatname") String name,@RequestParam("scat") int cat) {
		System.out.println("in controller");
		System.out.println(id+name+cat);
		Subcategory sc=new Subcategory();
		sc.setId(id);
		sc.setSubcategoryname(name);
		Category c=new Category();
		c=cdao.getcatbyid(cat);
		sc.setCategory(c);
		scdao.savesubcategory(sc);
		
		
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
	
	@RequestMapping("/updatesubcategory")
	public ModelAndView updatesubcategory(@RequestParam("scatid") int id ,@RequestParam("scatname") String name,@RequestParam("cat") int cat) {
	
		ModelAndView mv1 = new ModelAndView("list");
		Subcategory sc=new Subcategory();
		sc.setId(id);
		sc.setSubcategoryname(name);
		Category c=new Category();
		c=cdao.getcatbyid(cat);
		sc.setCategory(c);
		scdao.updatesubcategory(sc);

		
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		ArrayList<Subcategory> scc=new ArrayList<Subcategory>();

		 scc=(ArrayList<Subcategory>)scdao.getallsubcategories();
		 mv1.addObject("list",scc);	
		 mv1.addObject("status",3);

		return mv1;
	}
	
	

}
