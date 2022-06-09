package com.mcnc.practice.demo.Exception;



public class ErrorResponse {
    private String message; 

    private String code;

    private int status;

    public ErrorResponse() {
    }
    
    private ErrorResponse(final ErrorCode errorCode) {
    	this.code = errorCode.getCode();
		this.status = errorCode.getStatus();
		this.message = errorCode.getMessage();
	}
	
	public static ErrorResponse of(final ErrorCode errorCode) {
		return new ErrorResponse(errorCode);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    
    
}
