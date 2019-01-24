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
	<c:forEach var="tempCust" items="${listCustomers}">
	
	<c:url value="formForUpdateCustomer" var="UpdateCustomerLink" >
		<c:param name="customerId" value="${tempCust.id}"></c:param>
	</c:url>
	<c:url value="formForDisplayCustomerDetails" var="detailsCustomerLink">
		<c:param name="customerId" value="${tempCust.id}"></c:param>
	</c:url>
	
	<tr>
	<td> ${tempCust.id } </td>
	<td> ${tempCust.firstName } </td>
	<td> ${tempCust.lastName } </td>
	<td> ${tempCust.email } </td>
	<td> ${tempCust.customerCard.getCardNumber() } </td>
	<td> <a href="${UpdateCustomerLink}">Update</a>
	<td> <a href="${detailsCustomerLink}">Details</a>
	</tr>
	</c:forEach>
</table>
<button type="button" name="back" onclick="location='${pageContext.request.contextPath}'" style="float: left;">Main Page</button>