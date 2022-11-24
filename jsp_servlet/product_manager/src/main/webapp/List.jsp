<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 18/11/2022
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sach San Pham</title>
</head>
<body>
<h1>Danh Sach San Pham</h1>
<table border="10px" style="margin-bottom: 30px">
    <tr>
        <th>Ten San Pham</th>
        <th>ID San Pham</th>
        <th>Han Su Dung</th>
        <th>Nha San Xuat</th>
    </tr>
    <c:forEach items="${productList}" var="pl">
        <tr>
            <td>${pl.name}</td>
            <td>${pl.id}</td>
            <td>${pl.date}</td>
            <td>${pl.producer}</td>
        </tr>
    </c:forEach>
</table>
<a style="border: 1px solid black;text-decoration: none;padding: 10px 20px;margin-top: 10px;border-radius:5px"
   href="create.jsp">Them San Pham</a>
<a
        style="border: 1px solid black;text-decoration: none;padding: 10px 20px;margin-top: 10px;border-radius:5px"
        href="remove.jsp">Xoa san Pham</a>
<a
        style="border: 1px solid black;text-decoration: none;padding: 10px 20px;margin-top: 10px;border-radius:5px"
        href="update.jsp">Cap Nhap san pham</a>
</body>
</html>
