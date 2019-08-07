<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- <base href="${pageContext.request.contextPath}"> --%>
<!-- <link rel="stylesheet" type="text/css" href="./css/style1.css"> -->
<link href="${pageContext.request.contextPath}/css/style1.css" rel="stylesheet" > 

</head>
<body>

<h2>Delete Account</h2>
<div class="bg-img">
  <form action="http://localhost:9090/AccountManagementWebApplication/deleteAccount" method="get" class="container">
    <h1>Account</h1>
	<label for="accountNo"><b>Account Number</b></label>
    <input type="text" placeholder="Enter Account Number" name="accountNo" required>
  <!--   
    <label for="accountHolderName"><b>Account Holder Name</b></label>
    <input type="text" placeholder="Enter Account Holder Name" name="accountHolderName" required>
    
    <label for="accountType"><b>Account Type</b></label>
    <input type="text" placeholder="Enter Account Type" name="accountType" required>
    
    <label for="balance"><b>Balance</b></label>
    <input type="text" placeholder="Enter Account Balance" name="accountBalance" required>     -->

    <button type="submit" class="btn">Delete Account</button>
  </form>
 </div>
 <!-- <div align="center">
 	<h3><font color="cyan">New User? <a href="views/user_registration.html">SignUp</a></font></h3>
 </div> -->
</body>
</html>
