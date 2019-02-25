package com.cg.banking.exceptions;

public class InvalidAccountTypeException extends Exception {
	public InvalidAccountTypeException(String string) {
		System.out.println("**Invalid Account Type**");
	}
}
