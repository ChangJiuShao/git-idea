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


    int count = 0;
	StuDaoImpl studao = new StuDaoImpl();
	//Stu stu=new Stu(id,name,age,sex,weight,hight);
	count = studao.delete(id);
	
	if (count!=0){
		response.sendRedirect("findAll.jsp");
		
	}
	else{
		out.print("删除失败");
		
	}


%>

</body>
</html>