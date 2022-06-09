package com.mcnc.practice.demo.Exception;

public enum ErrorCode {
	
	TEST_EXCEPTION(400, "TEST", "testError"),
	TEST_EXCEPTION2(400, "TEST2", "testError2");
	
    private final String code;
    private final String message;
    private final int status;

    public String getCode() {
        return code;
    }

    String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
