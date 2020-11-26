package com.insure.quote.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.service.AdminService;
import com.insure.quote.service.AdminServiceImpl;

/**
 * Servlet implementation class AdminReportGeneration
 */
@WebServlet("/AdminReportGeneration")
public class AdminReportGeneration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		int accNumber = Integer.parseInt(request.getParameter("accNumber"));
		String busSegName = null;
		Double premium = 0.0;
		List<PolicyQuestions> questions = new ArrayList<PolicyQuestions>();
		List<String> selectedAns = new ArrayList<String>();
		int polNum = Integer.parseInt(request.getParameter("polNumber"));
		AdminService service = new AdminServiceImpl();
		Accounts account = new Accounts();		
		try {
			account = service.getAccountDetails(accNumber);
			busSegName = service.getBusSegName(account.getLineOfBusiness());
			premium = service.getPolicyPremium(polNum);
			questions = service.getPolicyQuestions(account.getLineOfBusiness());
			selectedAns = service.getSelectedAnswers(polNum);
			request.setAttribute("account", account);
			request.setAttribute("busSegName", busSegName);
			request.setAttribute("questions", questions);
			request.setAttribute("selectedAns", selectedAns);
			request.setAttribute("premium", premium);
			dispatcher = request.getRequestDispatcher("AdminReportGeneration.jsp");
			dispatcher.forward(request, response);			
		} catch (IQGSException e) {
			System.out.println(e.getMessage());
		}		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
