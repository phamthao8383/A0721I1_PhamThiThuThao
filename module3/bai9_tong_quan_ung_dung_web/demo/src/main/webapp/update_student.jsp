<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/30/2021
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
<p>Name :</p>
<input type="text" name="name" value="${student.name}">
<p>Grade :</p>
<input type="text" name="grade" value="${student.grade}">
<button type="submit"> Update </button>
</form>
</body>
</html>
