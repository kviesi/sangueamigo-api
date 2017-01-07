package br.com.common.converter;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.BeanUtils;

public class GenericConverter {

	private GenericConverter() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T converte(Object source, Class<?> target) {
		try {
			Object targetInstance = target.newInstance();
			BeanUtils.copyProperties(source, targetInstance);
			return (T) targetInstance;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> Collection<T> converte(Iterable<Object> source, Class<?> target) {
		ArrayList<T> items = new ArrayList<>();
		source.forEach(o -> {
			items.add(converte(o, target));
		});
		return items;
	}

}
