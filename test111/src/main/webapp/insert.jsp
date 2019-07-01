<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="entity.*,Dao.*,java.util.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
int id=Integer.parseInt(request.getParameter("id"));
String name=request.getParameter("name");
int age=Integer.parseInt(request.getParameter("age"));
String sex=request.getParameter("sex");
int weight=Integer.parseInt(request.getParameter("weight"));
int height=Integer.parseInt(request.getParameter("height"));

int count = 0;
	StuDaoImpl studao = new StuDaoImpl();
	Stu stu=new Stu(id,name,sex,age,weight,height);
	count = studao.insert(stu);
	
	if (count!=0){
		response.sendRedirect("findAll.jsp");
		
	}
	else{
		out.print("插入失败");
		
	}


%>


          
</body>
</html>