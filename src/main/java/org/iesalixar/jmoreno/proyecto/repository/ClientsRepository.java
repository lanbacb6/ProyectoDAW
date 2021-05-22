package org.iesalixar.jmoreno.proyecto.repository;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long>{

	Optional <Clients> findById(Long id);
}
