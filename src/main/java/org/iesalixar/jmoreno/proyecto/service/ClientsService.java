package org.iesalixar.jmoreno.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Clients;
import org.iesalixar.jmoreno.proyecto.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
	
	@Autowired
	private ClientsRepository clientsRepository;
	
	@Autowired
	private ClientsService clientsService;
	
	public Clients save (Clients c) {
		clientsRepository.save(c);
		
		return c;
	}
	
	public List<Clients> findAll(){
		return clientsRepository.findAll();
	}
	
	public Optional<Clients> getId(Long id){
		return clientsRepository.findById(id);
	}
	
	public void eliminar(Long id) {
		clientsRepository.deleteById(id);
	}
	
	public void modifyClients(Clients clm) {
		List<Clients> ls = clientsService.findAll();
		
		for(Clients cl :ls) {
			if(cl.getId().equals(clm.getId())) {
				cl.setNombre(clm.getNombre());
				cl.setApellidos(clm.getApellidos());
				cl.setDireccion(clm.getDireccion());
				cl.setTelefono(clm.getTelefono());				
				clientsRepository.save(clm);
			}
		}
	}

}
