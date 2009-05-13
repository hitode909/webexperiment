<%@ page
    contentType="text/html; charset=utf8"
    import="application.*,
	    model.*"
%>
<%
request.setCharacterEncoding("UTF-8");
Application app = new  Application();
String title = request.getParameter("title");
%>

<html>
<head>
<title>
<% out.println(title + " - " + app.servicename()); %>
</title>

</head>
<body>
<% out.println(app.tagg.pinched("h1", title)); %>
