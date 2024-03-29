<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crunchify - Spring MVC Upload Multiple Files Example</title>
<script
	src="js\jquery-3.4.1.min.js"></script>
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
	<br>
	<br>
	<div align="center">
		<h1>Crunchify - Spring MVC Upload Multiple Files Example</h1>

		<!-- <form:form method="post" action="savefiles.html"
			modelAttribute="uploadForm" enctype="multipart/form-data"> -->

			<p>Select files to upload. Press Add button to add more file
				inputs.</p>

			<table id="fileTable">
				<tr>
					<td><input name="files[0]" type="file" /></td>
				</tr>
				<tr>
					<td><input name="files[1]" type="file" /></td>
				</tr>
			</table>
			<br />
			<input type="submit" value="Upload" />
			<input id="addFile" type="button" value="Add File" />
	<!-- 	</form:form>
 -->
		<br />
	</div>
</body>
</html>
