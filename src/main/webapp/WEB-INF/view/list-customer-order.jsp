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

<table>
<tr>
<th> OrderId </th>
<th> CustomerId </th>
<th> Order Date </th>
<th> Notes </th>
</tr>
<c:forEach var="order" items="${ordersOfCustomer}">

	<c:url value="formForUpdateOrder" var="UpdateOrderLink" >
		<c:param name="orderId" value="${order.orderId}"></c:param>
	</c:url>
	
<tr>
<td><a href="${UpdateOrderLink}"> ${order.orderId} </td>
<td> ${order.customerId} </td>
<td> ${order.orderDate} </td>
<td> ${order.orderNotes} </td>
</c:forEach>
</table>