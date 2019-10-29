<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: separate;
	width: 80%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
</style>
<meta charset="ISO-8859-1">
<title>View Books</title>
<script>
	function confirmDelete() {

		var status = confirm("Are you sure, you want to delete?");
		if (status) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<br>
	<br>
	<p>
		<font size="5"> <a href="registerUser">+Add User</a>
		</font>
	</p>
	<br>
	<br>
	<table border="1">
		<thead>
			<tr>
				<th>S.No</th>
				<th>USER NAME</th>
				<th>EMAIL</th>
				<th>PHONO</th>
				<th>COUNTRY</th>
				<th>ACTION</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>${user.phno}</td>
					<td>${user.country}</td>
					<td><a href="editUser?userId=${user.userId}">Edit</a> | <a
						href="deleteUser?userId=${user.userId}"
						onclick="return confirmDelete()">Delete </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>
	<br>

	<table>
		<c:if test="${cp!=1}">
			<a href="viewUsers1?pn=${cp-1}">Previous</a> &nbsp;
		</c:if>
		<c:forEach begin="1" end="${tp}" var="i">    
		&nbsp;       
			<c:choose>
				<c:when test="${cp == i}">
					<c:out value="${i}" />
				</c:when>
				<c:otherwise>
					<a href="viewUsers1?pn=${i}"><c:out value="${i}" /> </a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${cp < tp}">
		&nbsp;
			<a href="viewUsers1?pn=${cp+1}">Next</a>
		</c:if>
	</table>

</body>
</html>
