package org.troel.testeagrotis.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErroPadrao implements Serializable {

	private static final long serialVersionUID = 4411388394137451423L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant instant;
	
	private Integer status;
	
	private String erro;
	
	private String message;
	
	private String caminho;
	
	public ErroPadrao() {
	}

	public ErroPadrao(Instant instant, Integer status, String erro, String message, String caminho) {
		this.instant = instant;
		this.status = status;
		this.erro = erro;
		this.message = message;
		this.caminho = caminho;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
