<%@page import="in.inzenjer.sentliquor.ProcessingRequest"%>
<%@page import="in.inzenjer.getNames.GetNamesByID"%>
<%@page import="java.util.HashMap"%>
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
	ProcessingRequest.ProcessingDataRequestObject(request);
/* String beerID[]=request.getParameterValues("beer_brid");
HashMap<String,Integer> beermap=new HashMap<String,Integer>();
	for(int i=0;i<beerID.length;i++){
		beermap.put(beerID[i], Integer.parseInt(request.getParameter("1_"+beerID[i]+"_bot")));
	}
	
	out.println("Beerrrr\n");
	for(int i=0;i<beerID.length;i++){
		out.println(GetNamesByID.getBrandNameByID(beerID[i])+"="+beermap.get(beerID[i])+"\n");
	}
	
String rumID[]=request.getParameterValues("rum_brid");
HashMap<String,Integer> rum750map=new HashMap<String,Integer>();
HashMap<String,Integer> rum375map=new HashMap<String,Integer>();
HashMap<String,Integer> rum180map=new HashMap<String,Integer>();
for(int i=0;i<rumID.length;i++){
	rum750map.put(rumID[i], Integer.parseInt(request.getParameter("2_"+rumID[i]+"_750bot")));
	rum375map.put(rumID[i], Integer.parseInt(request.getParameter("2_"+rumID[i]+"_375bot")));
	rum180map.put(rumID[i], Integer.parseInt(request.getParameter("2_"+rumID[i]+"_180bot")));
}

out.println("rummmmm");
for(int i=0;i<rumID.length;i++){
	out.println(GetNamesByID.getRumNameByID(rumID[i])+"\n");
	out.println("750="+rum750map.get(rumID[i])+"\n");
	out.println("375="+rum375map.get(rumID[i])+"\n");
	out.println("180="+rum180map.get(rumID[i])+"\n");
}

String whiskyID[]=request.getParameterValues("whi_brid");
HashMap<String,Integer> whi750map=new HashMap<String,Integer>();
HashMap<String,Integer> whi375map=new HashMap<String,Integer>();
HashMap<String,Integer> whi180map=new HashMap<String,Integer>();
for(int i=0;i<whiskyID.length;i++){
	whi750map.put(whiskyID[i], Integer.parseInt(request.getParameter("2_"+whiskyID[i]+"_750bot")));
	whi375map.put(whiskyID[i], Integer.parseInt(request.getParameter("2_"+whiskyID[i]+"_375bot")));
	whi180map.put(whiskyID[i], Integer.parseInt(request.getParameter("2_"+whiskyID[i]+"_180bot")));
}

out.println("whiskyyyy\n");
for(int i=0;i<whiskyID.length;i++){
	out.println(GetNamesByID.getWhiskyNameByID(whiskyID[i])+"\n");
	out.println("750="+whi750map.get(whiskyID[i])+"\n");
	out.println("375="+whi375map.get(whiskyID[i])+"\n");
	out.println("180="+whi180map.get(whiskyID[i])+"\n");
}

String brandyID[]=request.getParameterValues("bnd_brid");
HashMap<String,Integer> bnd750map=new HashMap<String,Integer>();
HashMap<String,Integer> bnd375map=new HashMap<String,Integer>();
HashMap<String,Integer> bnd180map=new HashMap<String,Integer>();
for(int i=0;i<brandyID.length;i++){
	bnd750map.put(brandyID[i], Integer.parseInt(request.getParameter("2_"+brandyID[i]+"_750bot")));
	bnd375map.put(brandyID[i], Integer.parseInt(request.getParameter("2_"+brandyID[i]+"_375bot")));
	bnd180map.put(brandyID[i], Integer.parseInt(request.getParameter("2_"+brandyID[i]+"_180bot")));
}

out.println("brandyyyyyy\n");
for(int i=0;i<brandyID.length;i++){
	out.println(GetNamesByID.getBrandyNameByID(whiskyID[i])+"\n");
	out.println("750="+bnd750map.get(brandyID[i])+"\n");
	out.println("375="+bnd375map.get(brandyID[i])+"\n");
	out.println("180="+bnd180map.get(brandyID[i])+"\n");
}

 */

%>


</body>
</html>