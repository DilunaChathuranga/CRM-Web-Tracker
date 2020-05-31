<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

<div id="wrapper">
<div id="header">
<h2>CRM-Customer Relationship Manager</h2>
</div>
</div>





<div id="container">
<div id="content">
<input type="button" value="Add Customer" onclick="window.location.href='add'; return false;"  class="add-button"/>

<table>
<tr>
<th>Firstname</th>
<th>Lastname</th>
<th>Email</th>
<th>Action</th>
</tr>

<!-- Loop over and print customers -->
<c:forEach var="tempcustomer" items="${customerRef1}">

<!-- construct an update link with customer id -->
<c:url var="updateLink" value="/customer/update">
<c:param name="customerId" value="${tempcustomer.id}"></c:param>
</c:url>

<!-- construct an delete link with customer id -->
<c:url var="deleteLink" value="/customer/delete">
<c:param name="customerId" value="${tempcustomer.id}"></c:param>
</c:url>


<tr>
<td>${tempcustomer.firstName}</td>
<td>${tempcustomer.lastName}</td>
<td>${tempcustomer.email}</td>
<td><a href="${updateLink}">Update </a>
|
<a href="${deleteLink}"
onclick="if(!(confirm('Are you sure to Delete this !'))) return false">Delete</a></td>
</tr>
</c:forEach>

</table>
</div>
</div>
</body>
</html>
