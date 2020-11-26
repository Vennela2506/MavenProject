<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div style="text-align: center">
<h1>ONLINE INSURANCE QUOTE GENERATION</h1>
<h2>User Creation</h2>
<form action="" method="post">
    <label for="uname"><b>User Name</b></label>
    <input type="text" placeholder="Enter User Name" name="uname" maxlength="20" required><br><br>
<label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" maxlength="12" required><br><br>
        <label for="Role Code"><b>Select Role Code:</b></label>
<select name="role" id="role">
<option value="Select">Select</option>
  <option value="Insured">Insured</option>
  <option value="Agent">Agent</option>
  <option value="Underwriter">Underwriter</option>
</select><br><br>
    <button type="submit">Submit</button>
  </div>
</form>
</body>
</html>