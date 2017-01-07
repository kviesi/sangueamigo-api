package br.com.hemocentro.api.converter;

import org.springframework.stereotype.Component;

import br.com.common.converter.GenericConverter;
import br.com.hemocentro.api.model.Hemocentro;
import br.com.hemocentro.api.request.HemocentroRegisterRequest;

@Component
public class HemocentroConverterImpl implements HemocentroConverter {

	@Override
	public Hemocentro from(HemocentroRegisterRequest hemocentroRegisterRequest) {
		return GenericConverter.converter(hemocentroRegisterRequest, Hemocentro.class);
	}

}
