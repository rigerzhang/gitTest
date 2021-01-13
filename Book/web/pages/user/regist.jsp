<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function (){
			$("#code_img").click(function () {
				this.src="${basePath}kaptcha.jpg?d="+new Date();

			});
			$("#sub_btn").click(function (){
				// 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
				let username = $("#username").val();
				let usernamePatt = /^\w{5,12}$/;
				if (!usernamePatt.test(username)){
					$(".errorMsg").text("用户名格式错误");
					return false;

				}
				else {
					$(".errorMsg").text("");

				}
				// 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
				let password = $("#password").val();
				let passwordPatt = /^\w{5,12}$/;
				if (!passwordPatt.test(password)){
					$(".errorMsg").text("密码格式错误");
					return false;

				}
				else {
					$(".errorMsg").text("");

				}
				// 验证确认密码：和密码相同
				let repwd = $("#repwd").val();
				if (repwd != password){
					$(".errorMsg").text("密码确认错误");
					return false;

				}
				else {
					$(".errorMsg").text("");

				}
				// 邮箱验证：xxxxx@xxx.com
				let email = $("#email").val();
				let emailPatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				if (!emailPatt.test(email)){
					$(".errorMsg").text("邮箱格式错误");
					return false;

				}
				else {
					$(".errorMsg").text("");

				}
				// 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
				let code = $("#code").val();
				let codeText = $.trim(code);
				if(codeText == "" || codeText == null || codeText.length != 5){
					$(".errorMsg").text("验证码错误");
					return false;
				}
			});

		});
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>

								</span>
							</div>
							<div class="form">
								<form action="user" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="usr" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="pwd" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 110px;" name="code" id="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width: 90px;height:35px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>

</body>
</html>