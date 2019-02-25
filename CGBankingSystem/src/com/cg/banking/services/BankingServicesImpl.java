package com.cg.banking.services;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAOImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFound;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.util.BankingDBUtil;
public class BankingServicesImpl implements  BankingServices{
	AccountDAOImpl service = new AccountDAOImpl();
	Transaction transaction = new Transaction();
	Account account;
	@Override
	public Account openAccount(String accountType, float initBalance)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		Account account = new Account(accountType,initBalance);
		account = service.save(account);
		return account; 
	}
	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		return service.findAll();
	}
	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFound, BankingServicesDownException {
		 account=service.findOne(accountNo);
		 if(account==null)
			 throw new AccountNotFound("");
		return account;
	}
	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFound, BankingServicesDownException, AccountBlockedException {
			Account account=service.findOne(accountNo);
			float accountBalance = account.getAccountBalance()+amount;
			account.setAccountBalance(accountBalance);
		return accountBalance;
	}
	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFound, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account account = service.findOne(accountNo);
		if(pinNumber==account.getPinNumber())
			{account=service.findOne(accountNo);
			float finalAmount = account.getAccountBalance()-amount;
			account.setAccountBalance(finalAmount);
			return finalAmount;
			}
		else 
			throw new InvalidPinNumberException("");
	}
	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFound, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		withdrawAmount(accountNoFrom, transferAmount, pinNumber);
		depositAmount(accountNoTo, transferAmount);
		return true;
	}
	@Override

	public boolean checkPin(long accountNo, int pinNumber) throws InvalidPinNumberException,AccountBlockedException{
		throw new InvalidPinNumberException("");
	}
	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFound {
		return null;
	}
	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFound, AccountBlockedException {
		return null;
	}
}