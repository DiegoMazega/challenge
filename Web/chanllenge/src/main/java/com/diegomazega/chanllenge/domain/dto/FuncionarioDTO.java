package com.diegomazega.chanllenge.domain.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class FuncionarioDTO {
	
	@NotEmpty(message = "Preennchimmento Obrigatório")
	private String cargo;
	
	@NotEmpty(message = "Preennchimmento Obrigatório")
	@Length(min = 5 , max = 120, message = "O tamanho tem que ser entre 5 e 80 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preennchimmento Obrigatório")
	@Length(min = 5 , max = 120, message = "O tamanho tem que ser entre 5 e 80 caracteres")
	private String empresa;
	
	public FuncionarioDTO() {}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	
}
