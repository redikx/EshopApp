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
	</tr>
	<c:forEach var="tempCust" items="${listCustomers}">
	
	<tr>
	<td> "${tempCust.id }" </td>
	<td> "${tempCust.firstName }" </td>
	<td> "${tempCust.lastName }" </td>
	<td> "${tempCust.email }" </td>
	<td>  ${tempCust.customerCard.getCardNumber()}  </td>
	</tr>
	</c:forEach>
</table>