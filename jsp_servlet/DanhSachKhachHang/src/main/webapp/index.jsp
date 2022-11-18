<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 17/11/2022
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    img{
        width: 100px;
        height: 100px;
    }
</style>
<body>
<h1>Danh Sách Khách Hàng</h1>
<table border="1">
    <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach items="${KhachHangList}" var="kh">
        <tr>
            <td>${kh.getName()}</td>
            <td>${kh.getDateOfbirth()}</td>
            <td>${kh.getAddress()}</td>
            <td>
                <img src="<c:url value="${kh.getImage()}"/>" />
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
