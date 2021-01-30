package api.config.exceptions.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import api.config.exceptions.dto.ErrorResponse;
import domain.common.exception.ResourceNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(HttpServletRequest request,
		DataIntegrityViolationException e) {
		final String message = "기본 키 또는 유니크 제약조건에 위배됩니다.";
		return ResponseEntity
			.badRequest()
			.body(new ErrorResponse(message, e.getMessage(), extractRequestedPath(request)));
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(HttpServletRequest request,
		IllegalArgumentException e) {
		return ResponseEntity
			.badRequest()
			.body(new ErrorResponse(e.getMessage(), extractRequestedPath(request)));
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCanNotFindPathException(HttpServletRequest request,
		ResourceNotFoundException e) {
		return ResponseEntity
			.badRequest()
			.body(new ErrorResponse(e.getMessage(), extractRequestedPath(request)));
	}

	private String extractRequestedPath(HttpServletRequest request) {
		return request.getServletPath();
	}

}
