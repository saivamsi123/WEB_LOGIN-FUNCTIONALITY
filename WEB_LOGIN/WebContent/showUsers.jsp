<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*, java.util.TimeZone,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib  prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql"%>
<%HttpSession sess = request.getSession();
	sess.getAttribute("username");
	out.println(sess.getAttribute("username"));
%>
<% UserBean userBean = new UserBean(); %>
<style type="text/css">
  <%@include file="css/login.css" %>
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Show Users............!
<sql:setDataSource
    var="myDS"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/Allianz?serverTimezone=UTC"
    user="root" password=""
/>
<sql:query var="listUsers" dataSource="${myDS}">
    SELECT * FROM user_registration;
</sql:query>


<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
	            <tr>
	                <th>Name</th>
	                <th>Email</th>
	                <th>Update</th>
	                <th>Delete</th>
	            </tr>
			<c:forEach var="user" items="${listUsers.rows}">
			   <tr>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><a href="UpdateServlet?id=${user.id}">update</a></td>
					<td><button>delete</button></td>
                </tr>
			</c:forEach>
 		</table>
</div>
<a href="user_logout.jsp">Click here for Logout </a>
</body>
</html>     