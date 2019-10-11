<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
<h1>Import Data From MySQL</h1>
	<form action="HomeController" method="post" enctype="multipart/form-data">
		File to upload: <input type="file" name="file" size="50" /> <br />
		<input type="submit" value="Upload File" />
	</form>
</body>
</html>