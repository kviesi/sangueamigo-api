package br.com.common.json;

import java.util.Map;

import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

	private final ObjectMapper objectMapper;

	public JsonConverter(ObjectMapper objectMapper) {
		Assert.notNull(objectMapper);
		this.objectMapper = objectMapper;
	}

	public String toJSON(Map<String, Object> content) {
		String json;
		try {
			json = objectMapper.writeValueAsString(content);
		} catch (JsonProcessingException e) {
			throw new RuntimeException();
		}
		return json;
	}

}
