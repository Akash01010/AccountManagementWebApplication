package com.sapient.model;

import java.time.LocalDate;

public abstract class Account {
	private int accountNo;
	private String accountHolderName;
	private int accountBalance;
	private String accountType;
	private LocalDate createDate;
	
	public Account() {
		
	}
	public Account(int accountHolderID, String accountHolderName, int accountBalance, String accountType, LocalDate date) {
		super();
		this.accountNo = accountHolderID;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
		this.createDate = date;
	}
	public int getAccountHolderID() {
		return accountNo;
	}
	public void setAccountHolderID(int accountHolderID) {
		this.accountNo = accountHolderID;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountHolderName=" + accountHolderName + ", accountBalance="
				+ accountBalance + ", accountType=" + accountType + ", createDate=" + createDate + "]";
	}
	
}
