package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Iterator;
import application.*;
import model.*;

public final class book_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 request.setCharacterEncoding("UTF-8");
      out.write(' ');
      out.write('\n');

  Application app = new  Application();
  Book book;
  String id = request.getParameter("id");
  Boolean has_book = !(id == null || id.length() == 0);
  Boolean creating_book = false;

  if(has_book){
    book = app.dbi.retrieveBookById(Integer.parseInt(id));
    if(book == null){
      has_book = false;
    }
  } else {
    book = app.dbi.createBook(
      request.getParameter("title"),
      request.getParameter("author"),
      request.getParameter("publisher"),
      request.getParameter("price"),
      request.getParameter("isbn"));
    if(book != null){
      has_book = true;
    }
  }

      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_header.jsp" + (("_header.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("title", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf( book.title ), request.getCharacterEncoding()), out, true);
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"js/instantedit.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("setVarsForm(\"\");\n");
      out.write("var urlBase = \"update.jsp\";\n");
      out.write("</script> \n");
      out.write("\n");
 if(has_book){ 
      out.write("\n");
      out.write("<table border=\"1\" >\n");
      out.write("  <tr>\n");
      out.write("    <td>書名</td>\n");
      out.write("    <td>\n");
      out.write("      <span id=\"title\" class=\"editText\">");
 out.println(book.title); 
      out.write("</span>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>著者</td>\n");
      out.write("    <td>\n");
      out.write("      <span id=\"author\" class=\"editText\">");
 out.println(book.author); 
      out.write("</span>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>出版社</td>\n");
      out.write("    <td>\n");
      out.write("      <span id=\"publisher\" class=\"editText\">");
 out.println(book.publisher); 
      out.write("</span>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>価格</td>\n");
      out.write("    <td>\n");
      out.write("      <span id=\"price\" class=\"editText\">");
 out.println(book.price); 
      out.write("</span>円\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>ISBN</td>\n");
      out.write("    <td>\n");
      out.write("      <span id=\"isbn\" class=\"editText\">");
 out.println(book.isbn); 
      out.write("</span>\n");
      out.write("    </td>\n");
      out.write("  </tr>\n");
      out.write("</table>\n");
      out.write("\n");
 }else{
     if(creating_book){

      out.write("\n");
      out.write("<p>本の登録に失敗しました。各項目には必ず何か入力してください。</p>\n");
   }else{ 
      out.write("\n");
      out.write("<p>指定された本が見つかりませんでした。</p>\n");
   }
   }

      out.write('\n');
      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_footer.jsp", out, true);
      out.write('\n');
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
