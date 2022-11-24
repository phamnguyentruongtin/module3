<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 22/11/2022
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ban co muon xoa</h1>

<form action="/Product" method="post">
    <table style="border:1px solid black;">
        <tr>
            <th>Name</th>
            <td>${product.name}</td>
        </tr>
        <tr>
            <th>Id</th>
            <td name=idremove2>${product.id}</td>
        </tr>
        <tr>
            <th>Date</th>
            <td>${product.date}</td>
        </tr>
        <tr>
            <th>Producer</th>
            <td>${product.producer}</td>
        </tr>

    </table>
    <input type="submit" value="Xoa">
    <input type="hidden" name="action" value="delete2">
</form>
</body>
</html>
