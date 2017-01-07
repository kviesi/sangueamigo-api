package br.com.common.converter;

import org.springframework.beans.BeanUtils;

public class GenericConverter {

	private GenericConverter() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T converter(Object source, Class<?> target) {
		try {
			Object targetInstance = target.newInstance();
			BeanUtils.copyProperties(source, targetInstance);
			return (T) targetInstance;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
