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
			<th>OP ID</th>
			<th>OrderId</th>
			<th>Product</th>
			<th>Quantity</th>
		</tr>
		<c:forEach var="op" items="${o.orderProducts}">
			<tr>
				<td><form:input path="${order.orderId}" value="${op.order.orderId}" /></td>
				<td><form:input path="${op.order.orderId}" /></td>
				<td><form:input path="${op.product.productName}" /></td>
				<td><form:input path="${op.quantity}" /></td>
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