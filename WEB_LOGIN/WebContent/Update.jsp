<%@ taglib  prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*, java.util.TimeZone,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<body>
	<h1>Update data from database in jsp</h1>
	<c:forEach var="users" items="${users}" >
	<form method="post" action="UpdateServlet">
	<input type="hidden" name="id" value="${users.id}">
	<input type="text" name="id" value="${users.id}">
	<br>
	Username:<br>
	<input type="text" name="username" value="<c:out value="${users.username}" />"/>
	<br>
	Email:<br>
	<input type="text" name="email" value="<c:out value="${users.email}" />" />
	<br>
	Phone Number:<br>
	<input type="text" name="pno" value="<c:out value="${users.phoneno}" />" />
	<br>
	Address:<br>
	<input type="text" name="address" value="<c:out value="${users.address}" />" />
	<br><br>
	Password:<br>
	<input type="password" name="password" value="<c:out value="${users.password}" />" />
	<br><br>
	<input type="submit" value="submit">
	</form>
	</c:forEach>
</body>