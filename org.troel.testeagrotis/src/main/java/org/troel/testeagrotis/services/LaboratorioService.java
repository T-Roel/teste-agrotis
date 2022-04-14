package org.troel.testeagrotis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.troel.testeagrotis.entities.Laboratorio;
import org.troel.testeagrotis.repositories.LaboratorioRepository;
import org.troel.testeagrotis.service.exceptions.ExcecaoRecursoNaoEncontrado;

@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository repository;
	
	public List<Laboratorio> findAll() {
		return repository.findAll();
	}
	
	public Laboratorio findById(Long labId) {
		Optional<Laboratorio> lab = repository.findById(labId);
		return lab.orElseThrow(() -> new ExcecaoRecursoNaoEncontrado(labId));
	}
}
