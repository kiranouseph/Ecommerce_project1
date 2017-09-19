package com.niit.helloworld.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce_backend.dao.ProductDAO;
import com.niit.ecommerce_backend.dao.UserDAO;
import com.niit.ecommerce_backend.daoimpl.CategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ProductDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SupplierDAOImpl;
import com.niit.ecommerce_backend.daoimpl.UserDAOImpl;
import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Product;
import com.niit.ecommerce_backend.model.Supplier;
import com.niit.ecommerce_backend.model.User;
 
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
 
	@RequestMapping("/")
	public ModelAndView home() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("index");
		
		
	
		return mv1;
	}
	

	@RequestMapping("/login")
	public ModelAndView login() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("login");
		
		
	
		return mv1;
	}
	
	@RequestMapping("/signup")
	public ModelAndView register() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("register");
		
		
	
		return mv1;
	}
	
	@RequestMapping("/cart")
	public ModelAndView cart() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("cart");
		
		
	
		return mv1;
	}

	@RequestMapping("/admin")
	public ModelAndView admin() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("addtobasket");
		
		
	
		return mv1;
	}
	@RequestMapping("/addUser")
	public ModelAndView addUser(@RequestParam("name") String name,@RequestParam("mobno") long mobno,@RequestParam("email") String email,@RequestParam("password") String password) {
		System.out.println(name+mobno+email+password);
         User u=new User();
         u.setName(name);
         u.setMobno(mobno);
         u.setEmail(email);
         u.setPassword(password);
         udao.saveUser(u);
		ModelAndView mv1 = new ModelAndView("login");
		
		
	
		return mv1;
	}
	@RequestMapping("/product")
	public ModelAndView addpro(@RequestParam("prid") int id ,@RequestParam("name") String name,@RequestParam("desc") String desc,@RequestParam("price") int price,@RequestParam("stock") int stock,@RequestParam("cat") String cat,@RequestParam("supp") String supp) {
		System.out.println("in controller");
		System.out.println(id+name+desc+price+stock+cat+supp);
		Product p=new Product();
		p.setId(id);
		p.setProdname(name);
		p.setProddecs(desc);
		p.setPrice(price);
		p.setStock(stock);
		p.setCategory(cat);
		p.setSupplier(supp);
		pdao.saveProduct(p);
		
		ModelAndView mv1 = new ModelAndView("addtobasket");
		
		
	
		return mv1;
	}
	@RequestMapping("/category")
	public ModelAndView addcat(@RequestParam("catid") int id ,@RequestParam("catname") String name) {
		System.out.println("in controller");
		System.out.println(id+name);
		Category c=new Category();
		c.setId(id);
		c.setCategoryname(name);
		
		cdao.saveProduct(c);
		
		ModelAndView mv1 = new ModelAndView("addtobasket");
		
		
	
		return mv1;
	}
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
		
		
	
		return mv1;
	}
	
	
	
	

}
