<%@page import="java.util.HashMap"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItem"%>
<%@page import="in.inzenjer.BlockChain.SetInitialNode"%>
<%@page import="in.inzenjer.admin.AdminDAO"%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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

String contentType = request.getContentType();
HashMap<String,String> map=new HashMap<String,String>();
if ((contentType.indexOf("multipart/form-data") >= 0)) {
	DiskFileItemFactory facory=new DiskFileItemFactory();
	ServletFileUpload upload=new ServletFileUpload(facory);
	List fileitems=upload.parseRequest(request);
	Iterator itr=fileitems.iterator();
	FileItem photo=null;
	while(itr.hasNext()){
		FileItem fi=(FileItem)itr.next();
		if(!fi.isFormField()){
			photo=fi;
		}else{
			String name = fi.getFieldName();
    		String value = fi.getString();
    		map.put(name, value);
		}
	}

	int ret=AdminDAO.addUser(photo,map);
	if(ret>0){
		SetInitialNode.setHeadNode(ret,map.get("bev"),map.get("fn"),map.get("ln"), map.get("ag"), map.get("gen"), map.get("addr"), map.get("ph"));
		response.sendRedirect("adduser.jsp");
		}
	
}
%>

</body>
</html>