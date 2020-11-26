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
<div style="text-align: center">
<h1>ONLINE INSURANCE QUOTE GENERATION</h1>
</div>
<h2> ViewPolicy</h2>
	<table border="2">
	<tr>
		<th>Policy Number</th>
		<th>Policy Premium</th>
		<th>Account Number</th>
		</tr>
		<c:forEach  var="policy" items="${policies}">
			<tr>
				<td>${policy.policyNumber}</td>
				<td>${policy.policyPremium}</td>
				<td>${policy.accNumber }</td>
				<td><a href="AdminReportGeneration?accNumber=${policy.accNumber}&polNumber=${policy.policyNumber}">ViewPolicy</a>
			</tr>
		</c:forEach>
	</table>
	        <br><a href="AdminPage.jsp">Back</a>
</body>
</html>