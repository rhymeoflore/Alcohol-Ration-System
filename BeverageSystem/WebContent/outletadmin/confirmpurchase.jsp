<%@page import="in.inzenjer.user.UserBean"%>
<%@page import="in.inzenjer.verifypurchase.CheckMonthlyLimit"%>
<%@page import="in.inzenjer.verifypurchase.ConfirmOrder"%>
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
		UserBean ub = (UserBean) session.getAttribute("userdetails");
		String bevID = String.valueOf(ub.getBevid());
		String userID = request.getParameter("user");
		int ret = CheckMonthlyLimit.checkLimit(userID);
		int conret=0;
		if (ret > 0) {

			response.sendRedirect("userpurchase.jsp?m=LIMIT EXCEEDED");
		} else {
			ConfirmOrder.recordCOnfirm(userID, bevID);
			response.sendRedirect("userpurchase.jsp");
		}
	%>
</body>
</html>