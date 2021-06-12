package org.iesalixar.jmoreno.proyecto.controller;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.DeliveryNote;
import org.iesalixar.jmoreno.proyecto.service.DeliveryNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeliveryNoteController {

	@Autowired
	private DeliveryNoteService deliveryNoteService;
	
	@GetMapping("/administracionArea/listdeliverynote")
	public String listDeliveryNote(Model model) {
		model.addAttribute("listdeliverynote", deliveryNoteService.findAll());
		
		return "listdeliverynote";
	}
	
	@GetMapping("/administracionArea/deliverynotemodify/{id}")
	public String deliveryNoteModify(@PathVariable("id")Long id, Model model) {
		Optional<DeliveryNote> deliverynote = deliveryNoteService.getId(id);
		model.addAttribute("deliverynote", deliverynote.get());
		
		return "modifydeliveryNote";
	}
	
	@PostMapping("/administracionArea/deliverynotemodify/submit")
	public String modifyDeliveryNoteSubmit(@ModelAttribute DeliveryNote deliveryNotem) {
		deliveryNoteService.modifyDeliveryNote(deliveryNotem);
		
		return "redirect:/administracionArea/listdeliverynote";
	}
	
	@GetMapping("/administracionArea/deliverynotedelete/{id}")
	public String deleteDeliveryNote(@PathVariable("id") Long id) {
		deliveryNoteService.eliminar(id);
		
		return "redirect:/administracionArea/listdeliverynote";
	}
	
	@GetMapping("/administracionArea/deliverynotenew")
	public String deliveryNoteNew (Model model) {
		model.addAttribute("deliverynote", new DeliveryNote());
		
		return "formDeliveryNote";
	}
	
	@PostMapping("/administracionArea/deliverynotenew/submit")
	public String deliveryNoteNewSubmit(@ModelAttribute DeliveryNote deliveryNote) {
		deliveryNoteService.save(deliveryNote);
		
		return "redirect:/administracionArea";
	}
}
