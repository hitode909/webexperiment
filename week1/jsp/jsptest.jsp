<%@ page contentType="text/html; charset=utf8" %>
<html>
<head>
<title> JSP Test</title>

<body>
<h1>JSP Test</h1>
<br>
<%
  String message = "これはJSPのテストです。";
  out.println(message);
%>
</body>
</html>