<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD CATEGORY</title>
</head>
<body>
	<h2>ADD CATEGORY</h2>	
	<form action="<c:url value='/admin/addCategory' />" method="post">
		<label for="categoryName">Category Name : </label>
		<input type="text" name="categoryName"/>
		<input type="submit" value="Add Category" />
	</form>
</body>
</html>