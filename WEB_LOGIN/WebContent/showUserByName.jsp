<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*, java.util.TimeZone,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib  prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
  <%@include file="css/login.css" %>
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="login-page">
  <div class="form">
    <form class="login-form" action="ShowUserByName" method="get">
      <input type="text" placeholder="username" name="username"/>
      <button>Search</button>
    </form>
  </div>
</div>
<div align="center">
<table border="1" cellpadding="5">
	<caption><h2>List of users</h2></caption>
	            <tr>
	                <th>Name</th>
	                <th>Email</th>
	            </tr>
    <c:forEach var="users" items="${users}" >
        <tr>
            <td><c:out value="${users.username}" /></td>
             <td><c:out value="${users.email}" /></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>