<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="mx-auto" action="UserServlet" method="post">
		<input type="hidden" name="action" value="delete">
		<h4 class="text-center">Delete User</h4>
		<div class="mb-3 mt-5">
			<label for="userId" class="form-label">User ID</label> <input
				type="text" name="id" class="form-control" id="userId" required>
		</div>
		<button type="submit" value="delete" class="btn btn-primary mt-5">Delete</button>
	</form>

</body>
</html>