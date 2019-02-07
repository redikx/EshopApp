<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<link type="text/css" href="<c:url value='/resources/css/add-customer-form.css' />" rel="stylesheet" />
</head>
<body>

<h2> Enter new Customer </h2>

<form:form action="newCustomerSave" method="POST" modelAttribute="newCust">
<label>First Name</label> <input type="text" name="firstName"/><br/></br>
<label>Last Name</label> <input type="text" name="lastName"/><br/></br>
<label>Email     </label><input type="text" name="email"/><br/></br>
<input type="submit" value="register"/>  
</form:form>