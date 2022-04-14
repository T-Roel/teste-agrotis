package org.troel.testeagrotis.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.troel.testeagrotis.entities.InfosPropriedade;
import org.troel.testeagrotis.services.InfosPropriedadeService;

@RestController
@RequestMapping(value = "/infos")
public class InfosPropriedadeResource {

	@Autowired
	InfosPropriedadeService service;

	@GetMapping
	public ResponseEntity<List<InfosPropriedade>> findAll() {
		List<InfosPropriedade> infos = service.findAll();
		return ResponseEntity.ok().body(infos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<InfosPropriedade> findById(@PathVariable Long id) {
		InfosPropriedade info = service.findById(id);
		return ResponseEntity.ok().body(info);
	}
}
