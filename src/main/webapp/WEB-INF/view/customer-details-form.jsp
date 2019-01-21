<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
	<th> CustomerId </th>
	<th> First Name </th>
	<th> Last Name </th>
	<th> Email </th>
	<th> Customer_card </th>
	<th></th>
	<th></th>
	</tr>
	<tr>
	<td> ${customer.id } </td>
	<td> ${customer.firstName } </td>
	<td> ${customer.lastName } </td>
	<td> ${customer.email } </td>
	<td> ${customer.customerCard.getCardNumber() } </td>
	</tr>
</table>

	<table>
	<tr>
	<th> Order Id </th>
	<th>   Order Date   </th>
	<th>        Order Notes         </th>
	<th></th>
	<th></th>
	</tr>
	<c:forEach var="orders" items="${listCustomerOrders}">
	<tr>
	<td> ${orders.getOrderId() } </td>
	<td> ${orders.getOrderDate() } </td>
<td> ${orders.getOrderNotes()} </td>
			<c:forEach var="products" items="${orders.getOrderProducts()}" >
			<tr>
			<th> Product Name </th>
			<th> Quantity </th>
			</tr>
			<tr>
			<td>
		${products.getProduct().getProductName()}
			</td>
			<td>
			${products.getQuantity()}
			</td>
			</tr>
			
			</c:forEach>
	
	</tr>
	
	</c:forEach>
	</table>