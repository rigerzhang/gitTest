<%--
  Created by IntelliJ IDEA.
  User: zhangli
  Date: 2020/12/16
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
    <form action="http://localhost:8080/04_jsp/upload" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="name"><br>
        头像：<input type="file" name="photo"><br>
        <input type="submit" value="提交"><br>

    </form>
</body>
</html>
