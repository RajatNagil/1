package com.cg.banking.exceptions;
public class AccountBlockedException extends Exception {
	public AccountBlockedException (String string) {
		System.out.println("Account is Blocked");
	}
}
