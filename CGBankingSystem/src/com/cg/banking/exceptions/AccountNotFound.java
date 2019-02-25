package com.cg.banking.exceptions;
public class AccountNotFound extends Exception{
	public AccountNotFound (String string) {
		System.out.println("Account Not Found");
	}
}
