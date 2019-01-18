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
<table>

<tr>
<th><input type="button" onclick="window.location.href='http://localhost:8080/EshopApp/api/allCustomers'" value="RestApi AllCustomers" style="color: #000000"></th>
<th><input type="button" onclick="window.location.href='http://localhost:8080/EshopApp/api/getCustomer?customerId=11'" value="RestApi getCustomer?customerId=11" style="width: 350px; "></th>
<th><input type="button" onclick="window.location.href='http://localhost:8080/EshopApp/api/getCustomerOrders?customerId=11'" value="RestApi getCustomersOrder?customerId=11" style="width: 350px; "></th>
</tr>
<tr>
<th><input type="button" onclick="window.location.href='http://localhost:8080/EshopApp/allCustomers'" value="MVC all Customer Report" ></th>
</tr>
</table>

<table>
<form method="get" action="api/getCustomerOrders">

    	<h3>Get List of Customer orders</h3>
    	<tr>
            <td><label for="customerId" >Customer ID : </label></td>
            <td><input type="text" id="customerId" name="customerId"/><br/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>

</form>


</body>
</html>