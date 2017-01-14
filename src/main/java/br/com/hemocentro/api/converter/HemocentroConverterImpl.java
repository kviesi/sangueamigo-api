package br.com.hemocentro.api.converter;

import org.springframework.stereotype.Component;

import br.com.common.converter.GenericConverter;
import br.com.hemocentro.api.model.Hemocentro;
import br.com.hemocentro.api.request.RegisterRequest;

@Component
public class HemocentroConverterImpl implements HemocentroConverter {

	@Override
	public Hemocentro from(RegisterRequest hemocentroRegisterRequest) {
		return GenericConverter.converte(hemocentroRegisterRequest, Hemocentro.class);
	}

}
