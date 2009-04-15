package exercise2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrentDateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -280795961719791281L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>練習課題２</h1>");
		Date currentDate = new Date();
		String currentDateString = currentDate.toString();
		writer.println(paragraph("現在時刻をお知らせします。"));
		writer.println(paragraph(currentDateString));
		writer.println("</body>");
		writer.println("</html>");
	}

	private String paragraph(String text) {
		// TODO Auto-generated method stub
		return "<p>" + text + "</p>";
	}
}
