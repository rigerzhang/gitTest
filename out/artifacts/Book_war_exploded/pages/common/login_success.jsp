<%--
  Created by IntelliJ IDEA.
  User: zhangli
  Date: 2020/12/20
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.loginUser.usr}</span>光临尚硅谷书城</span>
        <a href="pages/order/order.jsp">我的订单</a>
        <a href="user?action=loginOut">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>¬
</body>
</html>
