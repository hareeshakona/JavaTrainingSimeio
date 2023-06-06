package com.bookapp.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiErrors {

	LocalDateTime timestamp;
	String message;
	HttpStatus status;
	int statusCode;
	List<Object> error;
	

	public ApiErrors(LocalDateTime timestamp, String message, HttpStatus status, int statusCode, List<Object> error) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.error = error;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<Object> getError() {
		return error;
	}

	public void setError(List<Object> error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ApiErrors [timestamp=" + timestamp + ", message=" + message + ", status=" + status + ", statusCode="
				+ statusCode + ", error=" + error + "]";
	}


	
	
}
