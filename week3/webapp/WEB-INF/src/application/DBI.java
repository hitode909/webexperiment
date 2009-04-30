package application;

import java.sql.*;
import java.util.ArrayList;

import model.Book;

// DBとやり取りして結果をinflateして返す
// SQL文を入れると処理してくれるようにするか、ORマッパみたいにするかは分からない
public class DBI {
	private Connection connection;

	public DBI(String dbi, String user, String pass) throws Exception {
		Class.forName("org.gjt.mm.mysql.Driver");
		connection = DriverManager.getConnection(dbi, user, pass);
	}
	
	// SQL文を実行してBookのArrayListを得る
	// FIXME: PreparedStatementを得るようにする
	public ArrayList<Book> getBooks(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		ArrayList<Book> result = new ArrayList<Book>();

		while(rs.next()){
			Book b = Book.parseResultSet(rs);
			result.add(b);
		}
		return result;
	}

	public ArrayList<Book> searchBooks(String query) throws SQLException {
		String sql = "select * from booklist where title like \"%" + query + "%\" or author like \"%" + query + "%\" or publisher like \"%" + query + "%\";";
		return getBooks(sql);
	}
	
	public Book retrieveBookById(Integer id) throws SQLException {
		PreparedStatement ps  = connection.prepareStatement("select * from booklist where id = ?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return Book.parseResultSet(rs);
	}
	
}
