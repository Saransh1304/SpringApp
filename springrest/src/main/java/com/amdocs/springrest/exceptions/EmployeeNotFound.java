package com.amdocs.springrest.exceptions;

public class EmployeeNotFound extends RuntimeException{
	
	public EmployeeNotFound(String message)
	{
		super(message);
	}
	
}