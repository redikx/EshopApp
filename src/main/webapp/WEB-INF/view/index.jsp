<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<link type="text/css" href="<c:url value='/resources/css/style.css' />" rel="stylesheet" />
</head>
<body>

<h2> Api Links : </h2>

<a  href="${pageContext.request.contextPath}/api/allCustomers"> All Customers Api</a><p>
<a  href="${pageContext.request.contextPath}/api/getCustomer?customerId=11"> Customer 11 details</a><p>
<a  href="${pageContext.request.contextPath}/api/getCustomerOrders?customerId=11"> Orders o	f Customer 11</a>


<form method="get" action="api/getCustomerOrders">
            <label for="customerId" >Orders of Customer ID : </label>
            <input type="text" id="customerId" name="customerId"/>
            <input type="submit" value="Submit">
       
        </form>
    



<h2> Web Interfaces : </h2>
<p></p>
<table style="background-color: Gray; color: Gray">
<tr>
<th style="color: Gray; "><input type="button" onclick="window.location.href='${pageContext.request.contextPath}/allCustomers'" value="Customer List" ></th>
</tr>
<tr>
<th><input type="button" onclick="window.location.href='${pageContext.request.contextPath}/allOrders'" value="Orders List" > </th>
</tr>
<tr>
<th><input type="button" onclick="window.location.href='${pageContext.request.contextPath}/newCustomer'" value="New Customer" > </th>
</tr>
<tr>
<th><input type="button" onclick="window.location.href='${pageContext.request.contextPath}/newOrder'" value="New Order" > </th>

</tr>


</table>



<form method="get" action="getCustomerOrders">
    	
            <label for="customerId" >Orders of Customer ID : </label>
           <input type="text" id="customerId" name="customerId"/><br/>
           
            <input type="submit" value="Submit">
        
    
    
</form>

</body>
</html>