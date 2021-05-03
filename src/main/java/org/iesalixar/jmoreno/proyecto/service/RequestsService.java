package org.iesalixar.jmoreno.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Requests;
import org.iesalixar.jmoreno.proyecto.repository.RequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestsService {
	
	@Autowired
	private RequestsRepository requestsRepository;
	
	@Autowired
	private RequestsService requestsService;
	
	public Requests save (Requests r) {
		requestsRepository.save(r);
		return r;
	}
	
	public List<Requests> findAll(){
		return requestsRepository.findAll();
	} 
	
	public Optional<Requests> getId(Long id){
		return requestsRepository.findById(id);
	}

	public void modifyRequests(Requests requestsm) {
		List<Requests> ls = requestsService.findAll();
		
		for(Requests re : ls) {
			if(re.getId().equals(requestsm.getId())) {
				re.setDescripcion(requestsm.getDescripcion());
				re.setEstado(requestsm.getEstado());
				re.setFechaFin(requestsm.getFechaFin());
				re.setFechaInicio(requestsm.getFechaInicio());
				re.setId(requestsm.getId());
				
				requestsRepository.save(re);				
				
			}
		}
		
	}
}
