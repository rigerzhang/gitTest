<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteItem").click(function () {
                return confirm("你确认要删除" + $(this).parent().parent().find("td:first").text() + "吗?");
            });
            $("a.clearCart").click(function () {
                return confirm("你确认清空吗?");
            });
            $(".updateCount").change(function () {
                let name = $(this).parent().parent().find("td:first").text();
                let count = $(this).val();

                if (confirm("你确认要修改" + name + "的数量为" + count + "吗?")) {
                    ${sessionScope.cart[]}
                }
            });
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/login_success.jsp" %>

</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${sessionScope.cart.items}" var="cartItem">
            <tr>
                <td>${cartItem.value.name}</td>
                <td>
                    <input type="text" class="updateCount" value="${cartItem.value.count}" style="width: 80px">
                </td>
                <td>${cartItem.value.price}</td>
                <td>${cartItem.value.totalPrice}</td>
                <td><a class="deleteItem" href="${basePath}cartServlet?action=deleteItem&id=${cartItem.value.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty sessionScope.cart.items}">
            <td colspan="5">
                <a href="index.jsp" content="cen">请在首页选择</a>
            </td>
        </c:if>
    </table>

    <div class="cart_info">
        <c:if test="${not empty sessionScope.cart.items}">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a class="clearCart" href="${basePath}cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>

        </c:if>

    </div>

</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>