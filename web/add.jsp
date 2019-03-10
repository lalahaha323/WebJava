<%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 19-3-10
  Time: 下午2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>加法网页</title>
</head>
<body>
<%
    String a = request.getParameter("a");
    String b = request.getParameter("b");
    out.println("a + b = " + (Integer.parseInt(a) + Integer.parseInt(b)));
%>
</body>
</html>
