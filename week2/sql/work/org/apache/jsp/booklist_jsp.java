package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class booklist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');

   Class.forName("org.gjt.mm.mysql.Driver");
   String uri = "jdbc:mysql://localhost/lab3?characterEncoding=utf8";

   Connection con = DriverManager.getConnection(uri, "nobody", "nobody");

   Statement stmt = con.createStatement();
   String sql = "select * from booklist";
   ResultSet rs = stmt.executeQuery(sql);

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <title>BookList</title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <h1>BookList</h1>\n");
      out.write("    <table>\n");
      out.write("    <tr>\n");
      out.write("      <th>著者</th><th>書名</th><th>出版社</th><th>価格</th><th>ISBN</th>\n");

   while(rs.next()){
    out.println("<tr>");
    out.println("<td>"+rs.getString("author")+"</td>");
    out.println("<td>"+rs.getString("title")+"</td>");
    out.println("<td>"+rs.getString("publisher")+"</td>");
    out.println("<td>"+rs.getInt("price")+"</td>");
    out.println("<td>"+rs.getString("isbn")+"</td>");
    out.println("</tr>");
   }

      out.write("\n");
      out.write("    </tr>\n");
      out.write("    </table>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
