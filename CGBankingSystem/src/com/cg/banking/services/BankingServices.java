package com.cg.banking.services;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFound;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
public interface BankingServices {
Account openAccount(String accountType,float initBalance) 
		throws InvalidAmountException,InvalidAccountTypeException, BankingServicesDownException;

float depositAmount(long accountNo,float amount) 
		throws AccountNotFound,BankingServicesDownException,AccountBlockedException;

float withdrawAmount(long accountNo,float amount,int pinNumber)
		throws InsufficientAmountException,AccountNotFound,InvalidPinNumberException,
		BankingServicesDownException,AccountBlockedException;

boolean fundTransfer(long accountNoTo,long accountNoFrom,float transferAmount,int pinNumber)
		throws InsufficientAmountException,AccountNotFound,InvalidPinNumberException,
		BankingServicesDownException,AccountBlockedException;

boolean checkPin(long accountNo,int pinNumber)
        throws InvalidPinNumberException, AccountBlockedException;

Account getAccountDetails(long accountNo)
		throws AccountNotFound,BankingServicesDownException;

List<Account> getAllAccountDetails()
		throws BankingServicesDownException;

List<Transaction> getAccountAllTransaction(long accountNo)
		throws BankingServicesDownException,AccountNotFound;

public String accountStatus(long accountNo)
		throws BankingServicesDownException,AccountNotFound,AccountBlockedException;
}