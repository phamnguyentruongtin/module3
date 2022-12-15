<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<h1>Them Moi</h1>
<form action="/ExServlet?action=create" method="post">
    <table class="table table-striped">
        <tr>
            <th>Ten Chu Phong</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>So Dien Thoai</th>
            <td><input type="number" name="sdt"></td>
        </tr>
        <tr>
            <th>Ngay Bat Dau Thue</th>
            <td><input type="date" name="ngay"></td>
        </tr>
        <tr>
            <th>
                Hinh thuc thanh Toan
            </th>

                <td>
                <select name="kieuThue">
                    <c:forEach items="${dsKieuThue}" var="ds">
                    <option value="${ds.getId_kieuThue()}">${ds.getKieuThue()}</option>
                    </c:forEach>
                </select>
                </td>
        </tr>
        <tr>
            <th>Ghi Chu</th>
            <td><input type="text" name="ghiChu"></td>
        </tr>

    </table>
    <input type="submit" value="Dang Ki!!!">
    <input type="reset">
</form>

</body>
</html>
