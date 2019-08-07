package com.sapient.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.dao.AccountDAO;
import com.sapient.dao.AccountDAOImpl;
import com.sapient.model.Account;
import com.sapient.service.CertificateOfDeposit;
import com.sapient.service.MoneyMarket;

/**
 * Servlet implementation class getAccount
 */
@WebServlet("/getAccount")
public class GetAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AccountDAO service=new AccountDAOImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			System.out.println("Hi i'm getting an account");
			Integer accountNo=Integer.parseInt(request.getParameter("accountNo"));
			Account account = service.getAccountById(accountNo);
			out.print("Account retrieved Successfully\n");
			out.print(account.toString());
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
