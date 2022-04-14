package org.troel.testeagrotis.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_tela")
public class TelaTeste implements Serializable {

	private static final long serialVersionUID = 4258881264667815651L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long telaTesteId;
	
	private String nome;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataInicial;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataFinal;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tela")
	private List<InfosPropriedade> infosPros = new ArrayList<>();
	
	private String cnpj;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tela")
	private List<Laboratorio> laboratorio = new ArrayList<>();
	
	private String observacoes;
	
	public TelaTeste() {
	}

	public TelaTeste(Long telaTesteId, String nome, Instant dataInicial, Instant dataFinal, String cnpj, String observacoes) {
		this.telaTesteId = telaTesteId;
		this.nome = nome;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.cnpj = cnpj;
		this.observacoes = observacoes;
	}

	public Long getTelaTesteId() {
		return telaTesteId;
	}

	public void setTelaTesteId(Long telaTesteId) {
		this.telaTesteId = telaTesteId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Instant getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Instant dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Instant getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Instant dataFinal) {
		this.dataFinal = dataFinal;
	}

	public List<InfosPropriedade> getInfosPropriedadeList() {
		return infosPros;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Laboratorio> getLaboratorio() {
		return laboratorio;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(telaTesteId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TelaTeste other = (TelaTeste) obj;
		return Objects.equals(telaTesteId, other.telaTesteId);
	}
}
