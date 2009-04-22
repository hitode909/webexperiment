<%@ page contentType="text/html; charset=utf8" import="java.sql.*" %>
<%
   Class.forName("org.gjt.mm.mysql.Driver");
   String uri = "jdbc:mysql://localhost/lab3?characterEncoding=utf8";

   Connection con = DriverManager.getConnection(uri, "nobody", "nobody");

   Statement stmt = con.createStatement();
   String sql = "select * from booklist";
   ResultSet rs = stmt.executeQuery(sql);
%>

<html>
  <head>
    <title>BookList</title>
  </head>
  <body>
    <h1>BookList</h1>
    <table>
    <tr>
      <th>著者</th><th>書名</th><th>出版社</th><th>価格</th><th>ISBN</th>
<%
   while(rs.next()){
    out.println("<tr>");
    out.println("<td>"+rs.getString("author")+"</td>");
    out.println("<td>"+rs.getString("title")+"</td>");
    out.println("<td>"+rs.getString("publisher")+"</td>");
    out.println("<td>"+rs.getInt("price")+"</td>");
    out.println("<td>"+rs.getString("isbn")+"</td>");
    out.println("</tr>");
   }
%>
    </tr>
    </table>
  </body>
</html>
