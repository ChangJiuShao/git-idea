<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,Dao.*,entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑更新</title>
</head>
<body>
<% 
request.setCharacterEncoding("utf-8");
int old_id=Integer.parseInt(request.getParameter("id"));
    System.out.println(old_id);
int count=0;
List<Stu> list=null;
StuDaoImpl studao=new StuDaoImpl();
list=studao.findByID(old_id);
if(list.size()>0){
	for(Stu stu:list){
	%>
	<form action="updata.jsp" method="post" >
<table border="0" cellpadding="2px" style="width: 100%;">
	
	<tr>
		<td>学号</td>
		<td><input type="text" name="id" value="<%=stu.getId() %>"/></td>
				</tr>
				<tr>
		<td>姓名</td>
		<td><input type="text" name="name" value="<%=stu.getName() %>"/></td>
				</tr>
				<tr>
		<td>年龄</td>
		<td><input type="text" name="age" value="<%=stu.getAge() %>"/></td>
				</tr>
				<tr>
		<td>性别</td>
		<td><input type="text" name="sex" value="<%=stu.getSex() %>"/></td>
				</tr><tr>
		<td>体重</td>
		<td><input type="text" name="weight" value="<%=stu.getWeight() %>"/></td>
				</tr>
				<tr>
				<td>身高</td>
		<td><input type="text" name="height" value="<%=stu.getHeight() %>"/></td>
				</tr>
				<tr>
		<td colspan="2" align="center"><input type="submit" value="修改"></td>
	</tr>
				</table>
				</form>
				<% }
		 }
	 else
	 {
		 out.println("查无此人");
	 }
	 %>
</body>
</html>