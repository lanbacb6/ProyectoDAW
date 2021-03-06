package org.iesalixar.jmoreno.proyecto.repository;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Providers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidersRepository extends JpaRepository<Providers, Long> {
	
	Optional <Providers> findById(Long id);

}
