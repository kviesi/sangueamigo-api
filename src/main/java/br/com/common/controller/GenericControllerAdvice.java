package br.com.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.common.exception.BaseException;

@ControllerAdvice
public class GenericControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {

		if (e instanceof BaseException) {

			BaseException baseException = (BaseException) e;

			Map<String, Object> dto = new HashMap<>(1);
			dto.put("error", ((BaseException) e).getKey());

			return ResponseEntity.status(baseException.getHttpStatus()).body(dto);

		}
		
		e.printStackTrace();

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
