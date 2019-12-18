<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Modular Business</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
<script type="text/javascript" src="layout/scripts/jquery.min.js"></script>
<script type="text/javascript" src="layout/scripts/jquery.jcarousel.pack.js"></script>
<script type="text/javascript" src="layout/scripts/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="layout/scripts/jquery.jcarousel.setup.js"></script>
<script type="text/javascript" src="js/valid.js"></script>	
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
     <h1><a href="adminlogin.jsp">State Beverages</a></h1>
      <p>Corporation </p>
    </div>
    <div class="fl_right"> <a href="#"></a> </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col3">
  <div id="topnav">
    <ul>
      <li class="active"><a href="index.jsp">Homepage</a><span>Test Text Here</span></li>
     
     
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
      
      
      
       <%String msg=null;
      	msg=request.getParameter("message");
      
      %>
      
      
      
        <center>
    	
    
    	
    	<form action="loginprocess.jsp" method="get" name="form1">
<h1><b><font color="brown">Owner LOGIN</font></b></h1>
<table cellpadding=12 cellspacing=10>

<tr>
		<td>UserName:</td>
		<td>
		<input type="hidden" name="utype" value="OWNER">
		<input type="text" name="uname"></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" name="pword"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Login" onclick="return login()">
				<%if(msg!=null){ %>
				<p><%=msg %></p>
				<%} %>
		
		
		</td>
	</tr>
</table>
</form>
    	
    	
    	
   </center>
    	
    	
    	
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
       
        <br><br><br><br><br><br><br>
      <br><br><br><br><br><br>
      <br><br><br><br><br><br>
      <br><br>
      
      
      
      
      
      
      
      
      
      
      
      
    
    </div>
    <div id="column">
      <div class="holder">
        
       
      </div>
    </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col6">
  
</div>
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