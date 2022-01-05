<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/1/2022
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Product</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<button><a href="/productServlet?action=create&id=${product.id}" style="text-decoration: none">Add new product</a></button>
<input type="text" placeholder="Search.." name="search">
<button type="submit">Search</button>
<p style="color: green">${message} </p>

<h2>
    Product List
</h2>
<table>
    <tr>
        <th>#</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Category</th>
        <th colspan="2"> Action</th>
    </tr>

    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.color}</td>
            <td>${product.category}</td>
            <td><a href="/productServlet?action=edit&id=${product.id}">Edit</a></td>
            <td><a href="/productServlet?action=delete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
