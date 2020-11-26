<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "accountbox">
<h1><center>ONLINE INSURANCE QUOTE GENERATION</center></h1>
	<h2>Account Creation</h2>
	<form action = "AdminAccountCreation" method = "post">
		<p>User Name</p>
		<input type = "text" name = "userName" placeholder = "Enter User name" required>
		<p>Insured Name</p>
		<input type = "text" name = "insuredName" placeholder = "Enter Insured name" required>
		<p>Insured Street</p>
		<input type = "text" name = "insuredStreet" placeholder = "Enter Insured street"  required>
		<p>Insured City</p>
		<input type = "text" name = "insuredCity" placeholder = "Enter Insured city" required>
		<p>Insured State</p>
		<input type = "text" name = "insuredState" placeholder = "Enter Insured state" required>
		<p>Insured zip</p>
		<input type = "text" name = "insuredZip" placeholder = "Enter Insured zip" required><br>
		<p>Business Segment</p>
		<select name = "busSegName">
			<option value = "Business Auto">Business Auto</option>
			<option value = "Restaurant">Restaurant</option>
			<option value = "Apartment">Apartment</option>
			<option value = "General Merchant">General Merchant</option>
		</select><br><br>
		<input type = "submit" name = "submit" value = "Create Account">
	</form>


</body>
</html>