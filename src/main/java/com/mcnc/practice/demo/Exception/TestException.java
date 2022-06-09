package com.mcnc.practice.demo.Exception;

public class TestException extends CustomException{

	private static final long serialVersionUID = 1L;

	public TestException() { 
		super(ErrorCode.TEST_EXCEPTION);
	}

}
