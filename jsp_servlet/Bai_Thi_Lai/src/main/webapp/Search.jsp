<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 9/12/2022
  Time: 11:27 PM
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
            width: 70px;
            height: 70px;
        }

        .a:hover {
            color: red;
        }
    </style>
</head>
<body>
<form action="/ExServlet">
    <h1>Ket Qua</h1>
    <c:if test="${pt.getTenNguoiThue()!=null}">
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
            <tr>
                <td>${pt.getMaThue()}</td>
                <td>${pt.getTenNguoiThue()}</td>
                <td>${pt.getSdt()}</td>
                <td>${pt.getNgayBatDau()}</td>
                <td>${pt.getKieuThue().getKieuThue()}</td>
                <td>${pt.getGhiChu()}</td>
                <td><a href="/ExServlet?action=remove&id=${pt.getMaThue()}">delete</a></td>
            </tr>
        </table>
    </c:if>
    <h6>${mess}</h6>
</form>
</body>
</html>
