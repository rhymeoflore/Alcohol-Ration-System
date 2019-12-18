<%@page import="in.inzenjer.user.UserBean"%>

<%@page import="java.util.ArrayList"%>
<%@page import="in.inzenjer.company.Company"%>
<%@page import="in.inzenjer.user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Modular Business</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="../layout/styles/layout.css" type="text/css" />
<script type="text/javascript" src="../layout/scripts/jquery.min.js"></script>
<script type="text/javascript" src="../layout/scripts/jquery.jcarousel.pack.js"></script>
<script type="text/javascript" src="../layout/scripts/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="../layout/scripts/jquery.jcarousel.setup.js"></script>
<script type="text/javascript" src="../js/Validation.js"></script>
</head>
<body id="top">
<div class="wrapper col1">
  <div id="topbar">
    <p>Tel: xxxxx xxxxxxxxxx | Mail: info@domain.com</p>
    <ul>
      <li><a href="#">Libero</a></li>
      <li><a href="#">Maecenas</a></li>
      <li><a href="#">Mauris</a></li>
      <li class="last"><a href="#">Suspendisse</a></li>
    </ul>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col2">
  <div id="header">
    <div class="fl_left">
      <h1><a href="policehome.jsp">Smoke Testing System </a></h1>
      <p>Report anytime</p>
    </div>
    <div class="fl_right"> <a href="#"></a> </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col3">
  <div id="topnav">
<ul>
      <li class="active"><a href="cloudhome.jsp">Home</a><span>Test Text Here</span></li>
      <li><a href="changepassword.jsp">Change Passwords</a><span>Test Text Here</span></li>
      
      <li><a href="#">OutLets</a><span>Test Text Here</span>
        <ul>
          <li><a href="outlet/addoutlet.jsp">Add outlet</a></li>
          <li><a href="outlet/viewoutlet.jsp">VIew OutLets</a></li>
         <li><a href="outlet/deleteoutlet.jsp">Delete OutLets</a></li>        
        </ul>
      </li>
      
       <li><a href="#">User</a><span>Test Text Here</span>
        <ul>
          <li><a href="user/adduser.jsp">ADD USER </a></li>
            <li><a href="user/viewuser.jsp">View USER </a></li>
              <li><a href="user/deleteuser.jsp">DELETE USer </a></li>
        </ul>
      </li>
      
       <li><a href="#">Liquor</a><span>Test Text Here</span>
       		<ul>
       			  <li><a href="liquor/addliquor.jsp">ADD LIQUOR</a></li>
       			  <li><a href="liquor/viewmainstock.jsp">View Record</a></li> 
       			    <li><a href="liquor/sendtooutlet.jsp">send To OutLet</a></li>
       		</ul>
       </li>
        <li><a href="#">Purchase</a><span>Test Text Here</span>
       		<ul>
       			  <li><a href="purchaseHistory.jsp">Purchase History</a></li>
       			 
       		</ul>
       </li>
        <li><a href="#">Alert</a><span>Test Text Here</span>
       		<ul>
       			  <li><a href="alert.jsp">Messages</a></li>
       			 
       		</ul>
       </li>
      
      <li class="last"><a href="../index.jsp">Log Out</a><span>Test Text Here</span></li><!-- Modified by Deepak  -->
    </ul>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col4">
  
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col5">
  <div id="container">
    <div id="content">
      <%
      UserBean comp=(UserBean)session.getAttribute("userdetails");
      
      %>
     
   
   
  <form action="updatepasswordprocess.jsp" method="get" name="form1">
	<center>
<h1><b><font color="brown">Reset Password</font></b></h1>
<table cellpadding=12 cellspacing=10>
<tr>
		<td>Current password:</td>
		<td><input type="password" name="cpass">
			<input type="hidden" name="utype" value="cloud"/>
		
		</td>
	</tr>
	<tr>
		<td>New Password:</td>
		<td><input type="password" name="newpass"></td>
	</tr>
	<tr>
		<td>Confirm Password:</td>
		<td><input type="password" name="confirmcpass"></td>
	</tr>
	<tr>
		<td></td>
		<td align="center"><input type="submit" value="RESET PASSWORD" onclick="return changepass()"></td>
	</tr>
	
</table>
</center>	
</form>
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    
    </div>
    <div id="column">
      <div class="holder">
        
       
      </div>
    </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->

<!-- ####################################################################################################### -->
<div class="wrapper col7">
  <div id="copyright">
    <p class="fl_left">Copyright &copy; 2014 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a target="_blank" href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
    <br class="clear" />
  </div>
</div>
</body>
</html>