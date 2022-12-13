<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 29/11/2022
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
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
<body>
    <div class="content">
        <div>
            <h1>Add New Product</h1>
            <form action="/Product" method="post">
                <pre>ID Sản Phẩm    : <input required type="number" name="idCR"></pre>
                <pre>Tên Sản Phẩm   : <input id="std" required type="text" name="nameCR"> </pre>
                <pre>Số Lượng       : <input required type="number" name="amountCR"></pre>
                <pre>Đơn Giá        : <input required type="number" name="priceCR"></pre>
                <button class="click" style="font-size: 20px; width: 100px" type="submit">Create</button>
                <input type="hidden" name="action" value="create">
            </form>
        </div>

        <button class="click" style="font-size: 20px; width: 100px">
            <a class="back" href="/Product">Back </a>
        </button>
    </div>

</body>

</html>
