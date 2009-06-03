<%@ page
    contentType="text/html; charset=utf8"
    import="java.util.ArrayList,
            java.util.Iterator,
            application.*,
	    model.*"
%><%
request.setCharacterEncoding("UTF-8");
Application app = new  Application();

//request: bookid=hoge
Integer bookid =  Integer.parseInt(request.getParameter("bookid"));
Book book = app.dbi.retrieveBookById(bookid);
String result;
if (book != null) {
    try {
        app.dbi.deleteBook(book);
        result = "deleted";
    } catch (java.sql.SQLException e) {
        result = "SQLException";
    }
}else{
    result = "book not found";
}
out.println(result);
%>