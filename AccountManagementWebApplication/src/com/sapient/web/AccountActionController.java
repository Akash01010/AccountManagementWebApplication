package com.sapient.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
//import com.sapient.model.Account;

@WebServlet("/AccountActionController")
public class AccountActionController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer index=
				Integer.parseInt(request.getParameter("index"));
		String url="";
//		ServletContext context=request.getServletContext();
//		context.setAttribute("company", "Sapient");
//		List<Customer> customerList= new ArrayList<>();
//		populateCustomerList(customerList);
//		request.setAttribute("customerList", customerList);		
		if(index==1) {			
			url="core/addAccount.jsp";
		}else if(index==2) {
			url="core/getAccount.jsp";
		}else if(index==3) {
			url="core/getAllAccount.jsp";
		}else if(index==4) {
			url="core/deleteAccount.jsp";
		}
		request.getRequestDispatcher(url).
		forward(request, response);
	}

//	
//	private void populateCustomerList(List<Customer> customerList) {
//		customerList.add(new Customer(100,"Smith","smith@gmail.com",9878987898L));
//		customerList.add(new Customer(101,"Clarke","clarke@gmail.com",7878987890L));
//		customerList.add(new Customer(102,"Jones","jones@gmail.com",8898987890L));
//		customerList.add(new Customer(103,"King","king@gmail.com",6078987898L));
//		
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
