package org.iesalixar.jmoreno.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Providers;
import org.iesalixar.jmoreno.proyecto.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvidersService {

	@Autowired
	private ProvidersRepository providersRepository;
	
	@Autowired
	private ProvidersService providersService;
	
	public Providers save (Providers p) {
		providersRepository.save(p);
		
		return p;
	}
	
	public List<Providers> findAll(){
		return providersRepository.findAll();
	}
	
	public Optional<Providers> getId(Long id){
		return providersRepository.findById(id);
	}
	
	public void eliminar(Long id) {
		providersRepository.deleteById(id);
	}
	
	public void modifyProvider (Providers providersm) {
		List<Providers> ls = providersService.findAll();
		
		for(Providers pr : ls) {
			if(pr.getId().equals(providersm.getId())) {
				pr.setId(providersm.getId());
				pr.setCif(providersm.getCif());
				pr.setDireccion(providersm.getDireccion());
				pr.setNombre(providersm.getNombre());
				pr.setProvincia(providersm.getProvincia());
				pr.setTelefono(providersm.getTelefono());
				
				providersRepository.save(providersm);
			}
		}
	}
	
}
