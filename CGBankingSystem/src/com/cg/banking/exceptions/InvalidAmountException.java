package com.cg.banking.exceptions;

public class InvalidAmountException extends Exception {
	public InvalidAmountException(String string) {
		System.out.println("**Invalid Amount**");
	}
}
