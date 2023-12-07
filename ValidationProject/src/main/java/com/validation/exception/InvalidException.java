package com.validation.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidException {
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> exceptionHandle(MethodArgumentNotValidException ex){
		
		Map<String, String> excep = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->
		{
			excep.put(error.getField(), error.getDefaultMessage());
		});
		
	    return excep;
	
	

}
}
