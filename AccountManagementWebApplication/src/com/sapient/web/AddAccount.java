package com.sapient.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.dao.AccountDAO;
import com.sapient.dao.AccountDAOImpl;
import com.sapient.model.Account;
import com.sapient.model.AccountTypeEnum;
import com.sapient.service.CertificateOfDeposit;
import com.sapient.service.MoneyMarket;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/addAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private AccountDAO service=new AccountDAOImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			System.out.println("Hi i'm adding account");
			Integer accountNo=Integer.parseInt(request.getParameter("accountNo"));
			String accountHolderName=request.getParameter("accountHolderName");
			String accountType = request.getParameter("accountType");
			Integer accountBalance = Integer.parseInt(request.getParameter("accountBalance"));
			Account newAccount;
			if(accountType.equals("Money")) {
				newAccount = new MoneyMarket();
			}else {
				newAccount = new CertificateOfDeposit();
			}
			newAccount.setAccountHolderID(accountNo);
			newAccount.setAccountHolderName(accountHolderName);
			newAccount.setAccountBalance(accountBalance);
			newAccount.setAccountType(accountType);
			newAccount.setCreateDate(LocalDate.now());
			service.addAccount(newAccount);
			out.print("Account Added Successfully");
		}catch(Exception e) {
			response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
