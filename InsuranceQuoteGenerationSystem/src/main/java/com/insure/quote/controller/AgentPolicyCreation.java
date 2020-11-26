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
import com.insure.quote.service.AgentService;
import com.insure.quote.service.AgentServiceImpl;
/**
 * Servlet implementation class AgentPolicyCreation
 */
@WebServlet("/AgentPolicyCreation")
public class AgentPolicyCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accNumber = Integer.parseInt(request.getParameter("accNumber"));
		ServletContext context = request.getServletContext();
		context.setAttribute("accNumber", accNumber);
		PrintWriter out = response.getWriter();	    
		AgentService service = new AgentServiceImpl();
		RequestDispatcher dispatcher = null;
		try {
			String busSegId = service.getBusSegId(accNumber);
			context.setAttribute("busSegId", busSegId);
			List<PolicyQuestions> policies=service.getPolicyQuestions(busSegId);
			dispatcher = request.getRequestDispatcher("AgentPolicyQuestions.jsp");
			request.setAttribute("questions",policies);
			dispatcher.forward(request, response);
		} catch (IQGSException e) {
			System.out.println(e.getMessage());
		}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}