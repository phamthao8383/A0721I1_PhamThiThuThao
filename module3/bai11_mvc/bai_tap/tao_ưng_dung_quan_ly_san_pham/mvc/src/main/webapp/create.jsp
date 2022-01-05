<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/1/2022
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<h2>Add new product</h2>
<form action="/productServlet" method="post">
    <input type="hidden" name="action" value="create"/>
    <label>Id</label><br>
    <input type="text" name="id"/><br>
    <label>Name</label><br>
    <input type="text" name="name"/><br>
    <label>Price</label><br>
    <input type="text" name="price"/><br>
    <label>Quantity</label><br>
    <input type="text" name="quantity"/><br>
    <label>Color</label><br><br>
    <input type="text" name="color"/><br>
    <label>Category</label><br>
    <input type="text" name="category"/><br>
    <input type="submit" value="Create" style="color:white;background: green" />
    <input type="reset" value="Back" style="color:white;background: black"/>

</form>

</body>
</html>
