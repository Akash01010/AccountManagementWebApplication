package com.sapient.service;

import java.time.LocalDate;

import com.sapient.model.Account;
import com.sapient.model.AccountTypeEnum;

public class CertificateOfDeposit extends Account implements Deposit{
	private AccountTypeEnum certificateOfDepositAccountType;
	
	public CertificateOfDeposit() {
		
	}
	public CertificateOfDeposit(int accountHolderID, String accountHolderName, int accountBalance) {
		super(accountHolderID, accountHolderName, accountBalance, "Certificate of Deposit", LocalDate.now());
		this.certificateOfDepositAccountType = certificateOfDepositAccountType;
	}
	
	@Override
	public void depositAmount(int amount) {
		this.setAccountBalance(this.getAccountBalance()+amount);
	}
	public AccountTypeEnum getCertificateOfDepositAccountType() {
		return certificateOfDepositAccountType;
	}
	public void setCertificateOfDepositAccountType(AccountTypeEnum certificateOfDepositAccountType) {
		this.certificateOfDepositAccountType = certificateOfDepositAccountType;
	}
	@Override
	public String toString() {
		return "CertificateOfDeposit [certificateOfDepositAccountType=" + certificateOfDepositAccountType + "]" + super.toString();
	}
	
}
