package com.Exceptions;
//custom exception class
public class TaskException extends Exception{
	
	public TaskException() {
		
	}
	
	public TaskException(String string) {
		super(string);
	}
}
