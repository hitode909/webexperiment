package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import application.*;
import model.*;

public final class _005fsearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');

  request.setCharacterEncoding("UTF-8");
  Application app = new  Application();
  ArrayList<Book> books;
  String query = request.getParameter("search");
  Boolean has_query = !(query == null || query.length() == 0);
  if( has_query ){
    books = app.dbi.searchBooks(query);
  }else{
    books = app.dbi.getAllBooks();
  }

      out.write("\n");
      out.write("\n");
      out.write("<form action=\"./\" method=\"GET\">\n");
      out.write("  <p><input type=\"text\" name=\"search\" size=\"30\"\n");
 
if( has_query ) {
   out.println("value=\"" + query + "\"");
}

      out.write("\n");
      out.write("  /><input type=\"submit\" value=\"検索\"></p>\n");
      out.write("</form>\n");
      out.write("\n");
 if( has_query ){
     if( books.size() > 0 ){

      out.write("\n");
      out.write("<p>&quot;");
 out.println(query); 
      out.write("&quot;で検索して");
 out.println(books.size()); 
      out.write("件ヒットしました。</p>\n");

     out.println(app.tagg.bookTable(books));
   }else{ 
      out.write("\n");
      out.write("<p>&quot;");
 out.println(query); 
      out.write("&quot;で検索してヒットしませんでした。</p>\n");
   }
   } else {
     out.println(app.tagg.bookTable(books));
   }
 
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
