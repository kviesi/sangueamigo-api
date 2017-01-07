package br.com.hemocentro.api.v1.converter;

import org.mapstruct.Mapper;

import br.com.hemocentro.api.v1.model.Hemocentro;
import br.com.hemocentro.api.v1.request.RegisterRequest;

@Mapper(componentModel = "spring")
public interface HemocentroConverter {

	public Hemocentro from(RegisterRequest hemocentroRegisterRequest);

}
