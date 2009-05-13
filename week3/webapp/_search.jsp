<%@ page
    contentType="text/html; charset=utf8"
    import="java.util.ArrayList,
            application.*,
	    model.*"
%>

<%
  request.setCharacterEncoding("UTF-8");
  Application app = new  Application();
  ArrayList<Book> books;
  String query = request.getParameter("search");
  Boolean has_query = !(query == null || query.length() == 0);
  if( has_query ){
    books = app.dbi.searchBooks(query);
  }else{
    books = app.dbi.getAllBooks();
  }
%>

<form action="./" method="GET">
  <p><input type="text" name="search" size="30"
<% 
if( has_query ) {
   out.println("value=\"" + query + "\"");
}
%>
  /><input type="submit" value="検索"></p>
</form>

<% if( has_query ){
     if( books.size() > 0 ){
%>
<p>&quot;<% out.println(query); %>&quot;で検索して<% out.println(books.size()); %>件ヒットしました。</p>
<%
     out.println(app.tagg.bookTable(books));
   }else{ %>
<p>&quot;<% out.println(query); %>&quot;で検索してヒットしませんでした。</p>
<%   }
   } else {
     out.println(app.tagg.bookTable(books));
   }
 %>

</body>
</html>
