package net.kzn.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Spring Web MVC");
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