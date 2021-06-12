package org.iesalixar.jmoreno.proyecto.controller;


import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Invoices;
import org.iesalixar.jmoreno.proyecto.service.ClientsService;
import org.iesalixar.jmoreno.proyecto.service.InvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InvoicesController {

	@Autowired
	private InvoicesService invoicesService;
	
	@Autowired
	private ClientsService clientsService;
	
	@GetMapping("/administracionArea/listinvoices")
	public String listInvoices (Model model) {
		model.addAttribute("listinvoices", invoicesService.findAll());
		
		return "listinvoices";
	}
	
	@GetMapping("/administracionArea/invoicesmodify/{id}")
	public String invoicesModify(@PathVariable("id")Long id, Model model) {
		Optional<Invoices> invoices = invoicesService.getId(id);
		model.addAttribute("invoices", invoices.get());
		
		return "modifyInvoices";
	}
	
	@PostMapping("/administracionArea/invoicesmodify/submit")
	public String invoicesModifySubmit(@ModelAttribute Invoices invoicesm) {
		invoicesService.modifyInvoices(invoicesm);
		
		return "redirect:/administracionArea/listinvoices";
	}
	
	@GetMapping("/administracionArea/invoicesdelete/{id}")
	public String invoicesDelete(@PathVariable("id") Long id) {
		invoicesService.eliminar(id);
		
		return "redirect:/administracionArea/listinvoices";
	}
	
	@GetMapping("/administracionArea/invoicesnew")
	public String invoicesNew(Model model) {
		model.addAttribute("invoices", new Invoices());
		model.addAttribute("clients", clientsService.findAll());
		
		return "formInvoices";
	}
	
	@PostMapping("/administracionArea/invoicesnew/submit")
	public String invoicesNewSubmit(@ModelAttribute Invoices invoices) {
		invoicesService.save(invoices);
		
		return "redirect:/administracionArea";
	}
	
}
