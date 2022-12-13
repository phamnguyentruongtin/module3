<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--

  Created by IntelliJ IDEA.
  User: LEGION
  Date: 30/11/2022
  Time: 6:54 PM
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
</head>
<body>
<form>
    <h1>Kết Quả Tìm Thấy Được</h1>
    <table border="10px" class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>AMOUNT</th>
            <th>PRICE</th>
            <th></th>
        </tr>
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.amount}</td>
            <td>${s.price}</td>

        </tr>
    </table>

</form>
</body>
</html>
