package org.iesalixar.jmoreno.proyecto.controller;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Providers;
import org.iesalixar.jmoreno.proyecto.service.ProvidersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProvidersController {

	@Autowired
	private ProvidersService providersService;
	
	@GetMapping("/rootArea/listprovidersroot")
	public String listrequestsRoot(Model model) {
		model.addAttribute("listprovidersroot", providersService.findAll());
		
		return "listprovidersRoot";
	}
		
	@GetMapping("/rootArea/providersmodifyRoot/{id}")
	public String providersModify(@PathVariable("id") Long id, Model model) {
		Optional<Providers> providers = providersService.getId(id);	
		model.addAttribute("providers", providers.get());
		
		return "modifyProvidersRoot";
	}
	
	@PostMapping("/rootArea/providersmodifyRoot/submit")
	public String requestsmodifyRoot(@ModelAttribute Providers providersm) {
		providersService.modifyProvider(providersm);
		
		return "redirect:/rootArea/listprovidersroot";
		
	}
	
	@GetMapping("/rootArea/providersdeleteRoot/{id}")
	public String removecUser(@PathVariable("id") Long id) {
		providersService.eliminar(id);		
		return "redirect:/rootArea/listprovidersroot";
	}
	
	@GetMapping("/administracionArea/providersnew")
	public String providersNew(Model model) {
		model.addAttribute("providers", new Providers());		
		
		return "formProviders";
	}
	
	@PostMapping("/administracionArea/providersnew/submit")
	public String providersNewSubmit(@ModelAttribute Providers providers) {
		
		providersService.save(providers);
		
		return "redirect:/administracionArea";
	}
	
	@GetMapping("/administracionArea/listprovidersadmin")
	public String listrequestsAdmin(Model model) {
		model.addAttribute("listprovidersadmin", providersService.findAll());
		
		return "listprovidersadmin";
	}
	
	@GetMapping("/administracionArea/providersmodifyAdmin/{id}")
	public String providersModifyAdmin(@PathVariable("id") Long id, Model model) {
		Optional<Providers> providers = providersService.getId(id);	
		model.addAttribute("providers", providers.get());
		
		return "modifyProvidersAdmin";
	}
	
	@PostMapping("/administracionArea/providersmodifyAdmin/submit")
	public String requestsmodifyAdmin(@ModelAttribute Providers providersm) {
		providersService.modifyProvider(providersm);
		
		return "redirect:/administracionArea/listprovidersadmin";
		
	}
	
	@GetMapping("/administracionArea/providersdeleteAdmin/{id}")
	public String removeProvidersAdmin(@PathVariable("id") Long id) {
		providersService.eliminar(id);		
		return "redirect:/administracionArea/listprovidersadmin";
	}
	
	
	
	

	
	

}
