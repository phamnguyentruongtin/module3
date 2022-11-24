<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 19/11/2022
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <form action="/Product" method="post"><h1>Cap Nhap Thong Tin</h1>
        <h3>nhap id cua san pham can cap nhap</h3>
        <input type="number" name="idedit">
        <input type="submit" value="Tim id de cap nhap">
        <input type="hidden" name="action" value="update1">
    </form>

</head>
<body>
</body>
</html>
