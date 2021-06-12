package org.iesalixar.jmoreno.proyecto.repository;

import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.DeliveryNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface DeliveryNoteRepository extends JpaRepository<DeliveryNote, Long>{

	Optional <DeliveryNote> findById(Long id);
	
}
