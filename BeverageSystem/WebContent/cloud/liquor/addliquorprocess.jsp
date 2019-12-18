<%@page import="in.inzenjer.admin.AdminDAO"%>
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
String type=request.getParameter("typ").trim();
String brand=request.getParameter("lbnd").trim();
String quantity=request.getParameter("lqty").trim();
String price=request.getParameter("lpr").trim();
String bottels=request.getParameter("lbot").trim();


	int ret=AdminDAO. addLiquorDetails(type, brand, quantity, price, bottels);
	if(ret>0){
	response.sendRedirect("addliquor.jsp");
	}
%>

</body>
</html>