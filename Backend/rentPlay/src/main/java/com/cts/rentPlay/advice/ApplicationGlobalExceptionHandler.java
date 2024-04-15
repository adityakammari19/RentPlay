package com.cts.rentPlay.advice;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.rentPlay.exception.ConflictException;
import com.cts.rentPlay.exception.ResourceNotFoundException;
import com.cts.rentPlay.exception.UserNotFoundException;

@RestControllerAdvice
public class ApplicationGlobalExceptionHandler {

	 @ResponseStatus(HttpStatus.NOT_FOUND)
	    @ExceptionHandler(UserNotFoundException.class)
	    public Map<String, String> handleUserNotFoundException(UserNotFoundException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getMessage());
	        return errorMap;
	    }
	 
	 @ResponseStatus(HttpStatus.NOT_FOUND)
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public Map<String, String> handleResourceNotFoundException(ResourceNotFoundException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getMessage());
	        return errorMap;
	    }
	 
	 @ResponseStatus(HttpStatus.CONFLICT)
	    @ExceptionHandler(ConflictException.class)
	    public Map<String, String> handleConflictException(ConflictException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getMessage());
	        return errorMap;
	    }
	 
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        ex.getBindingResult().getFieldErrors().forEach(error -> {
	            errorMap.put(error.getField(), error.getDefaultMessage());
	        });
	        return errorMap;
	    }
	 
	 @ExceptionHandler(AccessDeniedException.class)
		public ResponseEntity<String> handleAccessDenied(AccessDeniedException ex){
			
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
		}

}
//@ExceptionHandler(InvalidTokenException.class)
//public ResponseEntity<String> handleInvalidToken(InvalidTokenException ex){
//	
//	return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
//}

