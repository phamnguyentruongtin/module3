<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2/12/2022
  Time: 5:50 PM
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
<h1 style="text-align: center;margin-bottom: 30px">EDIT</h1>
<form action="/Servlet?action=edit" method="post">
    <table class="table table-striped">
        <tr>
            <th>
                STT
            </th>
            <td><input readonly type="number" name="stt" value="${benhAn.getSTT()}"></td>
        </tr>
        <tr>
            <th>
                Mã Bệnh Án
            </th>
            <td><input readonly type="text" name="maBenhAn" value="${benhAn.getMaBenhAn()}"></td>
        </tr>
        <tr>
            <th>
                Mã Bệnh Nhân
            </th>
            <td>
                <input readonly type="text" name="maBenhNhan" value="${benhAn.maBenhNhan}">
            </td>
        </tr>
        <tr>
            <th>
                Tên Bệnh Nhân
            </th>
            <td>
                <input type="text" name="tenBenhNhan" value="${benhAn.getTenBenhNhan()}">
            </td>
        </tr>
        <tr>
            <th>
                Ngày Nhập Viện
            </th>
            <td>
                <input type="date" name="ngayNhapVien" value="${benhAn.getNgayVaoVien()}">
            </td>
        </tr>
        <tr>
            <th>
                Ngày Ra Viện
            </th>
            <td>
                <input type="date" name="ngayRaVien" value="${benhAn.ngayRaVien}">
            </td>
        </tr>
        <tr>
            <th>
                Ly Do Nhập Viện
            </th>
            <td>
                <select name="lydo">
                        <option value="${benhAn.lyDo.getIdLyDo()}">${benhAn.lyDo.getLyDo()}</option>
                </select>

            </td>
        </tr>
    </table>
    <input type="submit" value="edit">
    <input type="reset" value="Reset">
</form>

</body>
</html>
