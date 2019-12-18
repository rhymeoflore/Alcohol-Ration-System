<%@page import="in.inzenjer.getNames.GetNamesByID"%>
<%@page import="in.inzenjer.admin.AdminDAO"%>
<%@page import="in.inzenjer.user.UserBean"%>
<%@page import="in.inzenjer.outletAdmin.OutletAdminDAO"%>
<%@page import="java.sql.ResultSet"%>
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
     <h1><a href="adminhome.jsp">State Beverages</a></h1>
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
      <li class="active"><a href="adminhome.jsp">Home</a><span>Test Text Here</span></li>
      <li><a href="changepassword.jsp">Change Passwords</a><span>Test Text Here</span></li>
      
      <li><a href="#">Liquor</a><span>Test Text Here</span>
      	<ul>
          <li><a href="viewliquor.jsp">View</a></li>
          
         
        </ul>
      </li>
      
      <li><a href="#">User</a><span>Test Text Here</span>
        <ul>
          <li><a href="viewuser.jsp">View</a></li>
         
          
        </ul>
      </li>
      
      <li><a href="#">Purchase</a><span>Test Text Here</span>
        <ul>
          <li><a href="userpurchase.jsp">User</a></li>
           <li><a href="userpurchasehistory.jsp"> purchase History</a></li>
         
        </ul>
      </li>
       
       
      <li class="last"><a href="../index.jsp">Log Out</a><span>Test Text Here</span></li>
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
      UserBean ub=(UserBean)session.getAttribute("userdetails");
      String bevID=ub.getBevid();
      
      %>
    
        	<center>



					<h1>
						<b><font color="brown">ALL STOCK</font></b>
					</h1>


				</center>















				<%
					int val = 1;
					ResultSet res = OutletAdminDAO.getAllStockDeatils(bevID);
					String col[] = AdminDAO.getMetaData(res);
				%>



				<br>
				<br>
				<table align="center" border="1" " width="600" background="red">
					<tr align="center" style="font-size: medium; color: black;">
						<td>SL No</td>
						<%
							for (int i = 0; i < col.length; i++) {

								if (col[i].equals("outbrid")) {
									continue;
								} else if (col[i].equals("oid")) {
									continue;
								} else if (col[i].equals("username")) {
									continue;
								}
						%>
						<td><%=col[i].toUpperCase()%></td>

						<%
							}
						%>




						<%
							while (res.next()) {
						%>
					
					<tr>
						<td><%=val%></td>

					
						<td><%=GetNamesByID.getLiquorTypeNameByID(res.getString(3))%></td>
						<td><%=GetNamesByID.getBrandNameByID(res.getString(4))%></td>
						<td><%=res.getString(5)%></td>
						<td><%=res.getString(6)%></td>
						<td><%=res.getString(7)%></td>
					



					</tr>
					<%
						val++;
						}
					%>
				</table>














        
        <br><br><br><br><br><br><br>
     
        <br><br><br><br><br><br><br>
     
   
      
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