package net.kzn.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("catagories", categoryDAO.list());
		
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value="/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);		
		return mv;
	}

	@RequestMapping(value="/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);		
		return mv;
	}
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("catagories", categoryDAO.list());
		
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable ("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("category", category);
		
		mv.addObject("catagories", categoryDAO.list());
		
		mv.addObject("title", category.getName());
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	// @RequestMapping(value="/test")
	// public ModelAndView test(@RequestParam(value ="greeting", required=false)
	// String greeting) {
	// if(greeting==null) greeting="Default Message";
	// ModelAndView mv = new ModelAndView("page");
	// mv.addObject("greeting", greeting);
	// return mv;
	// }
	// @RequestMapping(value = "/test/{greeting}/{name}")
	// public ModelAndView test(@PathVariable("greeting") String greeting,
	// @PathVariable("name") String name) {
	// greeting = greeting + " " + name;
	// ModelAndView mv = new ModelAndView("page");
	// mv.addObject("greeting", greeting);
	// return mv;
	// }
}