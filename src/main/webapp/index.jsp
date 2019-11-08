<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/01
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>首页...</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/index.css" />
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/index.js"></script>
  </head>
  <body>
    <div id="dialogShadow">
      <div id="dialog">
        <p class="dialog-title">提示</p>
        <p class="dialog-message">......</p>
        <p class="dialog-btns">
          <input type="button" value="确 定" class="btn btn-primary input-sm" />
        </p>
      </div>
    </div>
    <header></header>
    <aside>
      <ul class="nav nav-pills nav-stacked">
        <li id="1" class="active"><a href="javascript:void(0);">个人中心</a></li>
        <li parentId="1"><a href="javascript:void(0);" target="mainFrame">我的资料</a></li>
        <li parentId="1"><a href="javascript:void(0);" target="mainFrame">修改密码</a></li>
        <li id="2" class="active"><a href="javascript:void(0);">资料管理</a></li>
        <li parentId="2"><a href="javascript:void(0);" target="mainFrame">全部文件</a></li>
        <li parentId="2"><a href="javascript:void(0);" target="mainFrame">图像</a></li>
        <li parentId="2"><a href="javascript:void(0);" target="mainFrame">视频</a></li>
        <li parentId="2"><a href="javascript:void(0);" target="mainFrame">合同</a></li>
        <li parentId="2"><a href="javascript:void(0);" target="mainFrame">制度</a></li>
        <li id="3" class="active" role="last"><a href="javascript:void(0);">系统管理</a></li>
        <li parentId="3" role="last"><a href="userquery.html" target="mainFrame">用户管理</a></li>
        <li parentId="3" role="last"><a href="rolequery.html" target="mainFrame">角色管理</a></li>
        <li parentId="3" role="last"><a href="javascript:void(0);" target="mainFrame">权限管理</a></li>
      </ul>
    </aside>
    <article>
      <iframe id="mainFrame" name="mainFrame" src="userquery.html" width="100%" height="100%" frameborder="0" />
    </article>
    <footer></footer>
  </body>
</html>
