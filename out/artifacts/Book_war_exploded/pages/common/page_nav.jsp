<%--
  Created by IntelliJ IDEA.
  User: zhangli
  Date: 2021/1/3
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNO>1}">
        <a href="${requestScope.page.url}">首页</a>
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageNO-1}">上一页</a>
        <a href="${requestScope.page.url}&&pageNO=${requestScope.page.pageNO-1}">${requestScope.page.pageNO-1}</a>
    </c:if>
    【${requestScope.page.pageNO}】
    <c:if test="${requestScope.page.pageNO<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageNO+1}">${requestScope.page.pageNO+1}</a>
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageNO+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${requestScope.page.pageNO}" name="pn" id="pn_input"/>页
    <input type="button" value="确定" id="bt_OK">
</div>

