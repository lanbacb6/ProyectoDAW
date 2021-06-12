package org.iesalixar.jmoreno.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.DeliveryNote;
import org.iesalixar.jmoreno.proyecto.repository.DeliveryNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryNoteService {

	@Autowired
	private DeliveryNoteRepository deliveryNoteRepository;

	@Autowired
	private DeliveryNoteService deliveryNoteService;

	public DeliveryNote save(DeliveryNote d) {
		deliveryNoteRepository.save(d);

		return d;
	}

	public List<DeliveryNote> findAll() {
		return deliveryNoteRepository.findAll();
	}

	public Optional<DeliveryNote> getId(Long id) {
		return deliveryNoteRepository.findById(id);
	}

	public void eliminar(Long id) {
		deliveryNoteRepository.deleteById(id);
	}

	public void modifyDeliveryNote(DeliveryNote dnm) {
		List<DeliveryNote> ls = deliveryNoteService.findAll();

		for (DeliveryNote dn : ls) {
			if (dn.getId().equals(dnm.getId())) {
				dn.setFecha(dnm.getFecha());
				dn.setDescripcion(dnm.getDescripcion());
				deliveryNoteRepository.save(dn);
			}
		}
	}

}
