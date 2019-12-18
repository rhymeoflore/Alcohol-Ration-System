<%@page import="in.inzenjer.outletAdmin.OutletAdminDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.inzenejer.minimizeout.MinimizeOutStock"%>
<%@page import="in.inzenjer.verifypurchase.VerifyProduct"%>
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
String user=request.getParameter("uname");
VerifyProduct.prod=request.getParameterValues("pro");
int sum=0;
MinimizeOutStock.brAndLtID=new ArrayList<String>();
MinimizeOutStock.QTY=new ArrayList<String>();
for(int i=0;i<VerifyProduct.prod.length;i++){
	System.out.println(VerifyProduct.prod[i].substring(0,VerifyProduct.prod[i].indexOf("*")));
	String product=VerifyProduct.prod[i].substring(VerifyProduct.prod[i].indexOf("*"));
	MinimizeOutStock.brAndLtID.add(VerifyProduct.prod[i].substring(0,VerifyProduct.prod[i].indexOf("*")));
	String rs=VerifyProduct.prod[i].substring(VerifyProduct.prod[i].lastIndexOf("/RS.")-5);
	String qty=rs.substring(0,rs.lastIndexOf("M"));
	MinimizeOutStock.QTY.add(qty);
	 System.out.println(rs);
	 System.out.println(qty);
	 if(!qty.equals("NAN")){
		 sum=sum+Integer.parseInt(qty);
	 }
	 
}
System.out.println("ToTAL quantity="+sum);
if(sum>(750*3)){
	response.sendRedirect("userpurchase.jsp?message=Monthly Limit Exeeded");
}else if(OutletAdminDAO.checkIfBanned(user)){
	System.out.println("transaction banned");
	response.sendRedirect("userpurchase.jsp?message=your transaction is banned for this month");
}else{
	response.sendRedirect("verifypurchase.jsp?u="+user);
}



%>
</body>
</html>