<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<link type="text/css" href="<c:url value='/resources/css/style.css' />" rel="stylesheet" />
</head>
<body>

<table>
<tr>
<th>Id</th>
<th>Date</th>
<th>Notes</th>
<th>CustomerId</th>
<th></th>
</tr>

<c:forEach var="order"  items="${allOrders}">

	<c:url value="formForUpdateOrder" var="UpdateOrderLink" >
		<c:param name="orderId" value="${order.orderId}"></c:param>
	</c:url>
	
	<c:url value="formForDeleteOrder" var="DeleteOrderLink" >
		<c:param name="orderId" value="${order.orderId}"> </c:param>
		</c:url> 
	
<tr>
<td><a href="${UpdateOrderLink}"> ${order.orderId} </a></td>
<td> <fmt:formatDate pattern="yyyy-MM-dd" value = "${order.orderDate}" /> </td>
<td> ${order.orderNotes}</td>
<td> ${order.customerId}</td>
<td> <a href="${DeleteOrderLink}">Delete Order</a>
</tr>

</c:forEach>

</table>