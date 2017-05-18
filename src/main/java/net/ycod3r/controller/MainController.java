package net.ycod3r.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.ycod3r.model.User;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("/403")
	public String accessDenied(){
		return "403";
	}

}
