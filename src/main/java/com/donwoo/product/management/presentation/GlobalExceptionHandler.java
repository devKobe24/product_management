package com.donwoo.product.management.presentation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleConstraintViolatedException(
			ConstraintViolationException ex
	) {
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		List<String> errors = constraintViolations.stream()
		                                          .map(
																									constraintViolation -> extraField(constraintViolation.getPropertyPath()) + ", " + constraintViolation.getMessage()
		                                          )
		                                          .toList();

		ErrorMessage errorMessage = new ErrorMessage(errors);
		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleMethodArgumentNotVaildException(
			MethodArgumentNotValidException ex
	) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<String> errors = fieldErrors.stream()
				.map(
						fieldError -> fieldError.getField() + ", " + fieldError.getDefaultMessage()
				)
				.toList();

		ErrorMessage errorMessage = new ErrorMessage(errors);
		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	}

	private String extraField(Path path) {
		String[] splittedArray = path.toString().split("[.]");
		int lastIndex = splittedArray.length - 1;
		return splittedArray[lastIndex];
	}
}
