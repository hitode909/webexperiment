<%@ page
    contentType="text/html; charset=utf8"
    import="java.util.ArrayList,
            java.util.Iterator,
            application.*,
	    model.*"
%>

<%
request.setCharacterEncoding("UTF-8");
Application app = new  Application();
Boolean has_search_query = (request.getParameter("search") != null);
%>

<% if(has_search_query){ %>
  <jsp:include page="_header.jsp" flush="true" >
  <jsp:param name="title" value="本を検索中" />
  </jsp:include>
<% }else{ %>
  <jsp:include page="_header.jsp" flush="true" >
  <jsp:param name="title" value="こんにちは" />
  </jsp:include>
<% } %>

<jsp:include page="_search.jsp" flush="true" />

<% if(!has_search_query){ %>
<jsp:include page="_newbook.jsp" flush="true" />
<% } %>

<jsp:include page="_footer.jsp" flush="true" />
