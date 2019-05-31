<%--
  Created by IntelliJ IDEA.
  User: shao
  Date: 2019/5/29
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>
    <%--
    路径的选择：
    不以/为开始的 找资源 是以当前资源的路径为基准
    以/为开始的  找资源是以服务器的路径为基准的Http：//localhost:3306
    我们在前面再加上虚拟目录这样不容易出问题

    --%>

    <%--引入jQuery--%>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
    <%--引入bootStrap--%>
    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <%--标题--%>
    <div class="row">
     <div class="col-xs-12">
         <h1>SSM-CRUD</h1>
     </div>
    </div>
    <%--两个按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button type="button" class="btn btn-primary">新增</button>
            <button  type="button" class="btn btn-danger">删除</button>
        </div>
    </div>
    <%--表格--%>
    <div class="row">
        <table class="table table-hover">
            <tr>
                <th>#</th>
                <th>empName</th>
                <th>empEmail</th>
                <th>empGender</th>
                <th>Department</th>
                <th>操作</th>
            </tr>

                <c:forEach items="${pageInfo.list}" var="emp">
            <tr>
                <td>${emp.eid}</td>
                <td>${emp.ename}</td>
                <td>${emp.email}</td>
                <td>${emp.gender=="man"? "男":"女"}</td>
                <td>${emp.department.dname}</td>
                <td>
                <button type="button" class="btn btn-primary">
                    <span class="glyphicon glyphicon-pencil btn-xs" aria-hidden="true"></span>
                    编辑
                </button>
                    <button  type="button" class="btn btn-danger">
                        <span class="glyphicon glyphicon-trash btn-xs" aria-hidden="true"></span>
                        删除
                    </button>
                </td>
            </tr>
                </c:forEach>

        </table>
    </div>
    <%--页码信息--%>
    <div class="row">
        <div class="col-md-6">
            当前页码：${pageInfo.pageNum} ,总页码：${pageInfo.pages},总记录数：${pageInfo.total}
        </div>
        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="emp?page=1">首页</a></li>
                    <%--如果有上一页--%>
                    <c:if test="${pageInfo.hasPreviousPage}">
                    <li>  <a href="emp?${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                         </a>
                    </li>
                    </c:if>


                    <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                        <c:if test="${page==pageInfo.pageNum}">
                            <li  class="active"><a href="#">${page}</a></li>
                        </c:if>
                        <c:if test="${page!=pageInfo.pageNum}">
                            <li><a href="emp?page=${page}">${page}</a></li>
                        </c:if>

                    </c:forEach>

                    <%--如果有下一页--%>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="emp?${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <li><a href="emp?page=${pageInfo.pages}">未页</a></li>
                </ul>
            </nav>
        </div>
    </div>



</div>






</body>
</html>
