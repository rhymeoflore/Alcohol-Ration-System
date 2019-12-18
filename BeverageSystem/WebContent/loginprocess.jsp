<%@page import="in.inzenjer.user.UserBean"%>
<%@page import="in.inzenjer.user.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String uname=request.getParameter("uname");
String pword=request.getParameter("pword");
String type=request.getParameter("utype");
String org=request.getParameter("companyname"); 

System.out.println("6644"+uname);
System.out.println(pword);
String url="";
String ret="";
if(type.equals("ADMIN")){
	url="cloud/cloudhome";
	ret="cloudlogin.jsp";
}else if(type.equals("OWNER")){
	url="owner/ownerhome";
	ret="ownerlogin.jsp";
}else if(type.equals("OUTLET")){
	url="outletadmin/adminhome";
	ret="tpalogin.jsp";
}




ResultSet rs=UserDAO.authenticatingUser(uname, pword, type,org);
System.out.println("jjjj");
if(rs.next()){
	
	System.out.println("after");
	UserBean ub=new UserBean();
	ub.setId(rs.getInt(1));
	ub.setPassword(rs.getString("password"));
	System.out.println("BEVIDDDDDDDDDDDDDDDDD="+ub.getBevid());
	ub.setFirstname(rs.getString(2));
	if(type.equals("OWNER")){
		ub.setPassword(rs.getString("com_password"));
	}
	
	
	if(type.equals("OUTLET")){
		
		ub.setBevid(rs.getString("bevid"));
		System.out.println("BEVIDDDDDDDDDDDDDDDDD="+ub.getBevid());
		session.setAttribute("userdetails", ub);
		out.println("Please wait...You are beeing redirected ");
		response.setHeader("Refresh", "2;url="+url+".jsp");
	}else if(type.equals("ADMIN")){
		
		session.setAttribute("userdetails", ub);
		out.println("Please wait...You are beeing redirected ");
		response.setHeader("Refresh", "2;url="+url+".jsp");
	}
	
	
	
	
	//response.sendRedirect("userhome.jsp");
}else{
	System.out.println("login Failed");
	response.sendRedirect(ret);
	%>
	<%-- <jsp:forward page="<%=ret%>">
		<jsp:param value="Incorrect username or password" name="message"/>
	</jsp:forward> --%>
	<% 
}

%>
</body>
</html>