package org.troel.testeagrotis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.troel.testeagrotis.entities.InfosPropriedade;
import org.troel.testeagrotis.repositories.InfosPropriedadeRepository;
import org.troel.testeagrotis.service.exceptions.ExcecaoRecursoNaoEncontrado;

@Service
public class InfosPropriedadeService {

	@Autowired
	private InfosPropriedadeRepository repository;
	
	public List<InfosPropriedade> findAll() {
		return repository.findAll();
	}
	
	public InfosPropriedade findById(Long infPropId) {
		Optional<InfosPropriedade> inf = repository.findById(infPropId);
		return inf.orElseThrow(() -> new ExcecaoRecursoNaoEncontrado(infPropId));
	}
}
