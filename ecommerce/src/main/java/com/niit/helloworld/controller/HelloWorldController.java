package com.niit.helloworld.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HelloWorldController {
	
 
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
 
		ModelAndView mv1 = new ModelAndView("");
		
		
	
		return mv1;
	}
	@RequestMapping("/addUser")
	public ModelAndView addUser(@RequestParam("name") String name,@RequestParam("mobno") String mobno,@RequestParam("email") long email,@RequestParam("password") String password) {
		System.out.println(name+mobno+email+password);
           
		ModelAndView mv1 = new ModelAndView("index");
		
		
	
		return mv1;
	}
	
	
	
	
	
	

}
