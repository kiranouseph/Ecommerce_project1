package com.niit.helloworld.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
//for supplier operations controlling
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
	@Autowired
	ReviewDAOImpl rdao;
	@Autowired
	private MailSender sendmail;
 
	
	/*for redirecting top the supplier page from header fetching the products and offers
	of those specific loginned supplier*/
	@RequestMapping("/supplierpage")
	public ModelAndView admin() {
		
		ModelAndView mv1 = new ModelAndView("supplierpage");
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
				 //for fetching  the products of the logined supplier by using email and supplier id 
				 ArrayList<Supplier> suu=new ArrayList<Supplier>();
				 suu=sdao.getsuppbyname(namees);
				 
				 ArrayList<Product> supppro=new ArrayList<Product>();
				 for(Supplier sss:suu)
				 {supppro=pdao.getprodbysid(sss.getId());}
				 
				 mv1.addObject("suppproo", supppro);
				  
				 
		
		return mv1;
	}

	
	
	//for adding supplier
	@RequestMapping("/supplier")
	public ModelAndView addsupp(@RequestParam("suppid") int id ,@RequestParam("suppname") String name,@RequestParam("suppaddress") String address,@RequestParam("suppemail") String email,@RequestParam("suppmob") long mob ) {
		
				Supplier s=new Supplier();
		s.setId(id);
		s.setSuppname(name);
		s.setSuppdesc(address);
		s.setSuppemail(email);
		sdao.savesupplier(s);
		User use=new User();
		use.setEmail(email);
		use.setMobno(mob);
		use.setName(name);
		use.setRole("ROLE_SUPPLIER");
		
		//for generating random temperory password for the supplier first login
		 final String alphabet = "0123456789ABCDE";
		    final int N = alphabet.length();

		    Random r = new Random();
String n="";
		    for (int i = 0; i < 10; i++) {
		        n=n+alphabet.charAt(r.nextInt(N));
		    }
		    use.setPassword(n);
		    
		    udao.saveUser(use);
		    
		    //for sending the random password as email to the supplier email 
			SimpleMailMessage emaill = new SimpleMailMessage();
	        emaill.setTo(email);
	        emaill.setSubject("temperory login");
	        emaill.setText("password"+n);
	        // sends the e-mail
	        sendmail.send(emaill);
		    
		
		
		ModelAndView mv1 = new ModelAndView("redirect;/list?num=4");
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		
				
				mv1.addObject("catego",l);
				
				
				
				ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
		
				
						
						mv1.addObject("subcatego",lll);
		 ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
		
		
				mv1.addObject("suppli",ll);
		
		
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
	
	//updating supplier
	@RequestMapping("/updatesupplier")
	public ModelAndView updatesupplier(@RequestParam("suppid") int id,@RequestParam("suppname") String name,@RequestParam("suppaddress")  String desc) {
	
		ModelAndView mv1 = new ModelAndView("redirect:/list?num=4");
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
	
	
	
	//for adding products from  supplier login
	@RequestMapping("/addprobysupp")
	public ModelAndView addprobysupp(@RequestParam("prid") int prid,@RequestParam("name") String name,@RequestParam("desc") String desc,@RequestParam("price") int price,@RequestParam("stock") int stock,@RequestParam("scat") int scat,@RequestParam("cat") int cat,@RequestParam("image") MultipartFile file) {
		
	
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
	    
	    
	  //for getting the email of the logined user and to find the role whether admni user or supplier
	    org.springframework.security.core.Authentication authentt = SecurityContextHolder.getContext().getAuthentication();
		 String nameess = authentt.getName();
ArrayList<Supplier> su=new ArrayList<Supplier>();
su=sdao.getsuppbyname(nameess);
for(Supplier sp:su)
{
p.setSupplier(sp);
}
		
		//for saving image of the added product by supplier by multipart
	    String filepath ="C:/Users/user/workspace/ecommerce/src/main/webapp/resources/products/"+ file.getOriginalFilename();
		

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

		
		
		ModelAndView mv1 = new ModelAndView("supplierpage");
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
								 
								 ArrayList<Supplier> suu=new ArrayList<Supplier>();
								 suu=sdao.getsuppbyname(nameess);
								 
								 ArrayList<Product> supppro=new ArrayList<Product>();
								 for(Supplier sss:suu)
								 {supppro=pdao.getprodbysid(sss.getId());}
								 
								 mv1.addObject("suppproo", supppro);
								 
								 
								
								
		return mv1;
	}
	
	
	
	//for deleting the products by supplier 
	@RequestMapping("/suppdelete")
	public ModelAndView delete(@RequestParam("id") int id){	
		
		ArrayList<Product> p=new ArrayList<Product>();
		ArrayList<Category> c=new ArrayList<Category>();
		ArrayList<Subcategory> sc=new ArrayList<Subcategory>();
		ArrayList<Supplier> sup=new ArrayList<Supplier>();
		ModelAndView mv1 = new ModelAndView("supplierpage");
		
		//for getting the email of the logined user and to find the role whether admni user or supplier
		org.springframework.security.core.Authentication authent = SecurityContextHolder.getContext().getAuthentication();
		 String namees = authent.getName();
			pdao.deleteproduct(id);
		
			 ArrayList<Supplier> suu=new ArrayList<Supplier>();
			 suu=sdao.getsuppbyname(namees);
			 
			 ArrayList<Product> supppro=new ArrayList<Product>();
			 for(Supplier sss:suu)
			 {supppro=pdao.getprodbysid(sss.getId());}
			 
			 mv1.addObject("suppproo", supppro);
			

		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		
		
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
	
	
	
	
	//for retrieving the details of the specific product of logined supplier using pruoduct id
	@RequestMapping("/suppretrieve")
	public ModelAndView retrieve(@RequestParam("id") int id) {
		Product p=new Product();
		Category c=new Category();
		Subcategory sc=new Subcategory();
		Supplier sup=new Supplier();
		ModelAndView mv1 = new ModelAndView("suppupdate");

		
			p=pdao.getProdById(id);
			mv1.addObject("listt",p);
		
			ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
	
			
					
					mv1.addObject("catego",l);
					
					
					
					ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
			
					
							
							mv1.addObject("subcatego",lll);
			 ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
			
			
					mv1.addObject("suppli",ll);
	
	
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
	
	//for updating the products from the supplier login
	@RequestMapping("/suppupdatee")
	public ModelAndView suppupdatee(@RequestParam("prid") int prid,@RequestParam("name") String name,@RequestParam("desc") String desc,@RequestParam("price") int price,@RequestParam("stock") int stock,@RequestParam("scat") int scat,@RequestParam("cat") int cat,@RequestParam("image") MultipartFile file) {
		
		
			
			
ModelAndView mv1 = new ModelAndView("supplierpage");
		
		
		
		
		
	
	
		Product p=new Product();
		
		p.setId(prid);
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
	    
	  //for getting the email of the logined user 
	    org.springframework.security.core.Authentication authentt = SecurityContextHolder.getContext().getAuthentication();
		 String nameess = authentt.getName();
ArrayList<Supplier> su=new ArrayList<Supplier>();
su=sdao.getsuppbyname(nameess);
for(Supplier sp:su)
{
p.setSupplier(sp);
}

		//if no image uplaoded use the previous uploaded image
	  
	    if(file==null)
	    	
	    {
	    Product imageret=new Product();
	    imageret=pdao.getProdById(prid);
	    String img=imageret.getImage();
	    p.setImage(img);
	    
	    	
	    	
	    }
	    //else use new image 
	    else
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
		 
		 //fetching data from the product table of the related to specific supplier
		 ArrayList<Supplier> suu=new ArrayList<Supplier>();
		 suu=sdao.getsuppbyname(namees);
		 
		 ArrayList<Product> supppro=new ArrayList<Product>();
		 for(Supplier sss:suu)
		 {supppro=pdao.getprodbysid(sss.getId());}
		 
		 mv1.addObject("suppproo", supppro);
		
		return mv1;
	
	


	}
			
			
			
			
			
			
			
			
			
		
		
	
	
	
	
	
	
	
	



}
