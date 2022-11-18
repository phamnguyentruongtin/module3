<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 16/11/2022
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/ProductServlet" method="get">
        <input type="number" name="price" placeholder="Enter your price:"/>
        <input type="number" name="percent" placeholder="Enter your percent:" />
        <input type="submit" value="caculate"/>
    </form>
    <table border="1">
    <tr>
        <th>Price product</th>
        <th>Percent product</th>
        <th>Discount product</th>
    </tr>
    <tr>
        <td>${price}</td>
        <td>${percent}</td>
        <td>${discount}</td>
    </tr>
    </table>
</body>
</html>
