package br.com.hemocentro.api.v1.command;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.hemocentro.api.v1.converter.HemocentroConverter;
import br.com.hemocentro.api.v1.model.Hemocentro;
import br.com.hemocentro.api.v1.repository.HemocentroRepository;
import br.com.hemocentro.api.v1.request.RegisterRequest;

@Validated
@Component
public class HemocentroRegister {

	@Autowired
	private HemocentroRepository hemocentroRepository;

	@Autowired
	private HemocentroConverter hemocentroConverter;

	public Hemocentro register(@Valid RegisterRequest hemocentroRegisterRequest) {
		Hemocentro hemocentro = hemocentroConverter.from(hemocentroRegisterRequest);
		hemocentro = hemocentroRepository.save(hemocentro);
		return hemocentro;
	}

}
