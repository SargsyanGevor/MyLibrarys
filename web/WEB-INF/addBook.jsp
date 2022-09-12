<%@ page import="model.Author" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/12/2022
  Time: 1:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD BOOK</title>
</head>
<body>
<%

    List<Author> authors = (List<Author>) request.getAttribute("author");

%>

Please input Book data:
<form action="/book/add" method="post">
    <input type="text" name="title" placeholder="Please input title"/><br>
    <input type="text" name="description" placeholder="Please input description"/><br>
    <input type="number" name="price" placeholder="Please input price"/><br>
    <select name="authorId">
        <% for (Author author : authors) { %>
        <option value="<%=author.getId()%>"><%=author.getName()%> <%=author.getSurname()%> (<%=author.getEmail()%>)</option>
        <% } %>
    </select>

    <input type="submit" value="Register"/>

</form>
</body>
</html>
