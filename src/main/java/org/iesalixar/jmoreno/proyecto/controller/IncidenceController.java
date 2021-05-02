package org.iesalixar.jmoreno.proyecto.controller;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Incidence;
import org.iesalixar.jmoreno.proyecto.service.IncidenceService;
import org.iesalixar.jmoreno.proyecto.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IncidenceController {

	@Autowired
	private IncidenceService incidenceService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/rootArea/listincidenceroot")
	public String listincidenceroot(Model model) {
		model.addAttribute("listincidence", incidenceService.findAll());
		
		return "listincidenceroot";
	}
	
	@GetMapping("/rootArea/incidencemodify/{id}")
	public String incidencemodify(@PathVariable("id") Long id, Model model) {
		Optional<Incidence> incidence = incidenceService.getId(id);
		model.addAttribute("incidence", incidence.get());		
		
		return "modifyIncidence";
	}
	
	@PostMapping("/rootArea/modifyincidence/submit")
	public String modifyIncidence(@ModelAttribute Incidence incidencem) {
		
		incidenceService.modifyIncidence(incidencem);
		
		return "redirect:/rootArea/listincidenceroot";
	}
	
	
	@GetMapping("/trabajadorArea/listincidence")
	public String listincidence(Model model) {
		model.addAttribute("listincidence", incidenceService.findAll());
		
		return "listincidence";
	}
	
	@GetMapping("/trabajadorArea/incidencenew")
	public String incidencenew(Model model) {
		model.addAttribute("incidence", new Incidence());
		model.addAttribute("users", userService.findConRol());
		return "formIncidence";
	}
	
	@PostMapping("/trabajadorArea/incidencenew/submit")
	public String newIncidenceSubmit(@ModelAttribute Incidence incidence) {

		incidence.setEstado("Pendiente");	
		incidenceService.save(incidence);	
		
		return "redirect:/trabajadorArea";
	}
	
}
