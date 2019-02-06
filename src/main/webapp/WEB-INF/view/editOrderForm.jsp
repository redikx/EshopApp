<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<link type="text/css" href="<c:url value='/resources/css/style.css' />"
	rel="stylesheet" />
</head>

<form:form method="POST" action="formForSaveOrder" modelAttribute="o">
	<table>

		<tr>
			<td><form:hidden path="orderId" /></td>
		</tr>
		<tr>
			<td><form:hidden path="customerId" /></td>
		</tr>

		<tr>
		<tr>
			<td>Order Date</td>
			<td><form:input path="orderDate" /></td>
		</tr>

		<tr>
			<td>Order Date</td>
			<td><form:input path="orderNotes" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>

<form:form method="POST" action="formForSaveOrderProducts"
	modelAttribute="op">
	<table>
		<tr>
			<th>Product Name</th>
			<th>Quantity</th>
			<th>Producent</th>
		</tr>
		
		
			<c:forEach var="op" items="${op}">
	<tr>
<td>${op.product.productName } </td>
<td>${op.quantity }</td>
<td>${op.product.manufacturer.getManName() }</td>
<td> 
</tr>
			<tr>
				<td>
				<td></td>
		</c:forEach>
		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>

	</table>
</form:form>


</html>