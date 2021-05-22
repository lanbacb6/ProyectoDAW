package org.iesalixar.jmoreno.proyecto.controller;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Requests;
import org.iesalixar.jmoreno.proyecto.service.RequestsService;
import org.iesalixar.jmoreno.proyecto.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequestsController {
	
	@Autowired
	private RequestsService requestsService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/rootArea/listrequestsroot")
	public String listrequestsroot(Model model) {
		model.addAttribute("listrequests", requestsService.findAll());
		
		return "listrequestsroot";
	}
	
	@GetMapping("/rootArea/requestsmodify/{id}")
	public String requestsmodify(@PathVariable("id") Long id, Model model){
		Optional<Requests> requests =  requestsService.getId(id);
		model.addAttribute("requests", requests.get());
		
		return "modifyRequestRoot";
	}
	
	@PostMapping("/rootArea/requestsmodifyRoot/submit")
	public String modifyRequests(@ModelAttribute Requests requestsm) {
		
		requestsService.modifyRequests(requestsm);
		
		return "redirect:/rootArea/listrequestsroot";
	}
	
	@GetMapping("/trabajadorArea/listrequests")
	public String listrequests (Model model) {
		model.addAttribute("listrequests", requestsService.findAll());
		
		return "listrequests";
	}
	
	@GetMapping("/trabajadorArea/requestsnew")
	public String requestsnew(Model model) {
		model.addAttribute("requests", new Requests());
		model.addAttribute("users", userService.findConRol());	
		
		return "formRequests";
	}
	
	@PostMapping("/trabajadorArea/requestsnew/submit")
	public String newRequestsSubmit(@ModelAttribute Requests requests) {
		requests.setEstado("En revisión");
		requestsService.save(requests);
		
		return "redirect:/trabajadorArea";
	}
	
}
