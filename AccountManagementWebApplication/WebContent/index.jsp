<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Management Web Application</title>
</head>
<body>
<h1>Actions</h1>

<table border="1">
 <tr><th colspan="2">Action on Accounts</th></tr>
 <tr>
 <td>Action NAME</td><td>Description</td></tr>
 <tr>
 <td><a href='AccountActionController?index=1'>Add New Account</a></td>
 <td>Used to add new account to database</td>
 </tr>
 <tr>
 <td><a href='AccountActionController?index=2'>Get Account Details</a></td>
 <td>Used to get specific account details</td>
 </tr>
 <tr>
 <td><a href='AccountActionController?index=3'>Get All Account Details</a></td>
 <td>Used to get information of all accounts</td>
 </tr>
 
 <tr>
 <td><a href='AccountActionController?index=4'>Delete Account</a></td>
 <td>Used to delete an account from database</td>
 </tr>
</table>

</body>
</html>