<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>
	<h2>Category</h2>
	<a href="<c:url value='/admin/addCategory' />"> Add Category</a>
	${msg}
	<table>
	<tr>
		<th>Category Id</th>
		<th>Category Name</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${categoryList}" var="category" >
	<tr>
		<td>${category.id}</td>
		<td>${category.categoryName}</td>
		<td><a href="<c:url value='/admin/editCategory/${category.id}' />">Edit</a></td>
		<td><a href="<c:url value='/admin/deleteCategory/${category.id}' />">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>