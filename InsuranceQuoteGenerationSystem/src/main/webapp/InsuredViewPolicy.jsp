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
			</tr>
		</c:forEach>
	</table>
	</div>
	</form>
                   <br><a href="InsuredPage.jsp">Back</a>
       </body>
</html>