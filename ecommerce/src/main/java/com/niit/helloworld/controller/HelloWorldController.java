package com.niit.helloworld.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HelloWorldController {
	
 
	@RequestMapping("/")
	public ModelAndView page1() {
		System.out.println("in controller");
 
		ModelAndView mv1 = new ModelAndView("index");
		
		
	
		return mv1;
	}

	@RequestMapping("/login")
	public String login()
	{
		return "login";
		
	}
	@RequestMapping("/signup")
	public String register()
	{
		return "register";
		
	}
	@RequestMapping("/cart")
	public String index()
	{
		return "cart";
		
	}
	
	
	

}
