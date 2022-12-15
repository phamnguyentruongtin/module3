<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 9/12/2022
  Time: 11:26 PM
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
        a {
            text-decoration: none;
            color: darkred;
            float: right;
            height: 70px;
        }

        .a:hover {
            color: red;
        }
        .add {
            float: right;
            color: blue;
            text-decoration: none;
            padding: 20px;
            border: 1px solid cornflowerblue;
            border-radius: 10px;
            margin-left: 5px;
            margin-bottom: 30px;
            display: inline;
        }
        .add:hover {
            color: white;
            background-color: cornflowerblue;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">HOME</h1>
<form action="/ExServlet?action=search" method="post" style="margin-top: 30px">
    <input type="text" style="margin-left: 15px;display: inline" name="nameS">
    <input type="submit" value="Tim kiem">
    <p style="color: red;padding: 10px 10px 10px 15px">${mess}</p>
    <a class="add" href="/ExServlet?action=create">+ Them San Pham</a>
</form>
<form action="/ExServlet?action=home">
    <table class="table table-striped">
        <tr>
            <th>Ma Phong Tro</th>
            <th>Ten Nguoi Thue Tro</th>
            <th>So Dien Thoai</th>
            <th>Ngay Bat Dau Thue</th>
            <th>Hinh Thuc Thanh Toan</th>
            <th>Ghi Chu</th>
            <th>Action</th>
        </tr>
        <C:forEach items="${dsPhong}" var="pt" varStatus="vstatus">
            <tr>
                <td>${pt.getMaThue()}</td>
                <td>${pt.getTenNguoiThue()}</td>
                <td>${pt.getSdt()}</td>
                <td>${pt.getNgayBatDau()}</td>
                <td>${pt.getKieuThue().getKieuThue()}</td>
                <td>${pt.getGhiChu()}</td>
                <td><a href="/ExServlet?action=remove&id=${pt.getMaThue()}">delete</a></td>
            </tr>
        </C:forEach>
    </table>
</form>
</body>
</html>
