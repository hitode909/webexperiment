package application;
import java.sql.*;
import java.util.ArrayList;


import model.Book;

//JSPが使うためのインターフェイス
public class Application {
	public TagGenerator tagg;
	public DBI dbi;

	public Application() throws Exception {
		this.tagg = new TagGenerator();
		this.dbi = new DBI("jdbc:mysql://localhost/lab3?characterEncoding=utf8", "nobody", "nobody");
	}
		
	public ArrayList<Book> books() throws SQLException {
		return dbi.getBooks("select * from booklist");
	}
	
	public ArrayList<Book> searchBooks(String query) throws SQLException {
		return dbi.searchBooks(query);
	}
		
}
