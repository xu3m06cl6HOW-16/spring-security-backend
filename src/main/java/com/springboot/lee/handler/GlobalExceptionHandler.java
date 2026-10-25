package com.springboot.lee.handler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.lee.domain.ResponseResult;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult<String> handleValidationException(
            MethodArgumentNotValidException e) {

        String message = e.getBindingResult()
                          .getFieldError()
                          .getDefaultMessage();

        return new ResponseResult<>(400, message, (String)null);
    }
}