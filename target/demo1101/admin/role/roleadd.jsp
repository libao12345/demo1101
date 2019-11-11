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
        <li role="presentation" class="active"><a href="javascript:void(0);" onclick="history.back();">角色管理</a></li>
    </ul>
</header>
<article>
    <form id="form1" method="post" action="roleadd.html" class="form-inline">
        <dl>
            <dt>添加角色信息</dt>
            <dd class="form-group">
                <label>角色名:</label><input type="text" name="roleName" required autofocus class="form-control input-size" />
            </dd>
            <dd class="form-group">
                <label>角色描述:</label><input type="text" name="roleDescribe" required class="form-control input-size" />
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
