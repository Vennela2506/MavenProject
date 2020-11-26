package com.insure.quote.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insure.quote.dto.Policy;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.service.AdminService;
import com.insure.quote.service.AdminServiceImpl;

/**
 * Servlet implementation class AdminViewPolicies
 */
@WebServlet("/AdminViewPolicies")
public class AdminViewPolicies extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService service = new AdminServiceImpl();
		RequestDispatcher dispatcher = null;
		try {
			List<Policy> policy = service.getPolicies();
			request.setAttribute("policies", policy);
			dispatcher = request.getRequestDispatcher("ReportGeneration.jsp");
			dispatcher.include(request, response);
		} catch (IQGSException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
