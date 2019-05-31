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

    <%--页面加载完成之后发送ajax请求--%>

    <script>


        $(function () {
        toPage(1);



        });

        function toPage(pn) {
            $.ajax({
                url:"${pageContext.request.contextPath}/emp",
                data:"page="+pn,
                type:"GET",
                success:function (data) {
                    //1 构建表格信息
                    buider_table(data);
                    //2构建分页信息
                    page_info(data);
                    //构建分页条
                    page_nav(data)

                }
            });
        }

        //构建表格信息
        function buider_table(data) {
            $("#table tbody").empty();
          var emps = data.map.pageInfo.list;
          $.each(emps,function (index,emp) {

              var eid = $("<td></td>").append(emp.eid);
              var ename = $("<td></td>").append(emp.ename);
              var email = $("<td></td>").append(emp.email);
              var gender = $("<td></td>").append(emp.gender);
              var dname = $("<td></td>").append(emp.department.dname);

              /*  添加按钮
                             <button type="button" class="btn btn-primary">
                                  <span class="glyphicon glyphicon-pencil btn-xs" aria-hidden="true"></span>
                                  编辑
                              </button>
              */

              var btn1 = $("<button ></button>").addClass("btn btn-primary").append($("<span></span>").addClass("glyphicon glyphicon-pencil btn-xs")).append("编辑");
              var btn2= $("<button ></button>").addClass("btn btn-danger").append($("<span></span>").addClass("glyphicon glyphicon-trash btn-xs")).append("删除");
              //能链式编程的主要原因是调用append后返回的还是tr本身
              var tr = $("<tr></tr>")
                  .append(eid)
                  .append(ename)
                  .append(email)
                  .append(gender)
                  .append(dname)
                  .append(btn1)
                  .append(btn2);
              $("#table tbody").append(tr);

          });

        }
        //构建页码信息
        function page_info(data) {
            $("#page_info").empty();
            //  当前页码：,总页码：,总记录数：
            $("#page_info").append("当前页码:"+data.map.pageInfo.pageNum+",总页码："+data.map.pageInfo.pages+",总记录数："+data.map.pageInfo.total);

        }

        
        function page_nav(data) {
            //每次调用此函数时先清空
            $("#pages").empty();
            var ul = $("<ul ></ul>").addClass("pagination");
            //首页
            var first = $("<li ></li>").append($("<a></a>").append("首页").attr("href","#"));


            ul.append(first);
            //上一页
            var prePage = $("<li ></li>").append($("<a></a>").attr("href","#").append($("<span ></span>").append("&laquo;")));
            if (!data.map.pageInfo.hasPreviousPage){
                prePage.addClass("disabled");
                first.addClass("disabled")
            }else {
                first.click(function () {
                    toPage(1)
                });

                prePage.click(function () {
                    toPage(data.map.pageInfo.pageNum-1);
                });
            }

            ul.append(prePage);

            $.each(data.map.pageInfo.navigatepageNums,function (index,pn) {

               var page = $("<li ></li >").append($("<a></a >").attr("href","#").append(pn));
               if (data.map.pageInfo.pageNum==pn){
                   page.addClass("active")
               }
               page.click(function () {
                   toPage(pn);
               });
               ul.append(page)
            });
            //下一页
            var nextPage = $("<li ></li>").append($("<a></a>").attr("href","#").append($("<span ></span>").append("&raquo;")));

            ul.append(nextPage);
            //末页
            var last = $("<li ></li>").append($("<a></a>").append("末页").attr("href","#"));
            ul.append(last);

            if (!data.map.pageInfo.hasNextPage){

                nextPage.addClass("disabled");
                last.addClass("disabled")
            }else{
                nextPage.click(function () {
                    toPage(data.map.pageInfo.pageNum+1)
                });

                last.click(function () {
                    toPage(data.map.pageInfo.pages)
                });
            }
            var nav = $("<nav></nav>").append(ul);
            $("#pages").append(nav);

            //点击新增弹出模态框  在此之前调用方法发送ajax请求查询部门信息
            $("#modal").click(function () {
                $("#myModal").modal( {
                    //设置为static 点击背景模态框不会消失
                    backdrop:"static"
                });
                    getDeps();

            });
          //发送ajax请求 获取部门信息 并填充到下拉选
          function getDeps() {
              $.ajax({
                  url:"${pageContext.request.contextPath}/deps",
                  type:"GET",
                  success:function (data) {

                      $.each(data.map.deps,function (index,dep) {
                          $("#select").append($("<option></option>").append(dep.dname).attr("value",dep.did))
                      })
                  }
              });
          }

          //校验用户名和邮箱
            function check(){
              var email = $("#email").val();
                var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
              if (!regEmail.test(email)){
                  //alert("邮箱格式不正确");
                  //在每次添加属性之前清除原有属性
                  $("#email").parent().removeClass("has-error has-success");
                  //利用Bootstrap的校验状态的has-error has-success 的属性进行校验 即在需要校验的输入框的父类上添加此属性
                  $("#email").parent().addClass("has-error");
                    //在输入框的下一个span标签添加提示文本
                  $("#email").next("span").text("邮箱格式错误");

                  return false;

              }else {
                  //在每次添加属性之前清除原有属性
                  $("#email").parent().removeClass("has-error has-success");
                  //利用Bootstrap的校验状态的has-error has-success 的属性进行校验 即在需要校验的输入框的父类上添加此属性
                  $("#email").parent().addClass("has-success");
                  //在输入框的下一个span标签添加提示文本
                  $("#email").next("span").text("");
                  return true;
              }


            }
            //给用户输入框绑定change事件 输入框改变时就发送ajax请求来验证用户名是否存在

            var  flag=true;
            $("#empName").change(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/checkUser",
                    data:"ename="+$("#empName").val(),
                    type:"GET",
                    success:function (data) {
                        //alert(data);
                        flag=data;
                     if (!flag){
                         $("#empName").parent().removeClass("has-error has-success");
                         //利用Bootstrap的校验状态的has-error has-success 的属性进行校验 即在需要校验的输入框的父类上添加此属性
                         $("#empName").parent().addClass("has-error");
                         $("#empName").next("span").text("用户已存在");
                     }else{
                         $("#empName").parent().removeClass("has-error has-success");
                         //利用Bootstrap的校验状态的has-error has-success 的属性进行校验 即在需要校验的输入框的父类上添加此属性
                         $("#empName").parent().addClass("has-success");
                         $("#empName").next("span").text("请填写邮箱");
                     }

                    }

                });

            });

          //新增用户 点击保存按钮之后发送ajax请求
            $("#save").click(function () {


              //序列化表单内容

              var data = $("#myform").serialize();

            if (check()&&flag){

                //restful风格的
                $.ajax({
                    url:"${pageContext.request.contextPath}/emp",
                    type:"POST",
                    data:data,
                    success:function (result) {
                        //1.提示成功信息
                        alert(result.msg);
                        //2.关闭模态框
                        $("#myModal").modal("hide");
                        /*3.转到最后一页 显示插入的数据
                            可以再次发送ajax请求  传递一个特别大的页码
                            当页码超出当前的最大页码时 分页插件就会默认转到最后一页

                            也可以传递总记录数为页码
                      */
                        toPage(9999999);
                        //每次提交后把表单内容清空
                        $("#myform")[0].reset();
                        $("#myform").find("*").removeClass("has-error has-success");//清空样式
                        $("#myform").find(".help-block").text("")

                    }

                });
            }

            });

        }

    </script>


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
            <button type="button" class="btn btn-primary" id="modal">新增</button>
            <button  type="button" class="btn btn-danger">删除</button>
        </div>
    </div>
    <%--表格--%>
    <div class="row">
        <table class="table table-hover" id="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>empEmail</th>
                    <th>empGender</th>
                    <th>Department</th>
                    <th>操作</th>
                </tr>
            </thead>

                    <tbody>

                    </tbody>
        </table>
    </div>
    <%--页码信息--%>
    <div class="row">
        <div class="col-md-6" id="page_info">

        </div>
        <div id="pages">

        </div>
    </div>

</div>

<%--用于添加员工的模态框--%>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加员工信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="myform">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" name="ename" class="form-control" id="empName" placeholder="empName">
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text"  name="email" class="form-control" id="email" placeholder="email">
                            <span  class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="man" value="man"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="woman" value="woman"> 女
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Department</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="dId"  id="select">

                            </select>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save">保存</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
