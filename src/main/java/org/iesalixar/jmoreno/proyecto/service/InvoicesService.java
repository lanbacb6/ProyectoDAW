package org.iesalixar.jmoreno.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.iesalixar.jmoreno.proyecto.model.Invoices;
import org.iesalixar.jmoreno.proyecto.repository.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoicesService {

	@Autowired
	private InvoicesRepository invoicesRepository;

	@Autowired
	private InvoicesService invoicesService;

	public Invoices save(Invoices i) {
		invoicesRepository.save(i);
		return i;
	}

	public List<Invoices> findAll() {
		return invoicesRepository.findAll();
	}

	public Optional<Invoices> getId(Long id) {
		return invoicesRepository.findById(id);
	}
	
	public void eliminar(Long id) {
		invoicesRepository.deleteById(id);
	}

	public void modifyInvoices(Invoices invoicesm) {
		List<Invoices> ls = invoicesService.findAll();

		for (Invoices in : ls) {
			if (in.getId().equals(invoicesm.getId())) {
				in.setDescripcion(invoicesm.getDescripcion());
				in.setFecha(invoicesm.getFecha());
				in.setPrecio(invoicesm.getPrecio());			

				invoicesRepository.save(in);
			}
		}
	}

}
