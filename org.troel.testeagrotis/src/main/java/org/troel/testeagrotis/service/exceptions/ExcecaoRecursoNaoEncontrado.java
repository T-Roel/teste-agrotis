package org.troel.testeagrotis.service.exceptions;

public class ExcecaoRecursoNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = -7152980716877138085L;
	
	public ExcecaoRecursoNaoEncontrado(Object id) {
		super("Recurso não encontrato. Id" + id);
	}
}
