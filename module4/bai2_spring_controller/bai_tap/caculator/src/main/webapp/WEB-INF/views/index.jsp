<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/18/2022
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Caculator</title>
  </head>
  <body>
  <form action="/index" method="post">
  <table>
    <tr>
      <th>Caculator</th>
    </tr>
    <tr>
      <td> <input type="number"name="input1" id="input1" value="${input1}"></td>
      <td><input type="number" name="input2"id="input2" value="${input2}"></td>
    </tr>
    <tr>
      <td><input type="submit" value="Addition(+)" name="choose"></td>
      <td><input type="submit" value="Subtraction(-)" name="choose"></td>
      <td><input type="submit" value="Multiplication(*)" name="choose"></td>
      <td><input type="submit" value="Division(/)" name="choose"></td>
    </tr>
    <tr>
      <td>
        <h2>Result ${choose}:  ${result}</h2>
        </p>
      </td>
    </tr>
  </table>
  </form>
  </body>
</html>
