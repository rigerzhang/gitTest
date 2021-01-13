<%--
  Created by IntelliJ IDEA.
  User: zhangli
  Date: 2020/12/15
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out test</title>
</head>
<body>
    <%
        pageContext.setAttribute("key","pagecontext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>

    pagecontext的值是：<%= pageContext.getAttribute("key")%><br>
    request的值是：<%= request.getAttribute("key")%><br>
    session的值是：<%= session.getAttribute("key")%><br>
    application的值是：<%= application.getAttribute("key")%><br>
    <%
    %>
</body>
</html>
