<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/20/2022
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Customer List</h1>
    <h2>
        <a href="/customer?action=create">Add New Product</a>
        <%--        <a href="/users?action=sort">Sort User</a>--%>
        <%--        <input type="text" name="country" id="country" size="15"/>--%>
        <%--        <a href="/users?action=search">Search</a>--%>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>customerID</th>
            <th>customerName</th>
            <th>birthDay</th>
            <th>gender</th>
            <th>idCardPeople</th>
            <th>phoneNumber</th>
            <th>email</th>
            <th>address</th>
            <th>type_customerID</th>
            <th colspan="2">Actions</th>
        </tr>
        <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td><c:out value="${customer.customerID}"/></td>
                <td><c:out value="${customer.customerName}"/></td>
                <td><c:out value="${customer.birthDay}"/></td>
                <td><c:out value="${customer.gender}"/></td>
                <td><c:out value="${customer.idCardPeople}"/></td>
                <td><c:out value="${customer.phoneNumber}"/></td>
                <td><c:out value="${customer.email}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td><c:out value="${customer.type_customerID}"/></td>
                <td>
                    <a href="/customer?action=edit&customerID=${customer.customerID}">Edit</a>
                    <a href="/customer?action=delete&customerID=${customer.customerID}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
