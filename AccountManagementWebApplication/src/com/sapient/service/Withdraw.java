package com.sapient.service;

import com.sapient.exception.InsufficientBalanceException;
import com.sapient.exception.WithdrawlLimitException;

public interface Withdraw {
	
	public abstract void withdrawAmount(int amount) throws InsufficientBalanceException, WithdrawlLimitException;
}
