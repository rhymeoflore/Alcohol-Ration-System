


<%@page import="in.inzenjer.updatepassword.UpdatePassword"%>
<%@page import="in.inzenjer.user.UserBean"%>

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
UserBean ub=(UserBean)session.getAttribute("userdetails");

String utype=request.getParameter("utype");

String exist=ub.getPassword();
			String current=null;
			String newpassword=null;
			String confirmpassword=null;
			current=request.getParameter("cpass");
			newpassword=request.getParameter("newpass");
			confirmpassword=request.getParameter("confirmcpass");
			System.out.println("CU ="+current);
			System.out.println("EX ="+exist);
			System.out.println("NEW ="+newpassword);
			System.out.println("CNEW ="+confirmpassword);
			if(current.equals(exist)){
				System.out.println("after IF");
					if(newpassword.equals(confirmpassword)){
						
						int r=UpdatePassword.updateNewPassword(newpassword,ub.getId(),utype);
								
						System.out.println("after calling");
						if(r>0){
							ub.setPassword(newpassword);
							%>
							
									
								
							
										<jsp:forward page="passchangedisplay.jsp">
											<jsp:param value="password changed" name="passsuccess"/>
										</jsp:forward>
										
							
							
						<% }
						
						
						
						
					}else{
						%>
						
						<jsp:forward page="changepassword.jsp">
						<jsp:param value="password doesn't match" name="confirmpassmessage"/>
					
					
					</jsp:forward>
						
						
						
				<%	}
				
				
			}else{
				%>
				
				<jsp:forward page="changepassword.jsp">
					<jsp:param value="current password is wrong" name="currentpassmessage"/>
				
				
				</jsp:forward>
				
				
				
			<% }
				%>
</body>
</html>