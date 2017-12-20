package org.test.document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.test.document.service.DocumentService;


@Controller
public class WelcomeController {
	@Autowired
	DocumentService documentService;
	@GetMapping("/hello")
	public String welcome(Model model){
		model.addAttribute("name","Aaditi");
		return "welcome.jsp";
	}
	
	@GetMapping("/home")
	public ModelAndView home(){
		ModelAndView model = new ModelAndView("index.jsp");
		return model;
	}
	
	

}
