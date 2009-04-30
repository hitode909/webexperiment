<%@ page
    contentType="text/html; charset=utf8"
    import="java.util.ArrayList,
            java.util.Iterator,
            application.*,
	    model.*"
%>
<% request.setCharacterEncoding("UTF-8");%> 
<%
  Application app = new  Application();
  String id = request.getParameter("id");
  Book book = app.dbi.retrieveBookById(Integer.parseInt(id));
%>

<html>
<head>
<title><% out.println(book.title); %></title>
<body>
<h1><% out.println(app.tagg.paragraph(book.title)); %></h1>
<% out.println(app.tagg.paragraph(book.author)); %>
<% out.println(app.tagg.paragraph(book.publisher)); %>
<% out.println(app.tagg.paragraph(book.price + "円")); %>
<% out.println(app.tagg.paragraph(book.isbn)); %>
</body>
</html>