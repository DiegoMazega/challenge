package com.diegomazega.chanllenge.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.diegomazega.chanllenge.domain.dto.PessoaUpdateDTO;
import com.diegomazega.chanllenge.resources.exception.FieldMessage;

public class PessoaUpdateValidator implements ConstraintValidator<PessoaUpdate, PessoaUpdateDTO> {


	@Override
	public void initialize(PessoaUpdate ann) {
	}

	@Override
	public boolean isValid(PessoaUpdateDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, altere para validar o que quiser.

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
