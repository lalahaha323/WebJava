<%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 19-3-10
  Time: 下午2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String name = "lala";
    String password = "123456";

    boolean checkUser(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charest=UTF-8">
    <title>登入页面</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    if(checkUser(name, password)) {
%>
    <h1><%= name %>登入成功</h1>
<%
    } else {
%>
    <h1>登入失败</h1>
<%
    }
%>
</body>
</html>
