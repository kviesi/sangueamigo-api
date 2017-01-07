package br.com.hemocentro.api.v1.converter;

import org.springframework.stereotype.Component;

import br.com.common.converter.GenericConverter;
import br.com.hemocentro.api.v1.model.Hemocentro;
import br.com.hemocentro.api.v1.request.RegisterRequest;

@Component
public class HemocentroConverterImpl implements HemocentroConverter {

	@Override
	public Hemocentro from(RegisterRequest hemocentroRegisterRequest) {
		return GenericConverter.converte(hemocentroRegisterRequest, Hemocentro.class);
	}

}
