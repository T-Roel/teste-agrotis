package org.troel.testeagrotis.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.troel.testeagrotis.entities.TelaTeste;
import org.troel.testeagrotis.repositories.TelaTesteRepository;
import org.troel.testeagrotis.service.exceptions.ExcecaoBD;
import org.troel.testeagrotis.service.exceptions.ExcecaoRecursoNaoEncontrado;

@Service
public class TelaTesteService {
	
	@Autowired
	private TelaTesteRepository repository;
	
	public List<TelaTeste> findAll() {
		return repository.findAll();
	}
	
	public TelaTeste findById(Long telaTesteId) {
		Optional<TelaTeste> tel = repository.findById(telaTesteId);
		return tel.orElseThrow(() -> new ExcecaoRecursoNaoEncontrado(telaTesteId));
	}
	
	public TelaTeste insert(TelaTeste telaTeste) {
		return repository.save(telaTeste);
	}
	
	public void delete(Long telaTesteId) {
		try {
			repository.deleteById(telaTesteId);
		}catch(EmptyResultDataAccessException e) {
			throw new ExcecaoRecursoNaoEncontrado(telaTesteId);
		}catch(DataIntegrityViolationException e) {
			throw new ExcecaoBD(e.getMessage());
		}
	}
	
	public TelaTeste update(Long telaTesteId, TelaTeste tela) {
		try {
			TelaTeste tel = repository.getById(telaTesteId);
			updateData(tel, tela);
			return repository.save(tel);
		}catch(EntityNotFoundException e) {
			throw new ExcecaoRecursoNaoEncontrado(telaTesteId);
		}
	}
	
	private void updateData(TelaTeste tel, TelaTeste tela) {
		tel.setCnpj(tela.getCnpj());
		tel.setDataFinal(tela.getDataFinal());
		tel.setDataInicial(tela.getDataInicial());
		tel.setNome(tela.getNome());
		tel.setObservacoes(tela.getObservacoes());
	}
}
