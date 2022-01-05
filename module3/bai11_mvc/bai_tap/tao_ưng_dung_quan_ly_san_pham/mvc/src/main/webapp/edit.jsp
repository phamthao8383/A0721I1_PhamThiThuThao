
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h2>Edit product</h2>
<form action="/productServlet" method="post">
    <input type="hidden" name="action" value="edit"/>
    <label>Id</label><br>
    <input type="hidden" name="id" value="${product.id}"/><br>
    <label>Name</label><br>
    <input type="text" name="name" value="${product.name}"/><br>
    <label>Price</label><br>
    <input type="text" name="price" value="${product.price}"/><br>
    <label>Quantity</label><br>
    <input type="text" name="quantity" value="${product.quantity}"/><br>
    <label>Color</label><br>
    <input type="text" name="color" value="${product.color}"/><br>
    <label>Category</label><br>
    <input type="text" name="category" value="${product.category}"/><br>
    <input type="submit" value="Save" style="color:white;background: green" />
    <input type="reset" value="Back" style="color:white;background: black"/>

</form>
</body>
</html>
