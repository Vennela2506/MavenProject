package com.insure.quote.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.insure.quote.dto.Accounts;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.service.InsuredService;
import com.insure.quote.service.InsuredServiceImpl;
@WebServlet("/Insured")
public class Insured extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InsuredService service = new InsuredServiceImpl();		
		int isCreated = 0;	
		boolean isAccountExists=false;
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		boolean isUserExists = false;		
		String userName = request.getParameter("userName");
		String insuredName = request.getParameter("insuredName");
		String insuredStreet = request.getParameter("insuredStreet");
		String insuredCity = request.getParameter("insuredCity");
		String insuredState = request.getParameter("insuredState");
		int insuredZip = Integer.parseInt(request.getParameter("insuredZip"));
		String busSegName = request.getParameter("busSegName");
		try {			
			String bussinessSegmentId = service.getLineOfBusinessIdByName(busSegName);
			Accounts account = new Accounts(insuredName, insuredStreet, insuredCity, insuredState, insuredZip, bussinessSegmentId,userName);
			isUserExists = service.isUserExists(userName);
			if(isUserExists) {
				isAccountExists=service.accountValidation(userName);
				if(isAccountExists==false) {
					isCreated = service.accountCreation(account);
				if (isCreated == 1) {
				System.out.println("Account Created Successfully!!");
				dispatcher = request.getRequestDispatcher("InsuredPage.jsp");
				dispatcher.forward(request, response);
			}
				}
			else {
				out.println("Account Already Exists");
			dispatcher = request.getRequestDispatcher("InsuredPage.jsp");
				dispatcher.include(request, response);
			}			
			}
			else {
				out.println("User does not exists! First register as user");
			dispatcher = request.getRequestDispatcher("InsuredPage.jsp");
				dispatcher.include(request, response);
			}
		}catch (IQGSException e) {
			System.out.println(e.getMessage());
		}
	}
}
