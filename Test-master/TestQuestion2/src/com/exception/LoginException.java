package com.exception;

public class LoginException extends Exception{

	@Override
	public String toString() {
		
		String message ="Username or password does not exists";
		return "UserException [Exception is: "  + message +"]";
	}
}
