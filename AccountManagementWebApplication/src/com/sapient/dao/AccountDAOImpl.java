package com.sapient.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.sapient.model.Account;
import com.sapient.service.CertificateOfDeposit;
import com.sapient.service.MoneyMarket;
import com.sapient.dao.QueryMapper;
import java.sql.Date;
public class AccountDAOImpl implements AccountDAO {
	private Logger daoLogger =  Logger.getLogger(AccountDAOImpl.class);
	

	@Override
	public Integer addAccount(Account account) throws SQLException {
		Connection connection=null;
		try{
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/accountDB");
			connection=dataSource.getConnection();
			CallableStatement callableStatement = connection.prepareCall(QueryMapper.ADD_ACCOUNT);
			callableStatement.setInt(1, account.getAccountHolderID());
			callableStatement.setString(2, account.getAccountHolderName());
			callableStatement.setInt(3, account.getAccountBalance());
			callableStatement.setString(4, account.getAccountType());
			callableStatement.setDate(5, java.sql.Date.valueOf(account.getCreateDate()));
			return callableStatement.executeUpdate();
		}catch(SQLException e) {
			daoLogger.error(e.getMessage(),e);
			e.printStackTrace();
		}catch(Exception e) {
			daoLogger.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return null;
	}


	
	@Override
	public Account getAccountById(Integer accountNo) throws Exception {
		Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/accountDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.GET_ACCOUNT_BY_ID);
			preparedStatement.setInt(1, accountNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String accountType = resultSet.getString("accountType");
			System.out.println(accountType);
			Account account;
			if(accountType.equals("Money")) {
				account=new MoneyMarket();
			}else {
				account=new CertificateOfDeposit();
			}
			populateCustomer(account,resultSet);
			
			daoLogger.info("Retrieving account from database");
			return account;
		}catch(SQLException e) {
			daoLogger.error(e.getMessage());
			throw e;
		}catch(Exception e) {
			daoLogger.error(e.getMessage());
			throw e;
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}
	
	

	@Override
	public List<Account> getAllAccounts() throws SQLException {
		Connection connection=null;
		try{
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/accountDB");
			System.out.println("Retrieving all customers from databse1");
			connection=dataSource.getConnection();
			System.out.println("Retrieving all customers from databse2");
			Statement createStatement = connection.createStatement();
			ResultSet resultSet = createStatement.executeQuery(QueryMapper.GET_ALL_ACCOUNTS);
			System.out.println("Retrieving all customers from databse3");
			List<Account> accountList = new ArrayList<>();
			while(resultSet.next()) {
				Account account;
				String accountType = resultSet.getString("accountType");
				if(accountType.equals("Money")) {
					account=new MoneyMarket();
				}else {
					account=new CertificateOfDeposit();
				}
				populateCustomer(account,resultSet);
				accountList.add(account);
			}
			if(accountList.size()>0) {
				System.out.println("Retrieving all customers from databse");
				daoLogger.info("Retrieving all customers from databse");
				return accountList;
			}else {
				System.out.println("Customer table is empty");
				throw new Exception("Customer table is empty");
			}
		}catch(SQLException e) {
			daoLogger.error(e.getMessage(),e);
//			e.printStackTrace();
		}catch(Exception e) {
			daoLogger.error(e.getMessage(),e);
//			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void deleteAccount(Integer accountNo) throws SQLException {
		Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/accountDB");
			connection=dataSource.getConnection();
			CallableStatement preparedStatement=
					connection.prepareCall(QueryMapper.DELETE_ACCOUNT);
			preparedStatement.setInt(1, accountNo);
			preparedStatement.executeUpdate();
			
			daoLogger.info("Deleted account from database");
		}catch(SQLException e) {
			daoLogger.error(e.getMessage());
			throw e;
		}catch(Exception e) {
			daoLogger.error(e.getMessage());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}
	
	private void populateCustomer(Account account, ResultSet resultSet) throws SQLException {
		account.setAccountHolderID(resultSet.getInt("accountNo"));
		account.setAccountHolderName(resultSet.getString("accountHolderName"));
		account.setAccountBalance(resultSet.getInt("accountBalance"));
		account.setAccountType(resultSet.getString("accountType"));
		account.setCreateDate(resultSet.getDate("accountCreateDate").toLocalDate());
	}
}
