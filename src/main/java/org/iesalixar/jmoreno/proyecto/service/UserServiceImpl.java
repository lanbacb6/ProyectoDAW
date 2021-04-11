package org.iesalixar.jmoreno.proyecto.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.iesalixar.jmoreno.proyecto.model.Role;
import org.iesalixar.jmoreno.proyecto.model.User;
import org.iesalixar.jmoreno.proyecto.repository.RoleRepository;
import org.iesalixar.jmoreno.proyecto.repository.UserRepository;
import org.iesalixar.jmoreno.proyecto.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository rolRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getNombre(), registrationDto.getApellidos(), registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),
				Arrays.asList(rolRepository.findById(4l)));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("No es valido username o password");
			
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
		
		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	
	}

}

