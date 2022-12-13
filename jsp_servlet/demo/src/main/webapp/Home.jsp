<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2/12/2022
  Time: 8:44 PM
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
        .a:hover{
            color: red;
        }
    </style>
</head>
<body>
<H1 style="text-align: center">Product manager</H1>
<form action="/ServletProduct" method="post">
    <h6>Search product : </h6>
    <input name="idSearch" type="number">
    <input type="submit">
    <input type="hidden" name="action" value="search">
    <a class="a" style="text-decoration: none;border-radius: 15px;float: right" href="ServletProduct?action=create">Them San Pham</a>
</form>
<form action="/ServletProduct">
    <table class="table table-striped">
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="p">
            <tr>
                <td name="id">${p.idProduct}</td>
                <td>${p.productName}</td>
                <td>${p.price}</td>
                <td>${p.quantity}</td>
                <td>${p.color}</td>
                <td>${p.category.nameCategory}</td>
                <td><a href="/ServletProduct?action=edit&id=${p.idProduct}">Edit</a></td>
                <td><a href="/ServletProduct?action=remove&id=${p.idProduct}">Remove</a></td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" name="action" value="home">
</form>

</body>
</html>
