package org.iesalixar.jmoreno.proyecto.controller;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Orders;
import org.iesalixar.jmoreno.proyecto.service.OrdersService;
import org.iesalixar.jmoreno.proyecto.service.ProvidersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdersController {

	@Autowired
	private  OrdersService ordersService;
	
	@Autowired
	private ProvidersService providersService;
	
	@GetMapping("/administracionArea/listorders")
	public String listOrders(Model model) {
		model.addAttribute("listorders", ordersService.findAll());
		
		return "listorders";
	}
	
	@GetMapping("/administracionArea/ordersmodify/{id}")
	public String modifyOrders(@PathVariable("id")Long id, Model model) {
		Optional<Orders> orders = ordersService.getId(id);
		model.addAttribute("orders", orders.get());
		
		return "modifyOrder";
	}
	
	@PostMapping("/administracionArea/ordersmodify/submit")
	public String modifyOrdersSubmit(@ModelAttribute Orders orderm) {
		ordersService.modifyOrders(orderm);
		
		return "redirect:/administracionArea/listorders";
	}
	
	@GetMapping("/administracionArea/ordersdelete/{id}")
	public String deleteOrders(@PathVariable("id") Long id) {
		ordersService.eliminar(id);
		
		return "redirect:/administracionArea/listorders";
	}
	
	@GetMapping("/administracionArea/ordersnew")
	public String orderNew(Model model) {
		model.addAttribute("orders", new Orders());
		model.addAttribute("providers", providersService.findAll());
		
		return "formOrders";
	}
	
	@PostMapping("/administracionArea/ordersnew/submit")
	public String orderNewSubmit(@ModelAttribute Orders orders) {
		ordersService.save(orders);
		
		return "redirect:/administracionArea";
	}
}
