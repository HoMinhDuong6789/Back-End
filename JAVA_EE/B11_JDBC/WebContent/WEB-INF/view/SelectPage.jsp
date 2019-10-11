<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Page</title>
</head>
<body>

	<table border="1">
			<tr>
				<td>id</td>
				<td>Username</td>
				<td>Pass</td>
				<td>Lose</td>
				<td>Win</td>
				<td>Score</td>
				
			</tr>
		<c:forEach items="${list}" var="user">
		<%-- <c:if test="${user.num>7 &&user.num<10}"> --%>
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.win}</td>
				<td>${user.lose}</td>
				<td>${user.score}</td>
			</tr>	
		
		</c:forEach>
	
	
	</table>
	
</body>
</html>