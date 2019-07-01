<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="entity.*,Dao.*,java.util.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SN.jsp</title>
</head>
<body>
<table border="1" align="center">
		<caption>
			学生信息
		</caption>
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>体重</th>
			<th>身高</th>
		</tr>
<%
request.setCharacterEncoding("utf-8");
List<Stu> list=null;
StuDaoImpl studao=new StuDaoImpl();
String name=request.getParameter("name");
String sex=request.getParameter("sex");
    list= studao.findByName_Sex(name, sex);
    System.out.println(list);
    if(list.size()>0){
	for(Stu stu:list){
	%>
	<tr>
		<td><%=stu.getId() %></td>
		<td><%=stu.getName() %></td>
		<td><%=stu.getSex() %></td>
		<td><%=stu.getAge() %></td>
		<td><%=stu.getWeight() %></td>
		<td><%=stu.getHeight() %></td>
	</tr>
	
<%
	}
	
	} %>	
	


</table>



</body>
</html>