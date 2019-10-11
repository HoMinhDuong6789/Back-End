<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<%-- <c:if test="${name!=null}"><h4> ${name}</h4></c:if> --%>
	<%= request.getAttribute("name") !=null ?request.getAttribute("name"):" "  %>
	</br>
	<form action="LoginController" method="post">
		<input type="text" name="name" />
		</br>
		<input type="password" name="pass" />
		</br> 
		<input type="submit" value="submit" />
	</form>
	
</body>
</html>