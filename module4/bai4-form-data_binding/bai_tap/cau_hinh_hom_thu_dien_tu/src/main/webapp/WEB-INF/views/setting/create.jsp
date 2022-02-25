<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/19/2022
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<%--@elvariable id="setting" type=""--%>
<form:form method="POST" action="addSetting" modelAttribute="setting">
    <table>
        <tr>
            <td><form:label path="languages">Languages </form:label></td>
            <td><form:select path="languages">
                <form:option value="English">
                </form:option>
                <form:option value="Vietnamese">
                </form:option>
                <form:option value="Japanese">
                </form:option>
                <form:option value="Chinese">
                </form:option>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="size">size </form:label></td>
            <td><form:select path="size">
                <form:option value="5" ></form:option>
                <form:option value="10"></form:option>
                <form:option value="25"></form:option>
                <form:option value="50"></form:option>
                <form:option value="100"></form:option>
            </form:select>
            </td>
            <td>emails per page</td>
        </tr>
        <tr>
            <td><form:label path="spams">spams </form:label></td>
            <td><form:checkbox path="spams"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">signature </form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"/></td>
            <td><input type="submit" value="Cancel"/></td>
        </tr>
    </table>

</form:form>

</body>
</html>
