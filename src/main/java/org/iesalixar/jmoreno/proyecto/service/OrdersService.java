package org.iesalixar.jmoreno.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Orders;
import org.iesalixar.jmoreno.proyecto.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private OrdersService ordersService;
	
	public Orders save (Orders o) {
		ordersRepository.save(o);
		
		return o;
	}
	
	public List<Orders> findAll(){
		return ordersRepository.findAll();
	}
	
	public Optional<Orders> getId(Long id){
		return ordersRepository.findById(id);
	}
	
	public void eliminar(Long id) {
		ordersRepository.deleteById(id);
	}
	
	public void modifyOrders(Orders orderm) {
		List <Orders> ls = ordersService.findAll();
		
		for(Orders or : ls) {
			if(or.getId().equals(orderm.getId())) {
				or.setFecha(orderm.getFecha());
				or.setDescripcion(orderm.getDescripcion());
				or.setPrecio(orderm.getPrecio());
				ordersRepository.save(or);
			}
		}
	}
}
