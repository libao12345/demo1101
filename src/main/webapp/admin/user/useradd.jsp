<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/23
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/oper.css" />
    <script src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
    <header>
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="javascript:void(0);" onclick="history.back();">用户管理</a></li>
        </ul>
    </header>
    <article>
        <form id="form1" method="post" action="useradd.html" class="form-inline">
            <dl>
                <dt>添加用户信息</dt>
                <dd class="form-group">
                    <label>用户名:</label><input type="text" name="userName" required autofocus class="form-control input-size" />
                </dd>
                <dd class="form-group">
                    <label>密码:</label><input type="password" name="userPassword" required class="form-control input-size" />
                </dd>
                <dd class="form-group">
                    <label>性别:</label><input type="radio" name="userGender" value="男" checked />男
                    <input type="radio" name="userGender" value="女" class="input-radio" />女
                </dd>
                <dd class="btns">
                    <input type="submit" value="确 定" class="btn btn-primary input-sm" />
                    <input type="reset" value="重 置" class="btn btn-success input-sm" />
                </dd>
            </dl>
        </form>
    </article>
</body>
</html>
