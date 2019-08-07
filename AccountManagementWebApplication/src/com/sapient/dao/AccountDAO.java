package com.sapient.dao;

import java.sql.SQLException;
import java.util.List;

import com.sapient.model.Account;

public interface AccountDAO {
	
	//crud
	public abstract Account getAccountById(Integer accountNo) throws SQLException, Exception;
	public abstract List<Account> getAllAccounts() throws SQLException;
	public abstract Integer addAccount(Account account) throws SQLException;
	public abstract void deleteAccount(Integer accountNo) throws SQLException;
}
