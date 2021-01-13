<%--
  Created by IntelliJ IDEA.
  User: zhangli
  Date: 2020/12/15
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out put-2</title>
</head>
<body>
    pagecontext的值是：<%= pageContext.getAttribute("key")%><br>
    request的值是：<%= request.getAttribute("key")%><br>
    session的值是：<%= session.getAttribute("key")%><br>
    application的值是：<%= application.getAttribute("key")%><br>

</body>
</html>
