<%@ page import="model.Book" %>
<%@ page import="model.Author" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/12/2022
  Time: 3:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EDIT BOOK</title>
</head>
<body>
<%

    Book book = (Book) request.getAttribute("book");

    List<Author> authors = (List<Author>) request.getAttribute("author");

%>

Please update book data:
<form action="/book/edit" method="post">
    <input type="hidden" name="bookId" value="<%=book.getId()%>">
    <input type="text" name="title" value="<%=book.getTitle()%>"/><br>
    <input type="text" name="description" value="<%=book.getDescription()%>"/><br>
    <input type="number" name="price" value="<%=book.getPrice()%>"/><br>
    <select name="authorId">
        <% for (Author author : authors) {
        %>if (author.equals(book.getAuthor())) {

        <option selected value="<%=author.getId()%>"> <%=author.getName()%> <%=author.getSurname()%> (<%=author.getEmail()%>)
        </option>
        } else {
        <option value="<%=author.getId()%>"> <%=author.getName()%> <%=author.getSurname()%> (<%=author.getEmail()%>)
        </option>

        }<%
        } %>
    </select>

    <input type="submit" value="Update"/>

</form>
</body>
</html>
