package com.newindianews.app.exceptionhandleer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.newindianews.app.dto.ErrorDto;
import com.newindianews.app.dto.ResponseDto;
import com.newindianews.app.exception.AppException;

@RestControllerAdvice(assignableTypes = {Controller.class})
public class GlobalExceptionHandler {
	@ExceptionHandler(AppException.class)
	public ResponseEntity<ResponseDto<?>> NewIndiaNewsApplicationExceptionHandler(Exception e,Throwable cause)
	{
		ResponseDto<?> response = new ResponseDto<>(null,new ErrorDto(e.getMessage(),e.getCause()),"Exception Occured",false);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	

}
