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
@Table(name = "tb_infos")
public class InfosPropriedade implements Serializable {

	private static final long serialVersionUID = -4149942910363023367L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long infosPropriedadeId;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "tela_id")
	private TelaTeste tela;
	
	public InfosPropriedade() {
	}

	public InfosPropriedade(Long infosPropriedadeId, String nome, TelaTeste tela) {
		this.infosPropriedadeId = infosPropriedadeId;
		this.nome = nome;
		this.tela = tela;
	}

	public Long getInfosPropriedadeId() {
		return infosPropriedadeId;
	}

	public void setInfosPropriedadeId(Long infosPropriedadeId) {
		this.infosPropriedadeId = infosPropriedadeId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TelaTeste getTela() {
		return tela;
	}
	
	public void setTela(TelaTeste tela) {
		this.tela = tela;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(infosPropriedadeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfosPropriedade other = (InfosPropriedade) obj;
		return Objects.equals(infosPropriedadeId, other.infosPropriedadeId);
	}
}
