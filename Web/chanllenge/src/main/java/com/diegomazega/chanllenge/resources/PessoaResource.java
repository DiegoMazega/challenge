package com.diegomazega.chanllenge.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegomazega.chanllenge.domain.Pessoa;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource extends Resource<Pessoa> {
	
}
