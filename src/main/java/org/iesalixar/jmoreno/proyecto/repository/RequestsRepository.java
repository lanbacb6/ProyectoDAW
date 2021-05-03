package org.iesalixar.jmoreno.proyecto.repository;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsRepository extends JpaRepository<Requests, Long> {
	
	Optional<Requests> findById(Long id);

}
