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
    public ArrayList<Book> getBooks(PreparedStatement ps) throws SQLException {
	ResultSet rs = ps.executeQuery();
	ArrayList<Book> result = new ArrayList<Book>();

	while(rs.next()){
	    Book b = Book.parseResultSet(rs);
	    result.add(b);
	}
	return result;
    }
	
    public Book getBook(PreparedStatement ps) throws SQLException {
	ResultSet rs = ps.executeQuery();
	if(rs.next()){
	    return Book.parseResultSet(rs);
	}else{
	    return null;
	}
    }
	
    public ArrayList<Book> getAllBooks() throws SQLException {
	PreparedStatement ps  = connection.prepareStatement("select * from booklist");
	return getBooks(ps);
    }
	
    public ArrayList<Book> searchBooks(String query) throws SQLException {
	PreparedStatement ps  = connection.prepareStatement("select * from booklist where title like ? or author like ? or publisher like ?");
	String likequery = "%" + query + "%";
	ps.setString(1,likequery);
	ps.setString(2,likequery);
	ps.setString(3,likequery);
	return getBooks(ps);
    }
	
    public Book retrieveBookByIsbn(String isbn) throws SQLException {
	PreparedStatement ps  = connection.prepareStatement("select * from booklist where isbn = ?");
	ps.setString(1,isbn);
	return getBook(ps);
    }
	
    public Book retrieveBookById(Integer id) throws SQLException {
	PreparedStatement ps  = connection.prepareStatement("select * from booklist where id = ?");
	ps.setInt(1,id);
	return getBook(ps);
    }
	
    public Book createBook(String title, String author, String publisher, String price, String isbn) throws SQLException {
	if(title.length() == 0 || author.length() == 0 || publisher.length() == 0 || price.length() == 0 || isbn.length() == 0){
	    return null;
	}
	PreparedStatement ps  = connection.prepareStatement("insert into booklist values(null,?,?,?,?,?)");
	ps.setString(1, title);	
	ps.setString(2, author);	
	ps.setString(3, publisher);	
	ps.setString(4, price);
	ps.setString(5, isbn);
	int r = ps.executeUpdate();
	if(r>0){
	    return this.retrieveBookByIsbn(isbn);
	}else{
	    return null;
	}
    }

    public Book updateBook(Book target, String author, String publisher, String price, String isbn) throws SQLException {
	
    }
	
}
