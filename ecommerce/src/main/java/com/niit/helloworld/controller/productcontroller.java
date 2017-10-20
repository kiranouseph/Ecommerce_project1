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
import com.niit.ecommerce_backend.dao.ReviewDAO;
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
import com.niit.ecommerce_backend.model.Review;
import com.niit.ecommerce_backend.model.Subcategory;
import com.niit.ecommerce_backend.model.Supplier;
import com.niit.ecommerce_backend.model.User;
@SuppressWarnings("unused")

//for controling product level operations like add product delete product update product
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
	@Autowired
	ReviewDAOImpl rdao;
	
	//for fetching data of a speecific product according to the product id
	@RequestMapping("/prod")
	public ModelAndView pr(@RequestParam("id") int pr) {
        ArrayList<Review> r=new ArrayList<Review>();		
		Product ll=new Product();
		ll=pdao.getProdById(pr);
		r=rdao.getrevbyprid(pr);
		ModelAndView mv1 = new ModelAndView("product");
		mv1.addObject("prod",ll);
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		mv1.addObject("rev",r);
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
	
	
	//for adding product
	@RequestMapping("/product")
	public ModelAndView addpro(@RequestParam("prid") int prid,@RequestParam("name") String name,@RequestParam("desc") String desc,@RequestParam("price") int price,@RequestParam("stock") int stock,@RequestParam("scat") int scat,@RequestParam("supp") int supp,@RequestParam("cat") int cat,@RequestParam("image") MultipartFile file) {
		
	
		Product p=new Product();
		Category cc=new Category();
		cc=cdao.getcatbyid(cat);
		
		
		Subcategory scc=new Subcategory();
		scc=scdao.getscatbyid(scat);
	p.setId(prid);
		p.setProdname(name);
		p.setProddecs(desc);
		p.setPrice(price);
		p.setStock(stock);
	    p.setCatnum(cat);
	    String img=file.getOriginalFilename();
	    p.setImage(img);

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
	    String filepath ="C:/Users/user/workspace/ecommerce/src/main/webapp/resources/products/"+ file.getOriginalFilename();
		
//image upload
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
	   
	    		pdao.saveProduct(p);

		
		
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
	
	
	
	//for updating product
	@RequestMapping("/updateproduct")
	public ModelAndView updateproduct(@RequestParam("prid") int prid,@RequestParam("name") String name,@RequestParam("desc") String desc,@RequestParam("price") int price,@RequestParam("stock") int stock,@RequestParam("scat") int scat,@RequestParam("supp") int supp,@RequestParam("cat") int cat,@RequestParam("image") MultipartFile file) {
		ModelAndView mv1 = new ModelAndView("list");
		
		
		
		

		
		ArrayList<Product> pp=new ArrayList<Product>();

		 
	
		Product p=pdao.getProdById(prid);
		
		System.out.println("Previous Product Data : "+p);
		p.setProdname(name);
		p.setProddecs(desc);
		p.setPrice(price);
		p.setStock(stock);
	
		p.setCatnum(cat);
		
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
	    
	    //no image uplaod use previous image
	    System.out.println("In File : "+file.getOriginalFilename());
	    if(file.getOriginalFilename()!="")
	    	
	    {
	  
	    String img=file.getOriginalFilename();
 	    p.setImage(img);
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
	   else
	    {
		    String img=p.getImage();
	    	p.setImage(img);
	    	System.err.println(p.getImage());
	    }
	    
	    System.out.println(p);
	   
	  
	    
	   
	    		pdao.updateproduct(p);

		
	
		
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
		 
		
		 pp=(ArrayList<Product>)pdao.getallproducts();
		 mv1.addObject("list",pp);	
		 mv1.addObject("status",1);

		return mv1;
	
	


	}
}
