<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/31/2021
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<table style="width: 500px" border="1">
    <tr>
        <th>Name</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Anh</th>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.name}</td>
            <td> ${product.dateOfBirth}</td>
            <td>${product.address}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
