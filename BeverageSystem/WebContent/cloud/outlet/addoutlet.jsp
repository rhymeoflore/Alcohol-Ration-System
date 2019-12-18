<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Modular Business</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="../../layout/styles/layout.css"
	type="text/css" />
<script type="text/javascript" src="../../layout/scripts/jquery.min.js"></script>
<script type="text/javascript"
	src="../../layout/scripts/jquery.jcarousel.pack.js"></script>
<script type="text/javascript"
	src="../../layout/scripts/jquery.easing.1.3.js"></script>
<script type="text/javascript"
	src="../../layout/scripts/jquery.jcarousel.setup.js"></script>
<script type="text/javascript" src="../../layout/scripts/app-ajax.js"></script>
<script type="text/javascript"
	src="../../layout/scripts/jquery.jcarousel.setup.js"></script>
<script type="text/javascript" src="jss/app-ajax.js"></script>
<script type="text/javascript" src="jss/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../../js/Validation.js"></script>


<script type="text/javascript">
	/* 
	 $(document).ready(function() {
	
	 $('#p').hide();
	 //alert("called");
	
	
	
	 $('#reg').blur(function() {
	 var t=$('#reg').val()
	 //alert("hhh"+t);
	
	 //alert("hello"+t);
	 var res=null;
	 //$('#link').show();
	 $.ajax({
	 url : 'jslogic.jsp',
	 data : {
	 dist : $('#reg').val(),
	 f : $('#fid').val()
	 },
	 success : function(jsonResponse) {
	 var select= $('#hname')
	 select.find('option').remove();
	 //alert("beofre loop");
	 var i=1;
	 $('#four').prop('checked',false);
	 $('#two').prop('checked',false);
	 $('#p').hide();
	 $.each(jsonResponse, function(index, value) {
	 //alert("pp="+value);
	 $('#p').show();
	
	
	 i++;
	
	 //	$('#hname').val(value);
	 });
	 /*$('#ajaxGetUserServletResponse').text(jsonResponse);*/
	/*	}
	});
	
	
	});
	
	
	});*/
</script>









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
				<h1>
					<a href="cloudhome.jsp">State Beverages</a>
				</h1>
				<p>Corporation</p>
			</div>
			<div class="fl_right">
				<a href="#"></a>
			</div>
			<br class="clear" />
		</div>
	</div>
	<!-- ####################################################################################################### -->
	<div class="wrapper col3">
		<div id="topnav">
			<ul>
				<li class="active"><a href="cloudhome.jsp">Home</a><span>Test
						Text Here</span></li>
				<li><a href="changepassword.jsp">Change Passwords</a><span>Test
						Text Here</span></li>

				<li><a href="#">OUTLETS</a><span>Test Text Here</span>
					<ul>
						<li><a href="outlet/addoutlet.jsp">Add OutLet</a></li>
						<li><a href="viewoutlet.jsp">VIew OutLets</a></li>
						<li><a href="deleteoutlet.jsp">Delete Server</a></li>

					</ul></li>

				<li><a href="#">User</a><span>Test Text Here</span>
					<ul>
						<li><a href="../user/adduser.jsp">ADD USER </a></li>
						<li><a href="../user/viewuser.jsp">View USER </a></li>
						<li><a href="../user/deleteuser.jsp">DELETE USer </a></li>
					</ul></li>

				<li><a href="#">Liquor</a><span>Test Text Here</span>
					<ul>
						<li><a href="../liquor/addliquor.jsp">ADD LIQUOR</a></li>
						<li><a href="../liquor/viewmainstock.jsp">View Record</a></li>
						<li><a href="../liquor/sendtooutlet.jsp">send To OutLet</a></li>
					</ul></li>
				<li><a href="#">Purchase</a><span>Test Text Here</span>
					<ul>
						<li><a href="../purchaseHistory.jsp">Purchase History</a></li>

					</ul></li>
					 <li><a href="#">Alert</a><span>Test Text Here</span>
       		<ul>
       			  <li><a href="alert.jsp">Messages</a></li>
       			 
       		</ul>
       </li>

				<li class="last"><a href="../../index.jsp">Log Out</a><span>Test
						Text Here</span></li>
				<!-- Modified by Deepak  -->
			</ul>
			<br class="clear" />
		</div>
	</div>
	<!-- ####################################################################################################### -->
	<div class="wrapper col4"></div>
	<!-- ####################################################################################################### -->
	<div class="wrapper col5">
		<div id="container">
			<div id="content">



				<center>

					<%
						String msg = null;
						msg = request.getParameter("message");
					%>





					<%
						if (msg != null) {
					%>

					<p><%=msg%></p>
					<%
						}
					%>

				</center>







				<center>



					<h1>
						<b><font color="brown">ADD NEW OUTLETS</font></b>
					</h1>

					<form action="addoutletprocess.jsp" name="form1">
						<table>
							<tr>
								<td>BEV ID:</td>
								<td><input type="text" name="bvid"></td>
							</tr>
							<tr>
								<td>Place:</td>
								<td><input type="text" name="place"></td>
							</tr>
							<tr>
								<td>Village:</td>
								<td><input type="text" name="vill"></td>
							</tr>
							<tr>
								<td>Taluk:</td>
								<td><input type="text" name="tlk"></td>
							</tr>
							<tr>
								<td>District:</td>
								<td><input type="text" name="dis"></td>
							</tr>
							<tr>
								<td>Phone:</td>
								<td><input type="text" name="ph"></td>
							</tr>
							<tr>
								<td>Email:</td>
								<td><input type="text" name="em"></td>
							</tr>
							<tr>
								<td>Username:</td>
								<td><input type="text" name="un"></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="pass"></td>
							</tr>
							<tr>
								<td><input type="submit" value="ADD"
									onclick="return registration()"></td>
							</tr>

						</table>




					</form>







				</center>
































			</div>
			<div id="column">
				<div class="holder"></div>
			</div>
			<br class="clear" />
		</div>
	</div>
	<!-- ####################################################################################################### -->
	<div class="wrapper col6"></div>
	<!-- ####################################################################################################### -->
	<div class="wrapper col7">
		<div id="copyright">
			<p class="fl_left">
				Copyright &copy; 2014 - All Rights Reserved - <a href="#">Domain
					Name</a>
			</p>
			<p class="fl_right">
				Template by <a target="_blank" href="http://www.os-templates.com/"
					title="Free Website Templates">OS Templates</a>
			</p>
			<br class="clear" />
		</div>
	</div>
</body>
</html>