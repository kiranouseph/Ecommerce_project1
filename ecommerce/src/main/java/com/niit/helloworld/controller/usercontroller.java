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
import com.niit.ecommerce_backend.daoimpl.SubcategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SupplierDAOImpl;
import com.niit.ecommerce_backend.daoimpl.UserDAOImpl;
import com.niit.ecommerce_backend.model.Category;
import com.niit.ecommerce_backend.model.Product;
import com.niit.ecommerce_backend.model.Subcategory;
import com.niit.ecommerce_backend.model.Supplier;
import com.niit.ecommerce_backend.model.User;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
 
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
	@Autowired
	SubcategoryDAOImpl scdao;
	
	
 
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		System.err.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("index");
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
				
				mv1.addObject("catego",l);
		
		
	
		return mv1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	

	
	
	
	
	

	
	
	
	
	@RequestMapping("/{catid}")
	public ModelAndView ca(@PathVariable("catid") int ca) {
		System.out.println("in contoller"+ca);
		ArrayList<Subcategory> ll=new ArrayList<Subcategory>();
		ll=scdao.getsubcatByCatId(ca);
		
		ModelAndView mv1 = new ModelAndView("subcategorylist");
		mv1.addObject("subcats",ll);
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		
		for(Subcategory s:ll)
		{
			System.out.println(s);
		}
		return mv1;
		
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/{catid}/{scatid}")
	public ModelAndView pr(@PathVariable("catid") int ca,@PathVariable("scatid") int sca) {
	
		ModelAndView mv1 = new ModelAndView("productlist");
	ArrayList<Product> ll =new ArrayList<Product>();
		ll=pdao.getProdByscatId(sca);
		mv1.addObject("prods",ll);
		
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		mv1.addObject("catego",l);
		
		return mv1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/login")
	public ModelAndView login() {
		System.out.println("in controller");
 
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
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	@RequestMapping("/signup")
	public ModelAndView register() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("register");
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
		return mv1;
	}
	
	
	
	
	@RequestMapping("/cart")
	public ModelAndView cart() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("cart");
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
	
		return mv1;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/admin")
	public ModelAndView admin() {
		System.out.println("in controller");
		ModelAndView mv1 = new ModelAndView("addtobasket");
		 ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
	
				mv1.addObject("catego",l);
		ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
		 
		
				
				mv1.addObject("suppli",ll);
ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
		 
		
				
				mv1.addObject("subcatego",lll);
		
		return mv1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getMobno());
		
		
         udao.saveUser(user);
		ModelAndView mv1 = new ModelAndView("login");
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/category")
	public ModelAndView addcat(@RequestParam("catid") int id ,@RequestParam("catname") String name) {
		System.out.println("in controller");
		System.out.println(id+name);
		Category c=new Category();
		c.setId(id);
		c.setCategoryname(name);
		
		cdao.savecategory(c);
		
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/list/{number}")
	public ModelAndView list(@PathVariable("number") int ca) {
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
	
	
	
	
	
	@RequestMapping("list/{id}/{number}/retrieve")
	public ModelAndView retrieve(@PathVariable("number") int num,@PathVariable("id") int id) {
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
			 System.out.println("printing");
			
					
					mv1.addObject("catego",l);
					
					
					
					ArrayList<Subcategory> lll=(ArrayList<Subcategory>)scdao.getallsubcategories();
					 System.out.println("printing");
					
							
							mv1.addObject("subcatego",lll);
			 ArrayList<Supplier> ll=(ArrayList<Supplier>)sdao.getallsuppliers();
			 System.out.println("printing");
			
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
		 System.out.println("printing");
		
				
				mv1.addObject("catego",l);
		
	}
	else if(num==4)
	{
		
		System.err.println("in else if 4");
		sup=sdao.getsuppbyid(id);
		System.err.println(sup);
		mv1.addObject("listt",sup);
		mv1.addObject("status",4);
		
		
	}
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		return mv1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/{id}/4/update")
	public ModelAndView updatesupplier(@RequestParam("suppid") int id,@RequestParam("suppname") String name,@RequestParam("suppdesc")  String desc) {
	
		ModelAndView mv1 = new ModelAndView("addtobasket");
	Supplier s= new Supplier();
	s.setId(id);
	s.setSuppname(name);
	s.setSuppdesc(desc);
	sdao.updatesupplier(s);
	ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
	
	 
	
	mv1.addObject("catego",l);
		return mv1;
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/{id}/1/update")
	public ModelAndView updateproduct() {
	
		ModelAndView mv1 = new ModelAndView("addtobasket");
	
	
		
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		return mv1;
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/{id}/2/update")
	public ModelAndView updatecategory() {
	
		ModelAndView mv1 = new ModelAndView("addtobasket");
	
		
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
	
		return mv1;
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/{id}/3/update")
	public ModelAndView updatesubcategory() {
	
		ModelAndView mv1 = new ModelAndView("addtobasket");

		
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		return mv1;
	}
	
	
	
	
	
	
	
	
	

	
	@RequestMapping("list/{id}/{number}/delete")
	public ModelAndView delete(@PathVariable("number") int num,@PathVariable("id") int id) {
	
		ModelAndView mv1 = new ModelAndView("addtobasket");
		if(num==1)
	{
		
			pdao.deleteproduct(id);
	}
	else if(num==2)
	{
	cdao.deletecategory(id);	
		
		
	}
	else if(num==3)
	{
		
		
		scdao.deletesubcategory(id);
		
	}
	else if(num==4)
	{
		
		
		sdao.deletesupplier(id);
		
	}
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		
		 
		
		mv1.addObject("catego",l);
		return mv1;
	}
	@RequestMapping("offers")
	public ModelAndView offer() {
		ModelAndView mv1 = new ModelAndView("offer");
		ArrayList<Product> p=new ArrayList<Product>();
		 p=(ArrayList<Product>)pdao.getallproducts();
		 mv1.addObject("prods",p);	
		 ArrayList<Product> pp=new ArrayList<Product>();
		 pp=(ArrayList<Product>)pdao.listof_offerProducts();
		 mv1.addObject("offproducts",pp);
		 
		
		
		
		
		return mv1;
	
	}
	
	
	
	@RequestMapping("/offers/{prid}")
	public ModelAndView offerprice(@PathVariable("prid") int prid,@RequestParam("offerprice") int offprice) 
	{
		ModelAndView mv1 = new ModelAndView("addtobasket");
		pdao.setoffers(prid,offprice);
		
		
		
		
		return mv1;
	
	}
	@RequestMapping("/offers/delete/{prid}")
	public ModelAndView offerdelete(@PathVariable("prid") int id) 
	{
		ModelAndView mv1 = new ModelAndView("addtobasket");
		pdao.deleteoffer(id);
		
		
		
		
		return mv1;
	
	}
	
	
	
	
	
	
	
	
	
}	


