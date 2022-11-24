<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 21/11/2022
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Product" method="post"><h1>Xoa San Pham</h1>
    <h3>Nhap Id de Xoa</h3>
    <input type="number" name="idremove">
    <input type="submit" value="Tim id de Xoa">
    <input type="hidden" name="action" value="delete1">
</form>

</body>
</html>
