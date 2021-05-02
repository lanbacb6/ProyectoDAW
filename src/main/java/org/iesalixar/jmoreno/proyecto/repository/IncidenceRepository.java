package org.iesalixar.jmoreno.proyecto.repository;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Incidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenceRepository extends JpaRepository<Incidence, Long>{
	
	Optional<Incidence> findById(Long id);

}
