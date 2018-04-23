<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD PRODUCT</title>
</head>
<body>
	<h2>ADD PRODUCT</h2>	
	<form action="<c:url value='/admin/addProduct' />" method="post" enctype="multipart/form-data">
	<table>
		<tr>
		<td>
		<label for="productName">Product Name : </label>
		</td>
		<td>
		<input type="text" name="productName"/>
		</td>
		</tr>
		<tr>
		<td>
		<label for="categoryId">Select category</label>
		</td>
		<td>
		<select name="categoryId">
			<c:forEach var="cl" items="${categoryList}">
				<option value="${cl.id}" ${cl.id == categoryId ? 'selected':'' }>${cl.categoryName}</option>
			</c:forEach>
		</select>
		</td>
		</tr>
		<tr>
		<td>
		<label for="description">Description</label>
		</td>
		<td>
		<textarea rows="10" cols="30" name="description"></textarea>
		</td>
		</tr>
		<tr>
		<td>
		<label for="price">Price</label>
		</td>
		<td>
		<input type="text" name="price" />
		</td>
		</tr>
		<tr>
		<td>
		<label for="condition">Condition</label>
		</td>
		<td>
		<input type="radio" name="condition" id="conditionChoice1" value="good">
		<label for="conditionChoice1">Good</label>
		<input type="radio" name="condition" id="conditionChoice2" value="new">
		<label for="conditionChoice2">New</label>
		</td>
		</tr>
		<tr>
		<td>Upload a image for product</td>
		<td><input type="file" name="productImg" /></td>
		</tr>
		<tr>
		<td>
		<input type="submit" value="Add Product" />
		</td>
		</tr>
		</table>
	</form>
</body>
</html>