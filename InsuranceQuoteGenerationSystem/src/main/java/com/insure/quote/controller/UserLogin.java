package com.insure.quote.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.insure.quote.dao.UserDaoImpl;
import com.insure.quote.dao.Userdao;
import com.insure.quote.dto.UserRole;
import com.insure.quote.service.UserService;
import com.insure.quote.service.UserServiceImpl;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("uname");
		String pass=request.getParameter("psw");
		UserService userdao=new UserServiceImpl();
		try {
			UserRole user=userdao.userLogin(userId,pass);
			String dest="UserLogin.jsp";
			if(user!=null)
			{
				if(user.getRoleCode().equals("Admin")) {
				HttpSession session=request.getSession();
				   session.setAttribute("user", user);
	                dest = "AdminPage.jsp";
				}
				else if(user.getRoleCode().equals("Agent"))
				{
					HttpSession session=request.getSession();
					   session.setAttribute("user", user);
		                dest = "AgentPage.jsp";
				}
				else if(user.getRoleCode().equals("Insured")) {
					HttpSession session=request.getSession();
					   session.setAttribute("user", user);
		                dest = "InsuredPage.jsp";
				}
	            } 
			else {
	                String message = "Invalid UserId/password";
	                request.setAttribute("message", message);
	            }
	            RequestDispatcher dispatcher = request.getRequestDispatcher(dest);
	            dispatcher.forward(request, response);
	            } catch (SQLException ex) {
	            throw new ServletException(ex.getMessage());
	        }
			}
}


