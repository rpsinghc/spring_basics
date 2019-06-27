package hacker.hacker.handlers;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ErrorHandlers {

	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<?> sqlError(Exception e) {
		log.error("Error in request", e);
		return ResponseEntity.badRequest().build();
	}
	
}
