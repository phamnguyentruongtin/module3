<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 30/11/2022
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Product" method="post">
    <h1>Cap Nhap</h1>
    <table border="1px">
        <tr>
            <th>
                ID
            </th>
            <td ><input type="number" name="idED"  value="${s.id}" readonly></td>
        </tr>
        <tr>
            <th>
                Name
            </th>
            <td><input type="text" name="nameED"  value="${s.name}"></td>
        </tr>
        <tr>
            <th>
                Amount
            </th>
            <td><input type="number" name="amountED"value="${s.amount}"></td>
        </tr>
        <tr>
            <th>
                Price
            </th>
            <td><input type="number" name="priceED" value="${s.price}"></td>
        </tr>
    </table>
    <input style="margin: 15px" type="submit" value="Update">
    <input type="hidden" name="action" value="edit2">
</form>
</body>
</html>
