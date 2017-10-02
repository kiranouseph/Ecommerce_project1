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
public class productcontroller {
	
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
	
	
	@RequestMapping("/{cat}/{scat}/{prid}")
	public ModelAndView pr(@PathVariable("cat") int ca,@PathVariable("prid") int pr,@PathVariable("scat") String  sca) {
		
		Product ll=new Product();
		ll=pdao.getProdById(pr);
		
		ModelAndView mv1 = new ModelAndView("product");
		mv1.addObject("prod",ll);
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		return mv1;
	}
	
	@RequestMapping("/product")
	public ModelAndView addpro(@RequestParam("prid") int prid,@RequestParam("name") String name,@RequestParam("desc") String desc,@RequestParam("price") int price,@RequestParam("stock") int stock,@RequestParam("scat") int scat,@RequestParam("supp") int supp,@RequestParam("cat") int cat) {
		System.out.println("name"+name+"desc"+desc+"price"+price+"stock"+stock+"scat"+scat+"cat"+cat+"supp"+supp);
	
		Product p=new Product();
		
		p.setId(prid);
		p.setProdname(name);
		p.setProddecs(desc);
		p.setPrice(price);
		p.setStock(stock);
	
		
Category cc=new Category();
		cc=cdao.getcatbyid(cat);
		
		
		Subcategory scc=new Subcategory();
		scc=scdao.getscatbyid(scat);
		int idd=scc.getId();
		String na=scc.getSubcategoryname();
		Subcategory sccc=new Subcategory();
		sccc.setId(idd);
		sccc.setSubcategoryname(na);
		sccc.setCategory(cc);
		
		
	    p.setSubcategory(sccc);
	    

		Supplier sup=new Supplier();
		sup=sdao.getsuppbyid(supp);
	    p.setSupplier(sup);
	    
	   
	    
		pdao.saveProduct(p);
		
		
		ModelAndView mv1 = new ModelAndView("addtobasket");
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 System.out.println("printing categories");
		
				
				mv1.addObject("catego",l);
				ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
				 System.out.println("printing categories");
				
						mv1.addObject("suppli",ll);
						ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
						 System.out.println("printing categories");
						
								
								mv1.addObject("subcatego",lll);
		
		
	
		return mv1;
	}
	
	
	
	
	@RequestMapping("/{id}/1/update")
	public ModelAndView updateproduct() {
	
		ModelAndView mv1 = new ModelAndView("addtobasket");
	
	
		
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		return mv1;
	
	


	}
}
