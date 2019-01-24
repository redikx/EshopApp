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

<form:form method="POST" action="formForSaveCustomer"
modelAttribute="customer">
	<table>
	
	<tr>
	<td></td>
	<td><form:hidden path="id"/> </td>
	</tr>

	<tr>
	<td></td>
	<td><form:input path="firstName"/> </td>
	</tr>

	<tr>
	<td></td>
	<td><form:input path="lastName"/> </td>
	</tr>

	<tr>
	<td></td>
	<td><form:input path="email"/> </td>
	</tr>

	<tr>
	<td></td>
	<td><form:input path="customerCard.id" value="${model.customerCard.card}"/> </td>
	</tr>
	<tr>
	<td></td>
	<td><form:input path="customerCard.card_number" value="${model.customerCard.card_number}"/> </td>
	</tr>
	  <tr>   
          <td> </td>   
          <td><input type="submit" value="Save" /></td>   
         </tr>   
         
	</table>
</form:form>
</html>