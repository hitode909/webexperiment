<%@ page
    contentType="text/html; charset=utf8"
%>

<h2>本を検索</h2>
<form action="./search.jsp" method="GET">
  <p><input type="text" name="query" size="30"
<% 
if( request.getParameter("query") != null ) {
   out.println("value=\"" + request.getParameter("query") + "\"");
}
%>
  /><input type="submit" value="検索"></p>
</form>
