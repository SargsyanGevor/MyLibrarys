<%@ page import="model.Author" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/12/2022
  Time: 1:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL AUTHOR</title>
</head>
<body>
<%

  List<Author> authors = (List<Author>) request.getAttribute("author");

%>
<table border="1px">
  <tr>
    <th>id</th>
    <th>name</th>
    <th>surname</th>
    <th>emil</th>
    <th>age</th>
    <th>action</th>
  </tr>
  <% for (Author author : authors) {
  %>
  <tr>
    <th><%=author.getId()%>
    </th>
    <th><%=author.getName()%>
    </th>
    <th><%=author.getSurname()%>
    </th>
    <th><%=author.getEmail()%>
    </th>
    <th><%=author.getAge()%>
    </th>

    <th>
      <a href="/author/remove?authorId=<%=author.getId()%>">Remove</a>
    </th>
  </tr>
  <% }
  %>
</table>
</body>
</html>
