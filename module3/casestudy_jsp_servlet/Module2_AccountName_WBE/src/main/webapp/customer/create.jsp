<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/21/2022
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Create Customer</title>
</head>
<body>
<center>
<h2>Add new Customer</h2>
<form action="/customer" method="post">
    <input type="hidden" name="action" value="create">
    <label>CustomerName</label><br>
    <input type="text" name="customerName"><br>
    <label>birthDay</label><br>
    <input type="text" name="birthDay"><br>
    <label>gender</label><br>
    <input type="text" name="gender"><br>
    <label>idCardPeople</label><br>
    <input type="text" name="idCardPeople"><br>
    <label>phoneNumber</label><br>
    <input type="text" name="phoneNumber"><br>
    <label>email</label><br>
    <input type="text" name="email"><br>
    <label>address</label><br>
    <input type="text" name="address"><br>
    <label>type_customerID</label><br>
    <input type="text" name="type_customerID"><br>
    <input type="submit" value="Create" style="color:white;background: green"/>
    <input type="reset" value="Back" style="color:white;background: black"/>

</form>
</center>
</body>
</html>
