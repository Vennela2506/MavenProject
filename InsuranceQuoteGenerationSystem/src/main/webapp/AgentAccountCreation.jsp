<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1><center>ONLINE INSURANCE QUOTE GENERATION</center></h1>
	<h2>Account Creation</h2>
	<form action = "AgentAccountCreation" method = "post">
		<p>User Name</p>
		<input type = "text" name = "userName" placeholder = "Enter User name" required>
		<p>Insured Name</p>
		<input type = "text" name = "insuredName" placeholder = "Enter Insured name" required>
		<p>Insured Street</p>
		<input type = "text" name = "insuredStreet" placeholder = "Enter Insured Street" required>
		<p>Insured City</p>
		<input type = "text" name = "insuredCity" placeholder = "Enter Insured City"  required>
		<p>Insured State</p>
		<input type = "text" name = "insuredState" placeholder = "Enter Insured State" required>
		<p>Insured zip</p>
		<input type = "text" name = "insuredZip"  placeholder = "Enter Insured Zip" required>
		<p>Business Segment</p>
		<select name = "busSegName">
			<option value = "Business Auto">Business Auto</option>
			<option value = "Restaurant">Restaurant</option>
			<option value = "Apartment">Apartment</option>
			<option value = "General Merchant">General Merchant</option>
		</select>
		<br><br><input type = "submit" name = "submit" value = "Create Account">
	</form>
    
</body>
</html>