<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<link type="text/css" href="<c:url value='/resources/css/style.css' />" rel="stylesheet" />
</head>

<form:form method="POST" action="formForSaveOrder" modelAttribute="order">
	<table>

	<td>OrderId</td>
	<td> <form:input path="orderId"/> </td>
	</tr>

	<tr>
	<td>Order Date</td>
	<td><form:input path="orderDate"/> </td>
	</tr>
	
	<tr>
	<td>Customer Id</td>
	<td><form:input path="customerId"/> </td>
	</tr>
	<tr>   
          <td> </td>   
          <td><input type="submit" value="Save" /></td>   
         </tr>
</table>
</form:form>

<form:form method="POST" action="formForSaveOrderProducts"  modelAttribute="order">
<table>
<tr> Products </tr>
	<tr>
	<th>Product</th>
	<th>Quantity</th>
	<th> Manufacturer </th>
	</tr>
	<c:forEach var="oProducts" items="${orderProducts}">
	<tr>
	<td><form:input path="orderProducts" value="${oProducts.product.getProductName()}"/> </td>
	<td><form:input path="orderProducts" value="${oProducts.getQuantity()}"/> </td>	
	<td>${oProducts.product.getManufacturer().getManName() } </td>
	</tr>
	</c:forEach>		
	  <tr>   
          <td> </td>   
          <td><input type="submit" value="Save" /></td>   
         </tr>   
         
	</table>
	</form:form>
	