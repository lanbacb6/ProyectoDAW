package org.iesalixar.jmoreno.proyecto.service;

import org.iesalixar.jmoreno.proyecto.model.User;
import org.iesalixar.jmoreno.proyecto.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationDto);
	
}
