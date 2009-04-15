<%@ page contentType="text/html; charset=utf8" import="java.util.Date" %>
<html>
<head>
<title>Current Date by JSP</title>

<body>
<h1>練習課題３</h1>
<p>
<%
  Date currentDate = new Date();
  String currentDateString = currentDate.toString();
  out.println("こんにちは、現在時刻は" + currentDateString + "です。");
%>
</p>
</body>
</html>