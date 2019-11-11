<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/6
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css" />
</head>
<body>
<div id="login">
    <form method="post" action="login.html">
        <dl>
            <dt class="login-title"><label></label><label></label><span>用户登录</span><label></label></dt>
            <dd>
                <label class="icon-user"></label>
                <input name="userName" type="text" placeholder="用户名" autofocus required  /> <%--pattern="^[A-Za-z]{1,16}"--%>
            </dd>
            <dd>
                <label class="icon-password"></label>
                <input name="password" type="password" placeholder="密码" autofocus required pattern="^[0-9]{6,11}" />
            </dd>
            <dd>
                <label class="icon-error" style="color: red;">${error}</label>
            </dd>
            <dd>
                <input type="submit" value="登录" />
            </dd>
        </dl>
    </form>
</div>
</body>
</html>

