<%@page import="in.inzenjer.admin.AdminDAO"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
String bvid=request.getParameter("bvid");
String place=request.getParameter("place");
String villg=request.getParameter("vill");
String taluk=request.getParameter("tlk");
String dist=request.getParameter("dis");
String ph=request.getParameter("ph");
String email=request.getParameter("em");
String uname=request.getParameter("un");
String pwd=request.getParameter("pass");

	int ret=AdminDAO.addOutLet(bvid,place,villg,taluk,dist,ph,email,uname,pwd); 
	if(ret>0){
	response.sendRedirect("addoutlet.jsp");
	}
%>

</body>
</html>