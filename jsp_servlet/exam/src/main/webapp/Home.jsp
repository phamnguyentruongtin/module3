<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2/12/2022
  Time: 5:49 PM
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
        a{
            text-decoration: none;
            color: darkred;
            float: right;
            width: 70px;
            height: 70px;
        }
        .a:hover{
            color: red;
        }
    </style>
</head>
<body>
 <h1 style="text-align: center;margin-bottom: 30px">Home</h1>
<form action="/Servlet?action=home">
    <table class="table table-striped">
        <tr>
            <th>STT</th>
            <th>Mã Bệnh Án</th>
            <th>Mã Bệnh Nhân</th>
            <th>Tên Bệnh Nhân</th>
            <th>Ngày Nhập Viện</th>
            <th>Ngày Ra Viện</th>
            <th>Ly Do Nhập Viện</th>
            <th>Tác Vụ</th>
            <th>Tác Vụ</th>
        </tr>
        <c:forEach items="${danhSachBenhAn}" var="ds" varStatus="vstatus">
            <tr>
                <td>${vstatus.count}</td>
                <td>${ds.getMaBenhAn()}</td>
                <td>${ds.getMaBenhNhan()}</td>
                <td>${ds.getTenBenhNhan()}</td>
                <td>${ds.getNgayVaoVien()}</td>
                <td>${ds.getNgayRaVien()}</td>
                <td>${ds.getLyDo().getLyDo()}</td>
                <td><a href="/Servlet?action=edit&maBenhAn=${ds.maBenhAn}">edit</a></td>
                <td><a href="/Servlet?action=remove&maBenhAn=${ds.maBenhAn}">delete</a></td>

            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
