package com.example.demo.exception;

public enum ErrorCode {
    USER_EXISTED(1001,"USER_EXISTED"),
    UNCATEGORIZED_EXCEPTION(9999,"uncategorized_exception"),
    USERNAME_VALID(1002,"username_valid must be 8 character"),
    PASSWORD_VALID(1003,"password_valid must be 8 character"),
    USER_NOT_EXISTED(1004,"USER_NOT_EXISTED"),
    UNAUTHENTICATED(1005,"UNAUTHENTICATED"),

    ;
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
