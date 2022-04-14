package org.troel.testeagrotis.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_laboratorio")
public class Laboratorio implements Serializable {

	private static final long serialVersionUID = 8901354123382263499L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long laboratorioId;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "tela_id")
	private TelaTeste tela;
	
	public Laboratorio() {
	}
	
	public Laboratorio(Long laboratorioId, String nome, TelaTeste tela) {
		this.laboratorioId = laboratorioId;
		this.nome = nome;
		this.tela = tela;
	}

	public Long getLaboratorioId() {
		return laboratorioId;
	}

	public void setLaboratorioId(Long laboratorioId) {
		this.laboratorioId = laboratorioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public TelaTeste getTelas() {
		return tela;
	}
	
	public void setTela(TelaTeste tela) {
		this.tela = tela;
	}

	@Override
	public int hashCode() {
		return Objects.hash(laboratorioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laboratorio other = (Laboratorio) obj;
		return Objects.equals(laboratorioId, other.laboratorioId);
	}
}
