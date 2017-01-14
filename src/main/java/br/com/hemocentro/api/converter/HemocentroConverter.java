package br.com.hemocentro.api.converter;

import org.mapstruct.Mapper;

import br.com.hemocentro.api.model.Hemocentro;
import br.com.hemocentro.api.request.RegisterRequest;

@Mapper(componentModel = "spring")
public interface HemocentroConverter {

	public Hemocentro from(RegisterRequest hemocentroRegisterRequest);

}
