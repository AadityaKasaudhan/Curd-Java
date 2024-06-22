<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link href="./style.css" rel="stylesheet">
<title>Login Form</title>
</head>
<body>
	<div class="container-fluid">
		<form class="mx-auto" action="UserServlet" method="post">
			<input type="hidden" name="action" value="update">
			<h4 class="text-center">User Update</h4>
			<div class="mb-3 mt-5">
				<label for="userId" class="form-label">User ID</label> <input
					type="text" name="id" class="form-control" id="userId" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputName" class="form-label">User Name</label> <input
					type="text" name="txtName" class="form-control" id="name" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" name="txtPwd" class="form-control"
					id="exampleInputPassword1" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email</label> <input
					type="email" name="txtEmail" class="form-control"
					id="exampleInputEmail1" required>
			</div>
			<button type="submit" value="update" class="btn btn-primary mt-5">Update</button>
		</form>
		>
	</div>


	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>


</body>
</html>