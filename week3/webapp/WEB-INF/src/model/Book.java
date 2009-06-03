package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
  out.println("<tr>");
  out.println("<td>"+rs.getString("author")+"</td>");
  out.println("<td>"+rs.getString("title")+"</td>");
  out.println("<td>"+rs.getString("publisher")+"</td>");
  out.println("<td>"+rs.getInt("price")+"</td>");
  out.println("<td>"+rs.getString("isbn")+"</td>");
*/



public class Book {
    public String author, title, publisher, isbn;
    public Integer id, price;

    public static Book parseResultSet(ResultSet rs) throws SQLException {
        Book b = new Book();
        b.id = rs.getInt("id");
        b.author = rs.getString("author");
        b.title = rs.getString("title");
        b.publisher = rs.getString("publisher");
        b.isbn = rs.getString("isbn");
        b.price = rs.getInt("price");
        return b;
    }

    public String getValueByField(String field){
        if (field.equals("author")) {
            return this.author;
        }
        if (field.equals("title")) {
            return this.title;
        }
        if (field.equals("publisher")) {
            return this.publisher;
        }
        if (field.equals("isbn")) {
            return this.isbn;
        }

        if (field.equals("id")) {
            return this.id.toString();
        }

        if (field.equals("price")) {
            return this.price.toString();
        }
        return null;
    }
}
