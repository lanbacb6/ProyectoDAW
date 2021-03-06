package org.iesalixar.jmoreno.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/rootArea")
	public String rootArea(){
		return "rootArea";
	}
	
	@GetMapping("/administracionArea")
	public String administracionArea() {
		return "administracionArea";
	}
	
	@GetMapping("/trabajadorArea")
	public String trabajadorArea() {
		return "trabajadorArea";
	}
	
}
