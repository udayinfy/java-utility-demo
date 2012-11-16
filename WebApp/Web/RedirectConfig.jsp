<%@page import="java.util.Properties"%>
<%@page import="util.PropUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirect Config</title>
</head>
<body>
	
	<%
		String propsProfile = PropUtil.printProperties("<br>");
		out.println(propsProfile);
	%>
	
	
	
</body>
</html>