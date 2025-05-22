<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
    String username = (String) session.getAttribute("userEmail");
    if (username != null) {
%>
    <p>Session Found: <%= username %></p>
<% 
    } else {
%>
    <p>No session found.</p>
<%
    }
%>

congrultion u r first user
</body>
</html>