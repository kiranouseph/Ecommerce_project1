package com.niit.helloworld.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class suppliercontroller {
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
	
	@RequestMapping("/supplier")
	public ModelAndView addsupp(@RequestParam("suppid") int id ,@RequestParam("suppname") String name,@RequestParam("suppaddress") String address) {
		System.out.println("in controller");
		System.out.println(id+name+address);
		Supplier s=new Supplier();
		s.setId(id);
		s.setSuppname(name);
		s.setSuppdesc(address);
		
		sdao.saveProduct(s);
		
		ModelAndView mv1 = new ModelAndView("addtobasket");
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 System.out.println("printing");
		
				
				mv1.addObject("catego",l);
				
				
				
				ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
				 System.out.println("printing");
				
						
						mv1.addObject("subcatego",lll);
		 ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
		 System.out.println("printing");
		
				mv1.addObject("suppli",ll);
		
		
	
		return mv1;
	}
	
	
	@RequestMapping("/updatesupplier")
	public ModelAndView updatesupplier(@RequestParam("suppid") int id,@RequestParam("suppname") String name,@RequestParam("suppaddress")  String desc) {
	
		ModelAndView mv1 = new ModelAndView("list");
	Supplier s= new Supplier();
	s.setId(id);
	s.setSuppname(name);
	s.setSuppdesc(desc);
	sdao.updatesupplier(s);
	ArrayList<Supplier> sup=new ArrayList<Supplier>();

	 sup=(ArrayList<Supplier>)sdao.getallsuppliers();
	 mv1.addObject("list",sup);	
	 mv1.addObject("status",4);
	ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
	
	 
	
	mv1.addObject("catego",l);
		return mv1;
	}

}
