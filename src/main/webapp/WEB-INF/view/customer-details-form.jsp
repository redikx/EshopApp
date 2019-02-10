<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<link type="text/css" href="<c:url value='/resources/css/style_details.css' />" rel="stylesheet" />
</head>
<body>

<table style='border-bottom-color: White; text-decoration: blink; font-family: "Trebuchet MS", Sans-Serif; color: Crimson'>
	<tr>
	<th> CustomerId </th>
	<th> First Name </th>
	<th> Last Name </th>
	<th> Email </th>
	<th> Customer_card </th>
	<th></th>
	<th></th>
	</tr>
	<tr style="font-style: oblique">
	<td> ${customer.id } </td>
	<td> ${customer.firstName } </td>
	<td> ${customer.lastName } </td>
	<td> ${customer.email } </td>
	<td> ${customer.customerCard.getCardNumber() } </td>
	</tr>
</table>
<p></p>


	
	
	<c:forEach var="orders" items="${listCustomerOrders}">
	<table class="table_det">
	<tr>
	<th> Order Id </th>
	<th>   Order Date   </th>
	<th>        Order Notes         </th>
	<th></th>
	<th></th>
	</tr>
	<tr>
	<td> ${orders.getOrderId() } </td>
	<td> ${orders.getOrderDate() } </td>
<td> ${orders.getOrderNotes()} </td>
			<tr class="order_product_lists">
			<td> Product Name </td>
			<td> Quantity </td>
			</tr>
			
			<c:forEach var="products" items="${orders.getOrderProducts()}" >
			<tr>
			<td>
		${products.getProduct().getProductName()}
			</td>
			<td>
			${products.getQuantity()}
			</td>
			</tr>
			</c:forEach>
		<tr class="blank_row">
    	<td colspan="3"></td>
		</tr>
			</table>
	</c:forEach>
	
	
	<button type="button" name="back" onclick="history.back()">back</button>
	<button type="button" name="back" onclick="location.href='allCustomers'" style="float: right;">All Customers List</button>