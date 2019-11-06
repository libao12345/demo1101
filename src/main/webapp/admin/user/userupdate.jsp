<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/23
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/oper.css" />
    <script src="js/jquery-3.4.1.min.js"></script>

</head>
<body>
    <header>
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="javascript:void(0);" onclick="history.back()">用户修改</a></li>
        </ul>
    </header>
    <article>
        <form id="form1" method="post" action="userupdate.html">
            <dl>
                <dt>修改用户信息</dt>
                <dd>
                    <input type="text" name="userName" value="${user.userName}" class="form-control" />
                    <input type="hidden" name="method" value="update" />
                    <input type="hidden" name="userId" value="${user.userId}" />
                    <input type="hidden" name="userPassword" value="${user.userPassword}" />
                    <input type="hidden" name="userGender" value="${user.userGender}" />
                </dd>
                <dd class="btns">
                    <input type="submit" value="确 定" class="btn btn-primary input-sm" />
                    <input type="reset" value="取 消" class="btn btn-success input-sm" />
                </dd>
            </dl>
        </form>
    </article>

</body>
</html>
