<%@ page
    contentType="text/html; charset=utf8"
    import="java.util.ArrayList,
            java.util.Iterator,
            application.*,
	    model.*"
%>
<% request.setCharacterEncoding("UTF-8");%> 
<%
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
%>

<jsp:include page="_header.jsp" flush="true" >
  <jsp:param name="title" value="本の詳細" />
</jsp:include>

<% if(has_book){ %>
<table border="1" >
<tr>
  <td>書名</td>
  <td><% out.println(book.title); %></td>
</tr>
<tr>
  <td>著者</td>
  <td><% out.println(book.author); %></td>
</tr>
<tr>
  <td>出版社</td>
  <td><% out.println(app.tagg.searchlink(book.publisher)); %></td>
</tr>
<tr>
  <td>価格</td>
  <td><% out.println(book.price); %>円</td>
</tr>
<tr>
  <td>ISBN</td>
  <td><% out.println(book.isbn); %></td>
</tr>
</table>

<% }else{
     if(creating_book){
%>
<p>本の登録に失敗しました。各項目には必ず何か入力してください。</p>
<%   }else{ %>
<p>指定された本が見つかりませんでした。</p>
<%   }
   }
%>


<jsp:include page="_footer.jsp" flush="true" />
