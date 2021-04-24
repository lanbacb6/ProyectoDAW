package org.iesalixar.jmoreno.proyecto.controller;


import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.service.RoleService;
import org.iesalixar.jmoreno.proyecto.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.iesalixar.jmoreno.proyecto.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/rootArea/listuserpediente")
	public String listuserpendiente(Model model) {
		model.addAttribute("listuserpediente", userService.findSinRol());	
		return "listuserpediente";
		
	}
	
	@GetMapping("/rootArea/listusecrol")
	public String listusercrol(Model model) {
		model.addAttribute("listusecrol", userService.findConRol());	
		return "listusecrol";
		
	}
	
	@GetMapping("/rootArea/usersrdelete/{id}")
	public String removeUser(@PathVariable("id") Long id) {
		userService.eliminar(id);		
		return "redirect:/rootArea/listuserpediente";
	}
	
	@GetMapping("/rootArea/usersrmodify/{id}")
	public String modifyUserSR(@PathVariable("id") Long id, Model model) {
		Optional<User> user = userService.getId(id);
		model.addAttribute("user", user.get());
		model.addAttribute("roles", roleService.findAll());
		
		
		return "modifyUser";
		
	}
	
	@GetMapping("/rootArea/usercrmodify/{id}")
	public String modifyUserCR(@PathVariable("id") Long id, Model model) {
		Optional<User> user = userService.getId(id);
		model.addAttribute("user", user.get());
		model.addAttribute("roles", roleService.findAll());
		
		
		return "modifyUserCR";
		
	}
	
	@PostMapping("/rootArea/modifyucr/submit")
	public String modifyUserConRol(@ModelAttribute User userm) {
		
		userService.modifyUser(userm);
		
		return "redirect:/rootArea/listusecrol";
	}
	
	@PostMapping("/rootArea/modifyusr/submit")
	public String modifyUserSinRol(@ModelAttribute User userm) {
		
		userService.modifyUser(userm);
		
		return "redirect:/rootArea/listuserpediente";
	}
	
	@GetMapping("/rootArea/usercrdelete/{id}")
	public String removecUser(@PathVariable("id") Long id) {
		userService.eliminar(id);		
		return "redirect:/rootArea/listusecrol";
	}
	
	
	
	
	
	
}
