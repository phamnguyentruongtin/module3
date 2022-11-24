<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 18/11/2022
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Product" method="post">
    <h2>Dang Ki San Pham</h2>
    <table border="10px" style="margin-bottom: 30px">
        <tr>
            <th>Nhap Ten</th>
            <td> <input type="text" name="name1"></td>
        </tr>
        <tr>
            <th>Nhap id</th>
           <td><input type="number" name="id1"></td>
        </tr>
        <tr>
            <th>Nhap HSD</th>
           <td><input type="date" name="date1"></td>
        </tr>
        <tr>
            <th>Nhap Nha San Xuat</th>
           <td> <input type="text" name="producer1"></td>
        </tr>
    </table>
        <input style="border-radius: 5px;padding: 10px 20px ;margin-left: 120px " type="submit" value="Dang Ki">
        <input type="hidden" name="action" value="create">
</form>

</body>
</html>
