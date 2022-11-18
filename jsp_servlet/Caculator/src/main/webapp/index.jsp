<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 18/11/2022
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/CaculatorServlet" method="get">
<h1>Caculator</h1>
  <input type="number" name="num1">
  <input type="number" name="num2">
  <select name="operator">
    <option>+</option>
    <option>-</option>
    <option>*</option>
    <option>/</option>
  </select>
  <input type="submit" value="tinh">
</form>

<h1>ket qua = ${ketqua}</h1>
</body>
</html>
