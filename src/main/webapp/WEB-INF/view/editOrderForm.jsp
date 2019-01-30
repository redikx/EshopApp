<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
         
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<link type="text/css" href="<c:url value='/resources/css/style.css' />" rel="stylesheet" />
</head>

<form:form method="POST" action="formForSaveOrder" modelAttribute="o">
	<table>
<tr>
	<td>OrderId</td>
	<td> <form:input path="orderId"  value="${o.orderId}"/> </td>
	</tr>

	<tr>
	<td>Order Date</td>
	<td>
	<form:input  path="orderDate" value="${o.orderDate}"/> </td>
	</tr>
	
	<tr>
	<td>Customer Id</td>
	<td><form:input path="customerId" value="${o.customerId}"/> </td>
	</tr>
	<tr>   
          <td> </td>   
          <td><input type="submit" value="Save Order" /></td>   
         </tr>
</table>
</form:form>

<form:form method="POST" action="formForSaveOrderProducts"  modelAttribute="op">
<table>
	<tr>
	<th>Product</th>
	<th>Quantity</th>
	<th> Manufacturer </th>
	</tr>
	<c:forEach var="op" items="${op}">
	<tr>
<td><input value="${op.product.productName}" /></td>
<td><input value="${op.quantity}" /></td>
<td> <input value=${op.product.manufacturer.manName } /></td>
</tr>
<tr>
<td>

	<td></td>
	
	</c:forEach>		
	  <tr>   
          <td> </td>   
          <td><input type="submit" value="Save Products" /></td>   
         </tr>   
         
	</table>
	</form:form>
	</html>