<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
</head>
<body>


<h2> Main page of EshopApp : </h2>

<input type="button" onclick="window.location.href='http://localhost:8080/EshopApp/api/allCustomers'" value="RestApi AllCustomers" style="color: #000000">
<p>
<input type="button" onclick="window.location.href='http://localhost:8080/EshopApp/api/getCustomer?customerId=11'" value="RestApi getCustomer?customerId=11" style="width: 350px; ">
<p>
<input type="button" onclick="window.location.href='http://localhost:8080/EshopApp/api/getCustomerOrders?customerId=11'" value="RestApi getCustomersOrder?customerId=11" style="width: 350px; ">
<p>


</body>
</html>