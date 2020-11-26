package com.insure.quote.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.insure.quote.dto.Policy;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.service.InsuredService;
import com.insure.quote.service.InsuredServiceImpl;
@WebServlet("/InsuredViewPolicy")
public class InsuredViewPolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String user =request.getParameter("uname");
			ServletContext context = request.getServletContext();
			context.setAttribute("uname",user);
			PrintWriter out = response.getWriter();
			RequestDispatcher dispatcher = null;
			InsuredService service = new InsuredServiceImpl();
			try {
			int accNo = service.getAccountNumber(user);
			List<Policy> policies = service.getInsuredPolicies(accNo);
			System.out.println("policies size : "+policies.size());
			if(policies.size() > 0) {
				request.setAttribute("policies", policies);			
				dispatcher = request.getRequestDispatcher("InsuredViewPolicy.jsp");
				dispatcher.include(request, response);		
			}			
			else {
				out.println("Policies does not exists.. ");
				dispatcher = request.getRequestDispatcher("InsuredPage.jsp");
				dispatcher.include(request, response);							
			}
		}catch (IQGSException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	}

