package com.info.userbean;

public class InvalidAgeException extends Exception{
final String msg="Invalid user Age";

@Override
public String toString() {
	return "InvalidAgeException [" + msg + "]";
}
}
