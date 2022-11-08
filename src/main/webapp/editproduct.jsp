<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 31/10/2022
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/edit" method="post">
    <table>
        <tr>
            <td>Nhập id</td>
            <td><input name="id" placeholder="Nhập id" value="${p.id}"></td>
        </tr>
        <tr>
            <td>Nhập Name </td>
            <td><input name="name" placeholder="Nhập name" value="${p.name}"></td>
        </tr>
        <tr>
            <td>Nhập img</td>
            <td><input name="img" placeholder="Nhập img" value="${p.img}"></td>
        </tr>
        <tr>
            <td>Nhập price</td>
            <td><input name="price" placeholder="Nhập price"value="${p.price}"></td>
        </tr>>
        <tr>
            <td></td>
        </tr>


    </table>
    <button type="submit">Submit</button>
</form>

</body>
</html>
