package com.hotelapp.exceptions;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hotelapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("This method is not supported",
				"Supported methods are" + ex.getSupportedHttpMethods());
		headers.add("info", "Invalid method");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("This media type is not supported",
				"Supported media types are" + ex.getSupportedMediaTypes());
		headers.add("info", "Invalid media type");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("Path variable is missing", "Expected " + ex.getVariableName());
		headers.add("info", "Missing path variable");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("Missing servlet request parameter", "Expected " + ex.getParameterName());
		headers.add("info", "Missing path variable");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("Type mismatch", "Expected " + ex.getRequiredType());
		headers.add("info", "Missing path variable");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<Object> handleHotelNotFound(Exception ex) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("hotel not found");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", "other exception found");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, HttpStatus.INTERNAL_SERVER_ERROR,
				HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(httpHeaders).body(errors);
	}

	@ExceptionHandler(ReservationNotFoundException.class)
	public ResponseEntity<Object> handleReservationNotFound(Exception ex) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("reservation not found");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", "other exception found");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, HttpStatus.INTERNAL_SERVER_ERROR,
				HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(httpHeaders).body(errors);
	}

	@ExceptionHandler(RoomNotFoundException.class)
	public ResponseEntity<Object> handleRoomNotFound(Exception ex) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("room not found");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", "other exception found");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, HttpStatus.INTERNAL_SERVER_ERROR,
				HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(httpHeaders).body(errors);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFound(Exception ex) {
		String message = ex.getMessage();
		List<Object> error = Arrays.asList("user not found");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", "other exception found");
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, HttpStatus.INTERNAL_SERVER_ERROR,
				HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(httpHeaders).body(errors);
	}

}
