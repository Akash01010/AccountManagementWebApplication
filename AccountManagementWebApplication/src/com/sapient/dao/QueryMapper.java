package com.sapient.dao;

public class QueryMapper {
	public static final String GET_ACCOUNT_BY_ID = "select * from account where accountNo=?";
	public static final String GET_ALL_ACCOUNTS = "select * from account";
	public static final String ADD_ACCOUNT="insert into account(accountNo, accountHolderName, accountBalance, accountType, accountCreateDate) values(?,?,?,?,?)";
	public static final String DELETE_ACCOUNT="delete from account where accountNo=?";
}
