package br.com.hemocentro.api.command;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.hemocentro.api.converter.HemocentroConverter;
import br.com.hemocentro.api.model.Hemocentro;
import br.com.hemocentro.api.repository.HemocentroRepository;
import br.com.hemocentro.api.request.HemocentroRegisterRequest;

@Validated
@Component
public class HemocentroRegister {

	@Autowired
	private HemocentroRepository hemocentroRepository;

	@Autowired
	private HemocentroConverter hemocentroConverter;

	public Hemocentro register(@Valid HemocentroRegisterRequest hemocentroRegisterRequest) {
		Hemocentro hemocentro = hemocentroConverter.from(hemocentroRegisterRequest);
		hemocentro = hemocentroRepository.save(hemocentro);
		return hemocentro;
	}

}
