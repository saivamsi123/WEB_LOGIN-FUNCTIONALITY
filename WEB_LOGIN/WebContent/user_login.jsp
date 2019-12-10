<style type="text/css">
  <%@include file="css/login.css" %>
</style>

<%
String errorMessage = (String) session.getAttribute("errorMessage");
if (null !=errorMessage) { %>
<h4> <%=errorMessage %></h4>
<%}
%>
<div class="login-page">
  <div class="form">
    <form class="login-form" action="LoginServletDemo" method="get">
      <input type="text" placeholder="username" name="username"/>
      <input type="password" placeholder="password" name="password"/>
      <button>login</button>
      <p class="message">Not registered? <a href="user_registration.jsp">Create an account</a></p>
    </form>
  </div>
</div>