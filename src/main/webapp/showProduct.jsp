<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 31/10/2022
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">Shoes</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Manager Account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Hello Alias</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Logout</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Login</a>
                </li>
            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="show">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">3</span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Siêu thị giày chất lượng cao</h1>
        <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm giày nhập từ Trung Quốc</p>
    </div>
</section>
<a type="button" class="btn btn-danger" href="/createproduct.jsp">Create</a>
<div class="container mt-3">
    <h2>Contextual Classes</h2>
    <p>Contextual classes can be used to color the table, table rows or table cells. The classes that can be used are: .table-primary, .table-success, .table-info, .table-warning, .table-danger, .table-active, .table-secondary, .table-light and .table-dark:</p>
    <table class="table">
        <tbody>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>IMG</th>
            <th>Price</th>
            <th>amountTotal</th>
            <th>detail</th>
        </tr>
        </tbody>
        <c:forEach items="${sanphams}" var="sp">
        <tr>
            <td>${sp.id_product}</td>
            <td>${sp.nameproduct}</td>
            <td><img src="${sp.img}" width="250" height="200"></td>
            <td>${sp.price}</td>
            <td>${sp.amountTotal}</td>
            <td>${sp.detail}</td>
            <td><a type="button" class="btn btn-warning" href="/edit?id=${sp.id_product}">Edit</a></td>
            <td><a type="button" class="btn btn-danger" href="/delete?id=${sp.id_product}">Delete</a></td>
        </tr>
        </c:forEach>
        <c:forEach items="${Categorys}" var="c">
            <tr>
                <td>${c.id_Category}</td>
                <td>${c.style}</td>
                <td>${c.categoryAmount}</td>
                <td><a href="/ProductCategoryServlet?idcategory=${c.id_Category}">Hehe</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>