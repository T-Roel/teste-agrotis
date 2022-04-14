package org.troel.testeagrotis.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.troel.testeagrotis.entities.Laboratorio;
import org.troel.testeagrotis.services.LaboratorioService;

@RestController
@RequestMapping(value = "/laboratorios")
public class LaboratoriosResource {

	@Autowired
	LaboratorioService service;

	@GetMapping
	public ResponseEntity<List<Laboratorio>> findAll() {
		List<Laboratorio> labs = service.findAll();
		return ResponseEntity.ok().body(labs);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Laboratorio> findById(@PathVariable Long id) {
		Laboratorio lab = service.findById(id);
		return ResponseEntity.ok().body(lab);
	}
}
