<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 28/11/2022
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
    <style>
        .bcc{
            text-decoration: none;
            border-radius: 10px;

        }
        .bcc:hover{
            color: white;
            background-color: cornflowerblue;
        }
        .add {
            float: right;
            color: blue;
            text-decoration: none;
            padding: 20px;
            border: 1px solid cornflowerblue;
            border-radius: 10px;
            margin-left: 5px;
            margin-bottom: 30px;
        }
        .add:hover {
            color: white;
            background-color: cornflowerblue;
        }
        .ccc:hover{
            color: white;
            background-color: cornflowerblue;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;">Quản Lí Seafood</h1>
<form action="/Product" method="post">
    <h3 style="margin: 10px">Tim Kiem</h3>
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" id="">ID Sản Phẩm</span>
        </div>
        <input required type="number" name="idSearch">
        <input class="ccc" size="1px" type="submit" value="Tìm Kiếm">
    </div>
    <input type="hidden" name="action" value="search">
    <a class="add" href="Create.jsp">Them San Pham</a>
</form>

<form action="/Product">
    <table  class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>AMOUNT</th>
            <th>PRICE</th>
            <th>Settings</th>
            <th>Settings</th>
        </tr>
        <c:forEach items="${list}" var="l">
            <tr>
                <td name="id">${l.id}</td>
                <td>${l.name}</td>
                <td>${l.amount}</td>
                <td>${l.price}</td>
                <td class="bcc"><a href="/Product?action=edit&id=${l.id}">edit</a></td>
                <td class="bcc"><a href="/Product?action=remove&id=${l.id}">remove</a></td>
            </tr>
        </c:forEach>
        </table>
    <input type="hidden" name="action" value="list">
</form>
</body>
</html>
