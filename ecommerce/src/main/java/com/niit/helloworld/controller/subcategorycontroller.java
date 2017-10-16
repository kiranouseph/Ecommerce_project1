package com.niit.helloworld.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
@SuppressWarnings("unused")
//for controlling the subcategory level operations
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
	@Autowired
	ReviewDAOImpl rdao;
	
//for selecting the products according to the selected subcategory	
	@RequestMapping("/selsubcat")
	public ModelAndView pr(@RequestParam("id") int sca) {
	
		ModelAndView mv1 = new ModelAndView("productlist");
	ArrayList<Product> ll =new ArrayList<Product>();
		ll=pdao.getProdByscatId(sca);
		mv1.addObject("prods",ll);
		
		
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
	//for adding subcategory
	@RequestMapping("/subcategory")
	public ModelAndView addscat(@RequestParam("scatid") int id ,@RequestParam("scatname") String name,@RequestParam("scat") int cat,@RequestParam("image") MultipartFile file) {
		
		
		Subcategory sc=new Subcategory();
		sc.setId(id);
		sc.setSubcategoryname(name);
		Category c=new Category();
		c=cdao.getcatbyid(cat);
		sc.setCategory(c);
		 String img=file.getOriginalFilename();
sc.setSubcatimage(img);
		scdao.savesubcategory(sc);
		
String filepath ="C:/Users/user/workspace/ecommerce/src/main/webapp/resources/products/"+file.getOriginalFilename();
		
//image uplaod		
		try {
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
			fos.write(imagebyte);
			fos.close();
			} catch (IOException e) {
			e.printStackTrace();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		ModelAndView mv1 = new ModelAndView("admin");
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 
		
				
				mv1.addObject("catego",l);
				ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
				 
				
						
						mv1.addObject("suppli",ll);
						ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
						 
						
								
								mv1.addObject("subcatego",lll);
						
				
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
	//for updating subcategory
	@RequestMapping("/updatesubcategory")
	public ModelAndView updatesubcategory(@RequestParam("scatid") int id ,@RequestParam("scatname") String name,@RequestParam("cat") int cat,@RequestParam("image") MultipartFile file) {
	
		ModelAndView mv1 = new ModelAndView("list");
		Subcategory sc=new Subcategory();
		sc.setId(id);
		sc.setSubcategoryname(name);
		Category c=new Category();
		c=cdao.getcatbyid(cat);
		sc.setCategory(c);
		
		//no image use previous  upload
		if(file==null)
		{
			Subcategory imageret=new Subcategory();
			imageret=scdao.getscatbyid(id);
			String image=imageret.getSubcatimage();
			sc.setSubcatimage(image);
		}
		//use new image
		else
		{
			 String img=file.getOriginalFilename();
			 sc.setSubcatimage(img);	
			 String filepath ="C:/Users/user/workspace/ecommerce/src/main/webapp/resources/products/"+file.getOriginalFilename();
				
				
				try {
					byte imagebyte[] = file.getBytes();
					BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
					fos.write(imagebyte);
					fos.close();
					} catch (IOException e) {
					e.printStackTrace();
					} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
		}
		scdao.updatesubcategory(sc);

		
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		ArrayList<Subcategory> scc=new ArrayList<Subcategory>();

		 scc=(ArrayList<Subcategory>)scdao.getallsubcategories();
		 mv1.addObject("list",scc);	
		 mv1.addObject("status",3);
		 
		 
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
	
	

}