package com.diegomazega.chanllenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegomazega.chanllenge.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
