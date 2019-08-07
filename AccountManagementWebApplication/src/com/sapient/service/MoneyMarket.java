package com.sapient.service;

import java.time.LocalDate;

import com.sapient.exception.InsufficientBalanceException;
import com.sapient.exception.WithdrawlLimitException;
import com.sapient.model.Account;
import com.sapient.model.AccountTypeEnum;

public class MoneyMarket extends Account implements Deposit, Withdraw, Transfer {
	private AccountTypeEnum moneyMarketAccountType;
	
	public MoneyMarket() {
		
	}
	public MoneyMarket(int accountHolderID, String accountHolderName, int accountBalance, AccountTypeEnum moneyMarketAccountType) {
		super(accountHolderID, accountHolderName, accountBalance, "Money Market",LocalDate.now());
		this.moneyMarketAccountType = moneyMarketAccountType;
	}
	@Override
	public void withdrawAmount(int amount) throws InsufficientBalanceException, WithdrawlLimitException {
		if(this.getAccountBalance()<amount) {
			throw new InsufficientBalanceException("Insufficient Balance in Account");
		}
		if(this.moneyMarketAccountType==AccountTypeEnum.CONSUMER && amount > 100000) {
			 throw new WithdrawlLimitException("You can withdraw money less or equal to 100000 in consumer accounts.");
		}else {
			this.setAccountBalance(this.getAccountBalance()-amount);
			if(this.getAccountBalance() < 10000) {
				System.out.println("You have low account balance.");
			}
		}
	}
	@Override
	public void depositAmount(int amount) {
		this.setAccountBalance(this.getAccountBalance()+amount);
	}
	@Override
	public void transferAmount(Account account, int amount) throws InsufficientBalanceException {
		if(this.getAccountBalance()<amount) {
			throw new InsufficientBalanceException("Insufficient Balance in Account");
		}
		this.setAccountBalance(this.getAccountBalance()-amount);
		if(account.getAccountType()=="Money Market") {
			MoneyMarket moneyMarketAccount=(MoneyMarket)account;
			moneyMarketAccount.setAccountBalance(moneyMarketAccount.getAccountBalance()+amount);
		}else if(account.getAccountType()=="Certificate of Deposit") {
			CertificateOfDeposit cdAccount=(CertificateOfDeposit)account;
			cdAccount.setAccountBalance(cdAccount.getAccountBalance()+amount);
		}
	}
	@Override
	public String toString() {
		return "MoneyMarket [moneyMarketAccountType=" + moneyMarketAccountType + "]" + super.toString();
	}
	
	
}
