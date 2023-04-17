package com.example.lightfeather.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.lightfeather.model.ErrorMessage;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorMessage> exception(Exception exception) {
		logger.info("there is an some issue in the System {}", exception.getStackTrace());
		ErrorMessage error = new ErrorMessage();
		error.setErrorMessage(exception.getMessage());
		error.setDetailedMessage(exception.getCause().toString());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<>("Method Argument is Not Valid", HttpStatus.BAD_REQUEST);
	}

}
