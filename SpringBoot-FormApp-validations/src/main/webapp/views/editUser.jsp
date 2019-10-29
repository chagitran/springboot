<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<style>
table {
	font-family: arial, sans-serif;
	border-collapse: separate;
	width: 50%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
</style>

<meta charset="ISO-8859-1">
<style>
.error {
	color: #FF0000
}
</style>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(function() {
		$('form[id="userRegForm"]').validate({
			rules : {
				username : 'required',
				password : 'required',
				email : {
					required : true,
					email : true
				},
				phno : 'required',
				country : 'required',
			},
			messages : {
				username : 'Please enter username',
				password : 'please enter password',
				email : 'Please enter valid email',
				phno : 'please enter phone number',
				country : 'please select country',
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>
<body>
	<h1>Update User Info</h1>
	<font color='green'>${succMsg}</font>
	<font color='red'>${errorMsg}</font>

	<h2>Register Here</h2>
	<form:form action="updateUser?userId=${user.userId}" method="POST"
		modelAttribute="user" id="userRegForm">
		<table>

			<tr>
				<td>User name</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><form:input path="phno" /></td>
			</tr>
			<tr>
				<td>Countries</td>
				<td><form:select path="country" items="${countryList}" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<br>
	<font size="5"> <a href="viewUsers1?pn=1">View All Users</a>
	</font>
</body>
</html>