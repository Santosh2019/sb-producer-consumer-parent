package com.accenture.consumer.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.accenture.consumer.exception.dto.ErrorResponse;

@ControllerAdvice
public class ConsumerAppExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> details = new ArrayList<>();

		for (int i = 0; i < ex.getBindingResult().getAllErrors().size(); i++) {
			ObjectError error = ex.getBindingResult().getAllErrors().get(i);
			details.add(ex.getFieldErrors().get(i).getField() + " : " + error.getDefaultMessage());

		}

		ErrorResponse error = new ErrorResponse("Validation Failed", details);

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserBussinessException.class)
	public ResponseEntity<Object> handleUserBussinessExceptionException(UserBussinessException ex) {
		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());

		ErrorResponse error = new ErrorResponse("UserBussiness Exception", details);

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
