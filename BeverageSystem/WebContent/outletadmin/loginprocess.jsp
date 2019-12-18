

<%@page import="in.inzenjer.user.UserBean"%>
<%@page import="in.inzenjer.admin.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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

String uname=request.getParameter("uname");
String pword=request.getParameter("pword");

System.out.println(uname);
System.out.println(pword);
String url="adminhome";
ResultSet rs=AdminDAO.authenticatingCEO(uname, pword);

if(rs.next()){
	System.out.println("after");
	
	UserBean ub=new UserBean();
	ub.setId(rs.getInt(1));
	ub.setFirstname(rs.getString(2));
	ub.setPassword(rs.getString("password"));
	
	session.setAttribute("userdetails", ub);
	out.println("Please wait...You are beeing redirected ");
	response.setHeader("Refresh", "2;url="+url+".jsp");
	
	
	
	//response.sendRedirect("userhome.jsp");
}else{
	response.sendRedirect("index.jsp");
}

%>
</body>
</html>