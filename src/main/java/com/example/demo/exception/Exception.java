package com.example.demo.exception;

import com.example.demo.DTO.Request.ApiReponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exception {
    //khi khng biết lỗi là gì
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiReponse> handling(RuntimeException exception){
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiReponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiReponse);
    }
// khi ã biêt lỗi và đã tạo exception cho nó
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiReponse> handlingException(AppException exception){
        ErrorCode errorCode = exception.getErrorCode();
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setCode(errorCode.getCode());
        apiReponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiReponse);
    }
    //lỗi mặc định trong thư viện như size
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
