package com.diegomazega.chanllenge.domain.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.diegomazega.chanllenge.services.validation.PessoaUpdate;

@PessoaUpdate
public class PessoaUpdateDTO {

	@NotNull(message = "Preennchimmento Obrigatório")
	private Integer idade;

	@NotNull(message = "Preennchimmento Obrigatório")
	private Set<String> telefones = new HashSet<>();

	public PessoaUpdateDTO() {
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

}
