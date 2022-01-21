<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/21/2022
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>Edit Customer</h2>
    <form action="/customer" method="post">
        <input type="hidden" name="action" value="edit"/>
        <input type="hidden" name="customerID" value="${customer.customerID}"/><br>
        <label>customerName</label><br>
        <input type="text" name="customerName" value="${customer.customerName}"/><br>
        <label>birthDay</label><br>
        <input type="text" name="birthDay" value="${customer.birthDay}"/><br>
        <label>Gender</label><br>
        <input type="text" name="gender" value="${customer.gender}"/><br>
        <label>IdCardPeople</label><br>
        <input type="text" name="idCardPeople" value="${customer.idCardPeople}"/><br>
        <label>PhoneNumber</label><br>
        <input type="text" name="phoneNumber" value="${customer.phoneNumber}"/><br>
        <label>Email</label><br>
        <input type="text" name="email" value="${customer.email}"/><br>
        <label>Address</label><br>
        <input type="text" name="address" value="${customer.address}"/><br>
        <label>Type_customerID</label><br>
        <input type="text" name="type_customerID" value="${customer.type_customerID}"/><br>
        <input type="submit" value="Save" style="color:white;background: green" />
        <input type="reset" value="Back" style="color:white;background: black"/>

    </form>
</center>
</body>
</html>
