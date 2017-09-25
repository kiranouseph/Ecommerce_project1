package com.niit.helloworld.controller;
 
import java.util.ArrayList;

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
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 System.out.println("printing");
		 for(Category cc:l)
			{
				System.out.println(cc);
			}
				
				mv1.addObject("catego",l);
		
		
	
		return mv1;
	}
	
	
	
	@RequestMapping("/header")
	public ModelAndView header() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("index");
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 System.out.println("printing");
		 for(Category cc:l)
			{
				System.out.println(cc);
			}
				
				mv1.addObject("catego",l);
		
		
	
		return mv1;
	}
	
	
	@RequestMapping("/{catid}")
	public ModelAndView ca(@PathVariable("catid") int ca) {
		System.out.println("in contoller"+ca);
		ArrayList<Product> ll=new ArrayList<Product>();
		ll=pdao.getProdByCatId(ca);
		System.out.println("controller reached");
		ModelAndView mv1 = new ModelAndView("productlist");
		mv1.addObject("prods",ll);
		
		System.out.println("Category Product List");
		System.out.println("list printed");
		return mv1;
	}
	@RequestMapping("/{catid}/{prid}")
	public ModelAndView pr(@PathVariable("catid") int ca,@PathVariable("prid") int pr) {
		System.out.println("in contoller"+ca+pr);
		Product ll=new Product();
		ll=pdao.getProdById(pr);
		System.out.println("controller reached");
		ModelAndView mv1 = new ModelAndView("product");
		mv1.addObject("prod",ll);
		
		
		return mv1;
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("login");
		
		
	
		return mv1;
	}
		@RequestMapping("/loginn")
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
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 System.out.println("printing");
		 for(Category cc:l)
			{
				System.out.println(cc);
			}
				
				mv1.addObject("catego",l);
		ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
		 System.out.println("printing");
		 for(Supplier ss:ll)
			{
				System.out.println(ss);
			}
				
				mv1.addObject("suppli",ll);
		
		
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
	public ModelAndView addpro(@RequestParam("prid") int id ,@RequestParam("name") String name,@RequestParam("desc") String desc,@RequestParam("price") int price,@RequestParam("stock") int stock,@RequestParam("cat") int cat,@RequestParam("supp") int supp) {
		System.out.println("in controller");
		System.out.println("id  "+id+"name  "+name+"deasc  "+desc+"price  "+price+"stock  "+stock+"catid  "+cat+"suppid  "+supp);
		Product p=new Product();
		Category cc=new Category();
		p.setId(id);
		p.setProdname(name);
		p.setProddecs(desc);
		p.setPrice(price);
		p.setStock(stock);
		Category ll=new Category();
		ll=cdao.getcatbyid(cat);
	    int cati=ll.getId();
	    String catii=ll.getCategoryname();
	    System.out.println(cati+"  "+catii);
	    Category ccc=new Category();
	    ccc.setId(cati);
	    ccc.setCategoryname(catii);
	    p.setCategory(ccc);
	    
	    Supplier ss=new Supplier();
		ss=sdao.getsuppbyid(supp);
	    int sup1=ss.getId();
	    String sup2=ss.getSuppname();
	    String sup3=ss.getSuppdesc();
	    Supplier sss=new Supplier();
	    sss.setId(sup1);
	    sss.setSuppname(sup2);
	    sss.setSuppdesc(sup3);
	    p.setSupplier(sss);
		pdao.saveProduct(p);
		ModelAndView mv1 = new ModelAndView("addtobasket");
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 System.out.println("printing");
		
				
				mv1.addObject("catego",l);
				ArrayList<Supplier> lll=(ArrayList<Supplier>)sdao.getallsuppliers();
				 System.out.println("printing");
				
						
						mv1.addObject("suppli",lll);
	
		
		
	
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
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 System.out.println("printing");
		 for(Category cc:l)
			{
				System.out.println(cc);
			}
				
				mv1.addObject("catego",l);
				ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
				 System.out.println("printing");
				 for(Supplier ss:ll)
					{
						System.out.println(ss);
					}
						
						mv1.addObject("suppli",ll);
				
		
	
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
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		 System.out.println("printing");
		 for(Category cc:l)
			{
				System.out.println(cc);
			}
				
				mv1.addObject("catego",l);
		 ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
		 System.out.println("printing");
		 for(Supplier ss:ll)
			{
				System.out.println(ss);
			}
				
				mv1.addObject("suppli",ll);
		
		
	
		return mv1;
	}
	
	
	
	

}
