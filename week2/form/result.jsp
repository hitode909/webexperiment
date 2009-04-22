<%@ page contentType="text/html; charset=utf8" %>
<% request.setCharacterEncoding("UTF-8");%> 
<html>
  <head>
    <title>個人情報</title>
  </head>
  <body>
    <h1>個人情報を受信しました</h1>
    <p>名前:<% out.println(request.getParameter("name")); %></p>
    <p>住所:<% out.println(request.getParameter("address")); %></p>
  </body>
</html>
