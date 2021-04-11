package org.iesalixar.jmoreno.proyecto;

import org.iesalixar.jmoreno.proyecto.model.Role;
import org.iesalixar.jmoreno.proyecto.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	/*@Bean
	CommandLineRunner initData(RoleRepository roleRepository) {
		
		return (args)-> {
			Role r1 = null;
			r1 = new Role();
			r1.setName("ROLE_ROOT");			
			roleRepository.save(r1);
			
			
			Role r2 = null;
			r2 = new Role();
			r2.setName("ROLE_TRABAJADOR");
			roleRepository.save(r2);
			
			
			Role r3 = null;
			r3 =  new Role();
			r3.setName("ROLE_ADMINISTRACION");			
			roleRepository.save(r3);
			
			Role r4 = null;
			r4 = new Role();			
			r4.setName("ROLE_SIN");
			roleRepository.save(r4);
		};
	}*/

}
