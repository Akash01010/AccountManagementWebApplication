package com.sapient.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.dao.AccountDAO;
import com.sapient.dao.AccountDAOImpl;
import com.sapient.model.Account;

/**
 * Servlet implementation class GetAllAccounts
 */
@WebServlet("/getAllAccounts")
public class GetAllAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO service=new AccountDAOImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			System.out.println("Hi i'm getting all accounts");
			List<Account> accounts = service.getAllAccounts();
			out.print("Accounts retrieved Successfully\n");
			for(int i=0;i<accounts.size();i++) {
				out.print(accounts.get(i).toString());
			}
//			accounts.forEach((Account account)->{out.print(account.toString()+"\n");});
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
