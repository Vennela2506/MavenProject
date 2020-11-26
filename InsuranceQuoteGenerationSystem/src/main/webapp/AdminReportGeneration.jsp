<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="com.insure.quote.dto.Accounts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><center>ONLINE INSURANCE QUOTE GENERATION</center></h1>
<h2>Report Generation</h2>
<div class= "Container">
<% Accounts accounts = (Accounts)request.getAttribute("account");
	   String busSegName = (String)request.getAttribute("busSegName");
	   List<String> questions = (List)request.getAttribute("questions");
	   List<String> selectedAnswers = (List)request.getAttribute("selectedAns");
	   Double premium = (Double)request.getAttribute("premium");
	   PrintWriter writer = response.getWriter();
	%>
	InsuredName : <%=accounts.getInsuredName() %><br>
	InsuredStreet : <%=accounts.getInsuredStreet() %><br>
	InsuredCity : <%=accounts.getInsuredCity() %><br>
	InsuredState : <%=accounts.getInsuredState() %><br>
	InsuredZip : <%=accounts.getInsuredZip() %><br>
	BusinessSegment : <%=busSegName %><br><br>
	Questions : <br>
	<c:forEach items="${questions}" var="question">
	    	<c:out value="${question.polQuesDesc}" /><br>
	</c:forEach><br>
	Selected Answers : <br>
	<%=selectedAnswers %>
		<c:forEach items="${selectedAnswers}" var="answer">
	<c:out value="${answer}"/><br>
	</c:forEach><br><br>
	
	    ProposedPremium : <%=premium %>
            <br><br><a href="AdminPage.jsp">Back</a>
    </div>
</body>
</html>