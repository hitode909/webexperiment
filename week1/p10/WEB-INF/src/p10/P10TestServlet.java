package p10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class P10TestServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7710947349206540268L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>Servletのテスト</h1>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
