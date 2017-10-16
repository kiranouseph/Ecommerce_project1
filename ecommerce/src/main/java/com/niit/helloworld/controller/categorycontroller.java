package com.niit.helloworld.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.tomcat.jni.File;
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
import com.niit.ecommerce_backend.model.Subcategory;
import com.niit.ecommerce_backend.model.Supplier;
import com.niit.ecommerce_backend.model.User;
@SuppressWarnings("unused")
//for the operations related to categories like adding deleting updating etc
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
	@Autowired
	ReviewDAOImpl rdao;
	
//for selecting the subcategories in a pirticular category
	@RequestMapping("/selcat")
	public ModelAndView ca(@RequestParam("id") int ca) {
	
		ArrayList<Subcategory> ll=new ArrayList<Subcategory>();
		ll=scdao.getsubcatByCatId(ca);
		
		ModelAndView mv1 = new ModelAndView("subcategorylist");
		mv1.addObject("subcats",ll);
		
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
	
	//for adding category
	
	@RequestMapping("/category")
	public ModelAndView addcat(@RequestParam("catid") int id ,@RequestParam("catname") String name,@RequestParam("catdesc") String catdesc,@RequestParam("image") MultipartFile file) {
		
		Category c=new Category();
		c.setId(id);
		c.setCategoryname(name);
		c.setCategorydesc(catdesc);
		 String img=file.getOriginalFilename();
		 c.setCatimage(img);
		cdao.savecategory(c);
	   		  
		      
String filepath ="C:/Users/user/workspace/ecommerce/src/main/webapp/resources/products/"+file.getOriginalFilename();
		
		//for image upload
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
	
	
	//for updating category
	@RequestMapping("/updatecategory")
	public ModelAndView updatecategory(@RequestParam("catid") int id ,@RequestParam("catname") String name,@RequestParam("catdesc") String catdesc,@RequestParam("image") MultipartFile file) {
	
		Category c=new Category();
		c.setId(id);
		c.setCategoryname(name);
		c.setCategorydesc(catdesc);
		
		//if no image uplaoded use previos uploaded iamge
		if(file==null)
		{
			Category imageret=new Category();
			imageret=cdao.getcatbyid(id);
			String image=imageret.getCatimage();
			c.setCatimage(image);
		}
		//else use new image
		else
		{
			String img=file.getOriginalFilename();
			 c.setCatimage(img);
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
		
		cdao.updatecategory(c);
		
		
		ModelAndView mv1 = new ModelAndView("list");
		ArrayList<Category> cc=new ArrayList<Category>();

		 cc=(ArrayList<Category>)cdao.getallcategories();
		 mv1.addObject("list",cc);	
		 mv1.addObject("status",2);

		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 System.out.println("printing");
		
				
				mv1.addObject("catego",l);
				ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
				 System.out.println("printing");
				
						
						mv1.addObject("suppli",ll);
						 ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
						 System.out.println("printing");
						
								
								mv1.addObject("subcatego",lll);
				
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
