package application;

import java.util.ArrayList;
import java.util.Iterator;

import model.Book;

public class TagGenerator {
	public String paragraph(String body){
		return this.pinched("p", body);
	}
	
	public String pinched(String tag, String body){
		return "<"+tag+">"+body+"</"+tag+">";
	}
	
	public String pinchedWithOption(String tag, String option, String body){
		return "<"+tag+" " + option + " >"+body+"</"+tag+">";
	}

	private String bookTableTr(Book book){
		String result = new String();
		result += pinched("td", pinchedWithOption("a", "href=book.jsp?id="+book.id, book.title));
		result += pinched("td", pinchedWithOption("a", "href=search.jsp?query="+book.author, book.author));
		result += pinched("td", pinchedWithOption("a", "href=search.jsp?query="+book.publisher, book.publisher));
		//result += ;
		return pinched("tr", result) + "\n";
	}
	private String bookTableTh(){
		String result = new String();
		result += pinched("th", "書名");
		result += pinched("th", "著者");
		result += pinched("th", "出版社");
		return pinched("tr", result) + "\n";
	}
	
	public String bookTable(ArrayList<Book> books){
		String result = new String();
		result += bookTableTh();
		Iterator<Book> it = books.iterator();
		while(it.hasNext()){
			Book b = it.next();
		    result += bookTableTr(b);
		}
		return pinched("table", result);
		
	}
}
