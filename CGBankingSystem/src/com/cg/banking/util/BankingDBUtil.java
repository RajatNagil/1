package com.cg.banking.util;
import java.util.Random;
public class BankingDBUtil {
	BankingDBUtil bankingDBUtil=new BankingDBUtil();
	static private int n=9999-1000;
	static Random ran=new Random();
	public static long accountNumber = 100;
	public static int pinNumber=ran.nextInt(9999)%n;
	public static String accountStatus = "Active";
	public static int getPIN_NUMBER() {
		return ++pinNumber;
	}
	public static String getACCOUNT_STATUS() {
		return accountStatus;
	}
}