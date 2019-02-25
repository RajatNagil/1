package com.cg.banking.exceptions;

public class InsufficientAmountException extends Exception{
	public InsufficientAmountException (String string) {
		System.out.println("**Insufficient Funds In Account**");
	}
}
