<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/12/2022
  Time: 12:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD AUTHOR</title>
</head>
<body>
PLEASE INPUT AUTHORS DATA:
<form action="/author/add" method="post">
    <input type="text" name="name" placeholder="Please input name"/><br>
    <input type="text" name="surname" placeholder="Please input surname"/><br>
    <input type="email" name="email" placeholder="Please input email"/><br>
    <input type="number" name="age" placeholder="Please input age"/><br>

    <input type="submit" value="Add"/>

</form>
</body>
</html>
