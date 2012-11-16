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
		Properties props = PropUtil.getProperties();
		Set<Object> keySet = prop.keySet();
		for (Iterator it = keySet.iterator(); it.hasNext();) {
			String key = (String) it.next();
			out.println(key + "=" + props.getProperty(key) + "<br>");
		}
	%>
	
	
	
</body>
</html>