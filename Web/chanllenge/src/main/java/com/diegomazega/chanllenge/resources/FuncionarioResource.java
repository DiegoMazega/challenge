package com.diegomazega.chanllenge.resources;

import org.springframework.web.bind.annotation.RequestMapping;

import com.diegomazega.chanllenge.domain.Funcionario;

@RequestMapping(value = "/funcionarios")
public class FuncionarioResource extends Resource<Funcionario> {

}
