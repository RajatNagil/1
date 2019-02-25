package com.cg.banking.exceptions;

public class BankingServicesDownException extends Exception {
	public BankingServicesDownException(String string) {
		System.out.println("**Banking Services Down**");
	}
}
