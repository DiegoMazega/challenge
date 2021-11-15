package com.diegomazega.chanllenge.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.diegomazega.chanllenge.domain.Pessoa;
import com.diegomazega.chanllenge.domain.dto.PessoaDTO;
import com.diegomazega.chanllenge.repositories.PessoaRepository;
import com.diegomazega.chanllenge.resources.exception.FieldMessage;

public class PessoaInsertValidator implements ConstraintValidator<PessoaInsert, PessoaDTO> {

	@Autowired
	private PessoaRepository repo;

	@Override
	public void initialize(PessoaInsert ann) {
	}

	@Override
	public boolean isValid(PessoaDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, altere para validar o que quiser.

		if (objDto.getNome() != null) {
			Pessoa aux = repo.findByNome(objDto.getNome());

			if (aux != null) {
				list.add(new FieldMessage("Nome", "Nome já existente"));
			}
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
