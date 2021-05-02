package org.iesalixar.jmoreno.proyecto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private RoleService roleService;

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
		User user = new User(registrationDto.getNombre(), registrationDto.getApellidos(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(rolRepository.findById(4l)));

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);		
		
		if (user == null) {
			throw new UsernameNotFoundException("No es valido username o password");

		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));

	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> findSinRol() {
		List<User> sR = new ArrayList<User>();
		List<User> ls = userRepository.findAll();
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i).getRoles().stream().anyMatch(r -> r.getName().equals("ROLE_SIN"))) {
				sR.add(ls.get(i));
			}
		}

		return sR;
	}

	public List<User> findConRol() {
		List<User> cR = new ArrayList<User>();
		List<User> ls = userRepository.findAll();
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i).getRoles().stream().anyMatch(r -> r.getName().equals("ROLE_ROOT"))
					|| ls.get(i).getRoles().stream().anyMatch(r -> r.getName().equals("ROLE_TRABAJADOR"))
					|| ls.get(i).getRoles().stream().anyMatch(r -> r.getName().equals("ROLE_ADMINISTRACION"))) {
				cR.add(ls.get(i));
			}
		}

		return cR;
	}	

	public void eliminar(Long id) {
		userRepository.deleteById(id);
	}
	
	public Optional<User> getId(Long id) {
	
		return userRepository.findById(id);
	}

	public void modifyUser(User userm) {
		List<User> ls = userService.findAll();
		
		for(User us : ls) {
			if(us.getId().equals(userm.getId())) {
				us.setNombre(userm.getNombre());
				us.setApellidos(userm.getApellidos());
				us.setEmail(userm.getEmail());
				us.setRoles(userm.getRoles());
				userRepository.save(us);
			}
		}
		
		
		
	}
	
	
	

}
