<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Multiple Filee</title>
<script src="js\jquery-3.4.1.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						//add more file components if Add is clicked
						$('#addFile')
								.click(
										function() {
											var fileIndex = $('#fileTable tr')
													.children().length - 1;
											$('#fileTable')
													.append(
															'<tr><td>'
																	+ '   <input type="file" name="files['+ fileIndex +']" />'
																	+ '</td></tr>');
										});

					});
</script>
<style type="text/css">
body {
	background-image:
		url('https://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
</head>
<body>
	<h1>Upload single file</h1>
	<form action="HomeController" method="post"
		enctype="multipart/form-data">
		<table id="fileTable">
			<tr>
				<td><input name="files[0]" type="file" /></td>
			</tr>
			<tr>
				<td><input name="files[1]" type="file" /></td>
			</tr>
		</table>
		</br>
		</br> File to upload: <input type="file" name="file" size="50" /> <br />
		<input type="submit" value="Submit" />
		<input id="addFile" type="button" value="Add File" />
	</form>
</body>
</html>
