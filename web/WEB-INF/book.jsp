<%@ page import="model.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/12/2022
  Time: 1:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL BOOK</title>
</head>
<body>
<%

    List<Book> books = (List<Book>) request.getAttribute("book");

%>
<table border="1px">
    <tr>
        <th>id</th>
        <th>title</th>
        <th>description</th>
        <th>price</th>
        <th>author name end surname</th>
        <th>action</th>
    </tr>
    <% for (Book book : books) {
    %>
    <tr>
        <th><%=book.getId()%>
        </th>
        <th><%=book.getTitle()%>
        </th>
        <th><%=book.getDescription()%>
        </th>
        <th><%=book.getPrice()%>
        </th>
        <th><%=book.getAuthor().getName()%> <%=book.getAuthor().getSurname()%>
        </th>
        <th>
            <a href="/book/remove?bookId=<%=book.getId()%>">Remove</a> |
            <a href="/book/edit?bookId=<%=book.getId()%>">Edit</a>
        </th>
    </tr>
    <% }
    %>
</table>
</body>
</html>
