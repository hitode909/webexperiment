<%@ page
    contentType="text/html; charset=utf8"
    import="java.util.ArrayList,
            application.*,
	    model.*"
%>
<% request.setCharacterEncoding("UTF-8");%> 
<%
  Application app = new  Application();
  String query = request.getParameter("query");
%>
<html>
<head>
<title>JSP</title>

<body>
<h1>
<% out.println(query); %>
で検索</h1>

<%
  ArrayList<Book> books = app.searchBooks(query);
  out.println(app.tagg.bookTable(books));
%>
</table>


</body>
</html>