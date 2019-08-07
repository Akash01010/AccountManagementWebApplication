package com.sapient.service;

import com.sapient.exception.InsufficientBalanceException;
import com.sapient.model.Account;

public interface Transfer {
	public abstract void transferAmount(Account account, int amount) throws InsufficientBalanceException;
}
