<%@ page
    contentType="text/html; charset=utf8"
    import="java.util.ArrayList,
            java.util.Iterator,
            application.*,
	    model.*"
%>
<% request.setCharacterEncoding("UTF-8");%> 
<html>
<head>
<title>JSP</title>

<body>
<h1>本サービス2.0</h1>

<jsp:include page="_searchform.jsp" flush="true" />

<h2>最近登録された本</h2>
<%
  Application app = new  Application();

  ArrayList<Book> books = app.books();
  out.println(app.tagg.bookTable(books));
%>
<h2>本を登録</h2>
あとで
</body>
</html>