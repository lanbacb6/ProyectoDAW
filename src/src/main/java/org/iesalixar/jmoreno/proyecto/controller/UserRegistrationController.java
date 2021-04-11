package org.iesalixar.jmoreno.proyecto.controller;

import org.iesalixar.jmoreno.proyecto.service.UserService;
import org.iesalixar.jmoreno.proyecto.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	private UserService userService;
	
	
	@ModelAttribute("user")
	public UserRegistrationDto UserRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String formRegistration() {
		return "registration";
	}
	
	@PostMapping
	public String registerUser(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
	
	
	
}
