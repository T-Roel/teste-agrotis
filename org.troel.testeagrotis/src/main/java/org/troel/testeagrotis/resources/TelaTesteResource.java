package org.troel.testeagrotis.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.troel.testeagrotis.entities.TelaTeste;
import org.troel.testeagrotis.services.TelaTesteService;

@RestController
@RequestMapping(value = "/tela")
public class TelaTesteResource {
	
	@Autowired
	TelaTesteService service;

	@GetMapping
	public ResponseEntity<List<TelaTeste>> findAll() {
		List<TelaTeste> telas = service.findAll();
		return ResponseEntity.ok().body(telas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TelaTeste> findById(@PathVariable Long id) {
		TelaTeste tela = service.findById(id);
		return ResponseEntity.ok().body(tela);
	}
	
	@PostMapping
	public ResponseEntity<TelaTeste> insert(@RequestBody TelaTeste tela) {
		tela = service.insert(tela);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tela.getTelaTesteId()).toUri();
		return ResponseEntity.created(uri).body(tela);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long telaId) {
		service.delete(telaId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TelaTeste> update(@PathVariable Long telaId, @RequestBody TelaTeste tela) {
		tela = service.update(telaId, tela);
		return ResponseEntity.ok().body(tela);
	}
}
