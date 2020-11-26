package com.insure.quote.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insure.quote.dto.UserRole;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.service.AdminService;
import com.insure.quote.service.AdminServiceImpl;

/**
 * Servlet implementation class ProfileCreation
 */
@WebServlet("/ProfileCreation")
public class ProfileCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int isInserted = 0;
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		AdminService service = new AdminServiceImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rolecode = request.getParameter("rolecode");
		UserRole userRole = new UserRole(username, password, rolecode);
		try {
			isInserted = service.addUser(userRole);
			if (isInserted > 0) {
				out.println("User Role created successfully!!!!");
				dispatcher = request.getRequestDispatcher("AdminPage.jsp");
				dispatcher.include(request, response);
		} else {
				out.println("Username already exists!! Enter a different Username");
				dispatcher = request.getRequestDispatcher("profilecreation.jsp");
				dispatcher.include(request, response);
			}
		} catch (IQGSException e) {
			e.printStackTrace();
		}
	}
}
