package org.iesalixar.jmoreno.proyecto.controller;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Clients;
import org.iesalixar.jmoreno.proyecto.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientsController {
	
	@Autowired
	private ClientsService clientsService;
	
	@GetMapping("/rootArea/listclientsroot")
	public String listClientsRoot(Model model) {
		model.addAttribute("listclientsroot", clientsService.findAll());
		
		return "listclientsroot";
	}
	
	@GetMapping("/rootArea/clientsmodifyroot/{id}")
	public String clientsModifyRoot(@PathVariable("id")Long id, Model model) {
		Optional<Clients> clients = clientsService.getId(id);
		model.addAttribute("clients", clients.get());
		
		return "modifyClientsRoot";
	}
	
	@PostMapping("/rootArea/clientsmodifyRoot/submit")
	public String clientsModifyRootSubmit(@ModelAttribute Clients clientsm) {
		clientsService.modifyClients(clientsm);
		
		return "redirect:/rootArea/listclientsroot";
	}
	
	@GetMapping("/rootArea/clientsdeleteroot/{id}")
	public String deleteClientsRoot(@PathVariable("id") Long id) {
		clientsService.eliminar(id);
		
		return "redirect:/rootArea/listclientsroot";
	}
	
	@GetMapping("/administracionArea/clientsnew")
	public String newClients(Model model) {
		model.addAttribute("clients", new Clients());
		
		return "formClients";
	}
	
	@PostMapping("/administracionArea/clientsnew/submit")
	public String newClienteSubmit(@ModelAttribute Clients clients) {
		clientsService.save(clients);
		
		return "redirect:/administracionArea";
	}
	
	@GetMapping("/administracionArea/listclientsadmin")
	public String listClientsAdmin(Model model) {
		model.addAttribute("listclientsadmin", clientsService.findAll());
		
		return "listclientsadmin";
	}
	
	@GetMapping("/administracionArea/clientsmodifyAdmin/{id}")
	public String modifyClientsAdmin(@PathVariable("id") Long id, Model model) {
		Optional<Clients> clients = clientsService.getId(id);
		model.addAttribute("clients", clients.get());
		
		return "modifyClientsAdmin";
	}
	
	@PostMapping("/administracionArea/clientsmodifyAdmin/submit")
	public String modifyClientesAdminSubmit(@ModelAttribute Clients clientsm) {
		clientsService.modifyClients(clientsm);
		
		return "redirect:/administracionArea/listclientsadmin";
	}
	
	@GetMapping("/administracionArea/clientsdeleteAdmin/{id}")
	public String deleteClientsAdmin(@PathVariable("id") Long id) {
		clientsService.eliminar(id);
		
		return "redirect:/administracionArea/listclientsadmin";		
	}

}
