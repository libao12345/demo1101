<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/30
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/list.css" />
    <script src="js/jquery-3.4.1.min.js"></script>
    <script>
        /**
         * 添加
         */
        function add() {
            location.href = "useraddview.html";
        }

        /**
         * 删除
         */
        function deleting() {
            //获得选择的行数，选中复选框的数量
            var count = $("#form1 input[name=id]:checked").length;
            //判断是否未选择1行
            if(count==0) {
                parent.alert("提示","请至少选择1行数据!");
                return;
            }
            //弹出选择对话框，让用户确定是否删除
            parent.confirm("提示", "您是否要删除选择的数据?", function() {
                //获得表单对象
                var form = $("#form1").get(0);
                //设置请求路径
                form.action = "userdelete.html";
                //提交表单
                form.submit();
            });
        }

        /**
         * 更新
         */
        function update() {
            //获得选择的行数，选中复选框的数量
            var count = $("#form1 input[name=id]:checked").length;
            if(count==0 || count>1) {
                parent.alert("提示","请选择1行数据!");
                return;
            }
            //获得表单对象
            var form = $("#form1").get(0);
            //设置请求路径
            form.action = "userupdateview.html";
            //提交表单
            form.submit();
        }
        /*全选*/
        function checkAll(thisz) {
            $("#form1 input[name=id]").prop("checked", thisz.checked);
        }
    </script>
</head>
<body>
<header>
    <ul class="nav nav-tabs">
        <li role="presentation" class="active"><a href="javascript:void(0);" onclick="history.back()">用户管理</a></li>
    </ul>
</header>
<article>
    <section class="search">
        <form method="post" action="oneuserquery.html" class="form-inline">
            <section class="form-group">
                <input type="text" name="suserName" placeholder="按用户名搜索!" class="form-control" />
                <input type="submit" value="搜索" class="btn btn-warning" />
            </section>
        </form>
    </section>
    <form id="form1" method="post" action="">
        <table class="table table-bordered table-hover">
            <tr>
                <th><input type="checkbox" onclick="checkAll(this)" /></th>
                <th>序号</th>
                <th>用户名</th>
                <th>性别</th>
                <th>角色名称</th>
                <th>操作时间</th>
            </tr>
            <c:forEach items="${pageInfo.list}" var="user" varStatus="st">
                <tr>
                    <td><input type="checkbox" name="id" value="${user.userId}"></td>
                    <td>${st.count}</td>
                    <td>${user.userName}</td>
                    <td>${user.userGender}</td>
                    <td>${user.tdemoRole.roleName}</td>
                    <td><fmt:formatDate value="${user.operTime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></td>
                </tr>
            </c:forEach>
            <c:if test="${fn:length(pageInfo.list)==0}">
                <tr>
                    <td colspan="6" align="center">未查找到数据!</td>
                </tr>
            </c:if>
        </table>
        <input type="file" id="file" name="file" style="visibility:hidden;height:1px;" onchange="uploadFile(this);" />
    </form>
    <section class="row btns">
        <section class="col-xs-12 col-sm-4">
            <input type="button" value="添 加" class="btn btn-primary" onclick="add();" />
            <input type="button" value="修 改" class="btn btn-success" onclick="update();" />
            <input type="button" value="删 除" class="btn btn-danger" onclick="deleting();" />
        </section>
        <section class="col-xs-12 col-sm-4">共-${pageInfo.total}-行 共-${pageInfo.pages}-页 当前第-${pageInfo.isFirstPage?1:pageInfo.pageNum}-页</section>
        <section class="col-xs-12 col-sm-4">
            <ul class="pager">
                <li><a href="userquery.html?pageNo=${pageInfo.isFirstPage?1:-1}">首&emsp;页</a></li>
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li><a href="userquery.html?pageNo=${pageInfo.pageNum-1}">上一页</a></li>
                </c:if>
                <c:if test="${pageInfo.hasNextPage}">
                    <li><a href="userquery.html?pageNo=${pageInfo.pageNum+1}">下一页</a></li>
                </c:if>
                <li><a href="userquery.html?pageNo=${pageInfo.isLastPage?-1:pageInfo.pages}">尾&emsp;页</a></li>
            </ul>
        </section>
    </section>
</article>
</body>
</html>
