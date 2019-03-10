<%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 19-3-10
  Time: 下午2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="user" class="cc.openhome.User" scope="request" />
<jsp:setProperty name="user" property="*"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>登入页面</title>
</head>
<body>
<%
    if(user.isValid()) {
%>
    <h1><jsp:getProperty name="user" property="name"/>登入成功</h1>
<%
    } else {
%>
    <h1>登入失败</h1>
<%
    }
%>
</body>
</html>
