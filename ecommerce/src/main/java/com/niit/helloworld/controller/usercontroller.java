package com.niit.helloworld.controller;
 
import java.util.ArrayList;
import java.util.Random;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

import antlr.collections.List;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
 
@SuppressWarnings("unused")
//home controller For the important redirections and operations
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
	@Autowired
	SubcategoryDAOImpl scdao;
	@Autowired
	ReviewDAOImpl rdao;
	
 
	
	
	
	
	
	
	
	
	
	//for loading the landing page at the start
	@RequestMapping("/")
	public ModelAndView home() {
		
		Random random= new Random();
		
		ModelAndView mv1 = new ModelAndView("index");
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
				
				mv1.addObject("catego",l);

				/*ArrayList<Product> topoff=new ArrayList<Product>();
				for(Category tpof:l)
				{
				
					topoff.add(pdao.gettopoffer(tpof.getId()));
					
				}
				for(Product pr:topoff)
				{
					System.err.println(pr);
				}
				mv1.addObject("topoff",topoff);

*/
				
				ArrayList<Product> prod=new ArrayList<Product>();			
	prod=pdao.listof_offerProducts();
	mv1.addObject("offproducts",prod);
	
	 ArrayList<Product> pp=new ArrayList<Product>();
	 pp=(ArrayList<Product>)pdao.listof_offerProducts();
	//for displaying special offers randomly from the offer list
	/*int index1 = random.nextInt(pp.size());
	 Product p1=pp.get(index1);
	 mv1.addObject("offp1",p1);
	 pp.remove(p1);
	 int index2 = random.nextInt(pp.size());
	 Product p2=pp.get(index2);
	 mv1.addObject("offp2",p2);
	 pp.remove(p2);
	 int index3 = random.nextInt(pp.size());
	 Product p3=pp.get(index3);
	 mv1.addObject("offp3",p3);
	 pp.remove(p3);
	 int index4 = random.nextInt(pp.size());
	 Product p4=pp.get(index4);
	 mv1.addObject("offp4",p4);
	 pp.remove(p4);*/
	
		return mv1;
		
		
		
		
	}
	
	

	
	//for redirections to login page from home page
	@RequestMapping("/login")
	public ModelAndView login() {
	
 
		ModelAndView mv1 = new ModelAndView("login");
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
		return mv1;
	}
	
	
	
	
		/*@RequestMapping("/loginn")
		public ModelAndView getin(@RequestParam("email") String email,@RequestParam("password") String password) {
			System.out.println(email+password);
	 int s=udao.checklogin(email,password);
	 System.out.println("Status"+s);
	 if(s==1)
	 {
			ModelAndView mv1 = new ModelAndView("index");
			return mv1;
	 }
	 else
	 {
		 ModelAndView mv1 = new ModelAndView("login");
		 return mv1;
	 }
			
		
			
	}*/
		
		
		
		
		
		
		
		
		
		
		
		
		
	// for redirecting to register page
	@RequestMapping("/signup")
	public ModelAndView register() {
		
 
		ModelAndView mv1 = new ModelAndView("register");
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
		return mv1;
	}
	
	
	
	

	//for adding the user details to database at time of sign in
	@RequestMapping("/addUser")
	public ModelAndView addUser(@RequestParam("name") String name,@RequestParam("mobno") long mobno,@RequestParam("email") String email,@RequestParam("password") String password) {
		
		
		User user=new User();
		user.setName(name);
		user.setMobno(mobno);
		user.setPassword(password);
		user.setEmail(email);
        user.setRole("ROLE_USER"); 
		udao.saveUser(user);
		ModelAndView mv1 = new ModelAndView("login");
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
		return mv1;
	}
	
		
	/*for loading the product list ,category list,supplier list,subcategory list based on the 
	number send like 1,2,3,4
	1=product list
	2=category list
	3=subcategory list
	4=supplier list
	
	*/
	
	
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam("num") int ca) 
	{
		ArrayList<Product> p=new ArrayList<Product>();
		ArrayList<Category> c=new ArrayList<Category>();
		ArrayList<Subcategory> sc=new ArrayList<Subcategory>();
		ArrayList<Supplier> sup=new ArrayList<Supplier>();
		System.out.println(ca);
		ModelAndView mv1 = new ModelAndView("list");
		if(ca==1)
		{
			 p=(ArrayList<Product>)pdao.getallproducts();
			 mv1.addObject("list",p);	
			 mv1.addObject("status",1);
		}
		else if(ca==2)
		{
			 c=(ArrayList<Category>)cdao.getallcategories();
			 mv1.addObject("list",c);	
			 mv1.addObject("status",2);
					}
		else if(ca==3)
		{
			 sc=(ArrayList<Subcategory>)scdao.getallsubcategories();
			 mv1.addObject("list",sc);	
			 mv1.addObject("status",3);
					}
		
		
		else{
			 sup=(ArrayList<Supplier>)sdao.getallsuppliers();
			 mv1.addObject("list",sup);	
			 mv1.addObject("status",4);
	
		}
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l); 
		return mv1;
	}
	
	
	
	/*for loading the data of a specific product,subcategory,category,supplier( for displaying in the page 
	 in which updations are done  based on the 
	number send like 1,2,3,4 and the respective id of the item 
	1=product list
	2=category list
	3=subcategory list
	4=supplier list
	
	*/

	
	
	@RequestMapping("/retrieve")
	public ModelAndView retrieve(@RequestParam("id") int id,@RequestParam("num") int num) {
		Product p=new Product();
		Category c=new Category();
		Subcategory sc=new Subcategory();
		Supplier sup=new Supplier();
		ModelAndView mv1 = new ModelAndView("update");
		if(num==1)
	{
		
		
			p=pdao.getProdById(id);
			mv1.addObject("listt",p);
			mv1.addObject("status",1);
			ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
	
			
					
					mv1.addObject("catego",l);
					
					
					
					ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
			
					
							
							mv1.addObject("subcatego",lll);
			 ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
			
			
					mv1.addObject("suppli",ll);
	}
	else if(num==2)
	{
		
		c=cdao.getcatbyid(id);
		
		mv1.addObject("listt",c);
		mv1.addObject("status",2);
		
	}
	else if(num==3)
	{
		sc=scdao.getscatbyid(id);
		
		mv1.addObject("listt",sc);
		mv1.addObject("status",3);
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 
		
				
				mv1.addObject("catego",l);
		
	}
	else if(num==4)
	{
		
	
		sup=sdao.getsuppbyid(id);
		mv1.addObject("listt",sup);
		mv1.addObject("status",4);
		
		
	}
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		return mv1;
	}
	
	
	
	
	/*for deleting a product or supplier  or subcategory or product  based on the 
	number send like 1,2,3,4 and the id of the item to be deleted
	1=product list
	2=category list
	3=subcategory list
	4=supplier list
	
	*/

	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") int id,@RequestParam("num") int num){	
		
		ArrayList<Product> p=new ArrayList<Product>();
		ArrayList<Category> c=new ArrayList<Category>();
		ArrayList<Subcategory> sc=new ArrayList<Subcategory>();
		ArrayList<Supplier> sup=new ArrayList<Supplier>();
		ModelAndView mv1 = new ModelAndView("list");
		if(num==1)
	{
			pdao.deleteproduct(id);
			p=(ArrayList<Product>)pdao.getallproducts();
			mv1.addObject("list",p);
			mv1.addObject("status",1);
			
	}
	else if(num==2)
	{
	cdao.deletecategory(id);	
	c=(ArrayList<Category>)cdao.getallcategories();
	mv1.addObject("list",c);	
	mv1.addObject("status",2);
		
	}
	else if(num==3)
	{
		
		
		scdao.deletesubcategory(id);
		sc=(ArrayList<Subcategory>)scdao.getallsubcategories();
		mv1.addObject("list",sc);
		mv1.addObject("status",3);
	}
	else if(num==4)
	{
		
		
		sdao.deletesupplier(id);
		sup=(ArrayList<Supplier>)sdao.getallsuppliers();
		mv1.addObject("list",sup);
		mv1.addObject("status",4);
		
	}
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		return mv1;
	}
	
	
	
	
	
	
	
	
	
	
}	


