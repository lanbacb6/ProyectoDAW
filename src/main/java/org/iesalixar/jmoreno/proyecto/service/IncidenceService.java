package org.iesalixar.jmoreno.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Incidence;
import org.iesalixar.jmoreno.proyecto.repository.IncidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidenceService {

	@Autowired
	private IncidenceRepository incidenceRepository;
	
	@Autowired
	private IncidenceService incidenceService;
	
	public Incidence save(Incidence i) {
		incidenceRepository.save(i);
		return i;
	}
	
	public List<Incidence> findAll(){
		return incidenceRepository.findAll();
	}
	
	public Optional<Incidence> getId(Long id) {
		
		return incidenceRepository.findById(id);
	}

	public void modifyIncidence(Incidence incidencem) {
		List<Incidence> ls = incidenceService.findAll();
		
		for(Incidence in : ls) {
			if(in.getId().equals(incidencem.getId())) {
				in.setDescripcion(incidencem.getDescripcion());
				in.setEstado(incidencem.getEstado());
				in.setFecha(incidencem.getFecha());
				in.setId(incidencem.getId());			
				
				incidenceRepository.save(in);
			}
		}
		
	}
	
}
