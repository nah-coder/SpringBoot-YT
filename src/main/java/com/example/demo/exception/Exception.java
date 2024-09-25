package com.example.demo.exception;

import com.example.demo.DTO.Request.ApiReponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exception {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiReponse> handling(RuntimeException exception){
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiReponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiReponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiReponse> handlingException(AppException exception){
        ErrorCode errorCode = exception.getErrorCode();
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setCode(errorCode.getCode());
        apiReponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiReponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiReponse> handlingCharater(MethodArgumentNotValidException exception){
        String enumkey = exception.getFieldErrors().get(0).getDefaultMessage();
        ErrorCode errorCode = ErrorCode.valueOf(enumkey);
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setCode(errorCode.getCode());
        apiReponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiReponse);
    }
}
