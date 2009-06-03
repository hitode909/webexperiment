<%@ page
    contentType="text/html; charset=utf8"
    import="java.util.ArrayList,
            java.util.Iterator,
            application.*,
	    model.*"
%>

<%
request.setCharacterEncoding("UTF-8");
Application app = new  Application();



//request: update.jsp?fieldname=author&content=jenny&bookid=10
Integer bookid =  Integer.parseInt(request.getParameter("bookid"));
Book book = app.dbi.retrieveBookById(bookid);
String result;
if (book != null) {
    String fieldname = request.getParameter("fieldname");
    String content = request.getParameter("content");
    try {
        Book newbook = app.dbi.updateBook(book, fieldname, content);
        result = newbook.getValueByField(fieldname);
    } catch (java.sql.SQLException e) {
        result = "SQLException";
    }
}else{
    result = "undefined book";
}
out.println(result);

%>
