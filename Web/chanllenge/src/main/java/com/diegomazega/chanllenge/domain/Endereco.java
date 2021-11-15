package com.diegomazega.chanllenge.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column()
	private String cidadeNome;
	
	@Column()
	private String cidadeBairro;
	
	@Column()
	private String cep;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="pessoa_id", nullable=false)
	private Pessoa pessoa;

	public Endereco() {}
	
	public Endereco(Long id, String cidadeNome, String cidadeBairro, String cep, Pessoa pessoa) {
		super();
		this.id = id;
		this.cidadeNome = cidadeNome;
		this.cidadeBairro = cidadeBairro;
		this.cep = cep;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidadeNome() {
		return cidadeNome;
	}

	public void setCidadeNome(String cidadeNome) {
		this.cidadeNome = cidadeNome;
	}

	public String getCidadeBairro() {
		return cidadeBairro;
	}

	public void setCidadeBairro(String cidadeBairro) {
		this.cidadeBairro = cidadeBairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
