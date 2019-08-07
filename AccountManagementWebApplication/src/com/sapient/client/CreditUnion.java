package com.sapient.client;

import java.util.Arrays;

import com.sapient.model.Account;

public class CreditUnion {
	private String name;
	private String address;
	private Account[] accounts;
	
	public CreditUnion() {
		
	}
	
	public CreditUnion(String name, String address, Account[] allAccounts) {
		super();
		this.name = name;
		this.address = address;
		this.accounts = allAccounts;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getName() {
		return name;
	}
	public void setCreditUnionName(String name) {
		this.name = name;
	}
	//Since account has no meaning without bank
	/*public Account[] getAllAccounts() {
		return allAccounts;
	}*/
	public void setAccounts(Account[] allAccounts) {
		this.accounts = allAccounts;
	}
	public void addAccount(Account newAccount) {
		
	}

	@Override
	public String toString() {
		return "CreditUnion [name=" + name + ", address=" + address + ", accounts=" + Arrays.toString(accounts) + "]";
	}

	
}
