package com.diegomazega.chanllenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegomazega.chanllenge.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	public Pessoa findByNome(String nome);
}
