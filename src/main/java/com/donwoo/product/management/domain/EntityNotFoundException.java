package com.donwoo.product.management.domain;

import com.donwoo.product.management.presentation.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class EntityNotFoundException extends RuntimeException {
	public EntityNotFoundException(String message) {
		super(message);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleEntityNotFoundExceptionException(
			EntityNotFoundException ex
	) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getMessage());

		ErrorMessage errorMessage = new ErrorMessage(errors);
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
