<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 21/11/2022
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Product" method="post">
  <table>
    <tr>
      <th>Nhap Ten</th>
      <td><input type="text" name="nameedit" value="${product.name}"></td>
    </tr>
    <tr>
      <th>Nhap id</th>
      <td> <input type="number" name="id1" value="${product.id}"></td>
    </tr>
    <tr>
      <th>Nhap HSD</th>
      <td><input type="date" name="dateedit" value="${product.date}"></td>
    </tr>
    <tr>
      <th>Nhap Nha San Xuat</th>
      <td><input type="text" name="produceredit" value="${product.producer}"></td>
    </tr>
  </table>
  <input type="submit" value="cap nhap
">
  <input type="hidden" name="action" value="update">
</form>

</body>
</html>
