<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<h2>Category</h2>
	<a href="<c:url value='/admin/addProduct' />"> Add Product</a>
	${msg}
	<table>
	<tr>
		<th>Product Id</th>
		<th>Product Name</th>
		<th>Product Image</th>
		<th>Description</th>
		<th>Price</th>
		<th>Status</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${productList}" var="product" >
	<tr>
		<td>${product.id}</td>
		<td>${product.productName}</td>
		<td><img src="<c:url value='/src/main/resources/images/${product.productImage.imageName}' />" width="200px" height="160px"></td>
		<td>${product.description}</td>
		<td>${product.price}</td>
		<td>${product.condition}</td>
		<td><a href="<c:url value='/admin/editProduct/${product.id}' />">Edit</a></td>
		<td><a href="<c:url value='/admin/deleteProduct/${product.id}' />">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>