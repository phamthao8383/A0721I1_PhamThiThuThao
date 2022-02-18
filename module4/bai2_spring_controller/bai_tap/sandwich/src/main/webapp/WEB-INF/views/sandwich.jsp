<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/17/2022
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>List Sandwich</h3>
<p><c:forEach items="${choose}" var="list">
    ${list}
</c:forEach></p>
</body>
</html>
