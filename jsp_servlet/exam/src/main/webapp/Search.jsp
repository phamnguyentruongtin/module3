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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center;margin-bottom: 30px">Result</h1>
<form action="/Servlet">
    <table class="table table-striped">
        <tr>
            <th></th>
            <th></th>
        </tr>

        <tr>
            <td>${}</td>
            <td><a href="/Servlet?action=edit&id=${}">edit</a></td>
            <td><a href="/Servlet?action=remove&id=${}">delete</a></td>
        </tr>
    </table>
</form>

</body>
</html>
