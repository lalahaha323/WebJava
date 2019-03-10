<%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 19-3-10
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ page import="java.io.PrintWriter"%>
<html>
<head>
    <title>错误</title>
</head>
<body>
    <h1>网页发生错误: </h1>
<%= exception %>
    <h2>显示里外堆栈追踪</h2>
<%
    exception.printStackTrace(new PrintWriter(out));
%>
</body>
</html>
