<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<body>
<h2 align="center">Welcome To Hibernate Project !!</h2>
	<c:if test="${userData.size()>0 }">
	<br/><br/>
	<table border="8" align="center">
	<th>ID</th>
	<th>Name</th>
	<th>Email</th>
	<th>Address</th>
	
	<th colspan="9" ></th>
		<c:forEach var="user" items="${userData}">
			<tr>
			<td>	<c:out value="${user.getUserId() }"></c:out>	</td>
			<td>	<c:out value="${user.getUserName()}"></c:out>	</td>
			<td>	<c:out value="${user.getUserMail()}"></c:out>	</td>
			<td>	<c:out value="${user.getUserAddr()}"></c:out>	</td>
			
			<td>  <a href="edit${user.getUserId() }" >	<c:out value="Edit"></c:out> </a> </td>
			<td>  <a href="delete${user.getUserId() }">	<c:out value="Delete"></c:out> </a> </td>
			
			</tr>
		</c:forEach>
	</table>
	</c:if>	
<h2 align="center"><button><a href="register">New Register</a></button></h2>	
</body>
</html>