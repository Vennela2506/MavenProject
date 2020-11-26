package com.insure.quote.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.service.AdminService;
import com.insure.quote.service.AdminServiceImpl;
@WebServlet("/AdminPolicyCreation")
public class AdminPolicyCreation extends HttpServlet { 
	int noOfQuestions;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accNumber = Integer.parseInt(request.getParameter("accNumber"));
		ServletContext context = request.getServletContext();
		context.setAttribute("accNumber", accNumber);
		PrintWriter out = response.getWriter();
		AdminService service = new AdminServiceImpl();
		RequestDispatcher dispatcher = null;
		try {
			String busSegId = service.getBusSegId(accNumber);
			List<PolicyQuestions> policies=service.getPolicyQuestions(busSegId);
			noOfQuestions=policies.size();
			request.setAttribute("questions",policies);
			dispatcher = request.getRequestDispatcher("AdminPremiumGeneration.jsp");
			dispatcher.forward(request, response);
		} catch (IQGSException e) {
			System.out.println(e.getMessage());
		}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
