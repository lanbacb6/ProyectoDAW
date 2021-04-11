package org.iesalixar.jmoreno.proyecto.service;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Role;
import org.iesalixar.jmoreno.proyecto.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role add(Role r) {
		roleRepository.save(r);
		return r;
	}
	
	public Role getRol(long id){
		
		return roleRepository.findById(id);
	}
}
