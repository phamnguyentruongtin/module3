<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2/12/2022
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .back {
            text-decoration: none;
            color: black;
        }

        .back:hover {
            color: white;
        }

        .content {
            border: 1px solid black;
            width: 400px;
            padding-left: 50px;
            border-radius: 10px;
            box-shadow: 10px 10px 5px black;
            margin-left: 500px;
            font-size: 20px;
            height: 490px;
        }

        .click:hover {
            color: white;
            background-color: black;
            border-radius: 10px;
            cursor: pointer;
        }

        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
    </style>
</head>
<body>
<div class="content">
    <div>
        <h1>Add New Product</h1>
        <form action="/ServletProduct" method="post">
            <input type="hidden" name="action" value="create">
            <pre>Product Name   : <input type="text" name="nameCR"></pre>
            <pre>Price          : <input type="number" name="priceCR"> </pre>
            <pre>Quantity       : <input required type="number" name="quantityCR"></pre>
            <pre>Color          : <input required type="text" name="colorCR"></pre>
            <pre>Category       : <select name="categoryCR">
                                        <c:forEach items="${listCa}" var="l">
                                            <option value="${l.idCategory}">${l.nameCategory}</option>
                                        </c:forEach>
                                    </select></pre>
            <input class="click" style="font-size: 20px; width: 100px" type="submit" value="submit">

        </form>
    </div>

    <button class="click" style="font-size: 20px; width: 100px">
        <a class="back" href="/ServletProduct">Back </a>
    </button>
</div>

</body>
</html>
