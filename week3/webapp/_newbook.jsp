<%@ page
    contentType="text/html; charset=utf8"
%>

<h2>本を登録</h2>
<form action="./book.jsp" method="GET">
  <table>
    <tr>
      <td>書名</td>
      <td><input type="text" name="title" size="30"></td>
    </tr>
    <tr>
      <td>著者</td>
      <td><input type="text" name="author" size="30"></td>
    </tr>
    <tr>
      <td>出版社</td>
      <td><input type="text" name="publisher" size="30"></td>
    </tr>
    <tr>
      <td>価格</td>
      <td><input type="text" name="price" size="30"></td>
    </tr>
    <tr>
      <td>ISBN</td>
      <td><input type="text" name="isbn" size="30"></td>
    </tr>
    <tr><td>
	<input type="submit" value="登録">
    </td></tr>
  </table>
</form>
