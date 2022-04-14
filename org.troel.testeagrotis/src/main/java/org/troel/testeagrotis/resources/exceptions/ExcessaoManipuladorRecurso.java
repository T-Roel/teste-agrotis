package org.troel.testeagrotis.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.troel.testeagrotis.service.exceptions.ExcecaoBD;
import org.troel.testeagrotis.service.exceptions.ExcecaoRecursoNaoEncontrado;

@ControllerAdvice
public class ExcessaoManipuladorRecurso {
	
	@ExceptionHandler(ExcecaoRecursoNaoEncontrado.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(ExcecaoRecursoNaoEncontrado e, HttpServletRequest request) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao padrao = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(padrao);
	}
	
	@ExceptionHandler(ExcecaoBD.class)
	public ResponseEntity<ErroPadrao> excecaoBancoDeDados(ExcecaoBD e, HttpServletRequest request) {
		String error = "Erro Banco de Dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao padrao = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(padrao);
	}
}
