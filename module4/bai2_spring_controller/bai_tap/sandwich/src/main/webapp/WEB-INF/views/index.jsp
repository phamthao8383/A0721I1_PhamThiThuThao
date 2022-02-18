<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/17/2022
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <center>
  <form method="post" action="sandwich">
    <table>
      <tr>
        <th>Sandwich Condiments</th>
      </tr>
      <tr>
        <td><input type="checkbox" name="choose" value="Lettuce">Lettuce</td>
        <td><input type="checkbox" name="choose" value="Tomato">Tomato</td>
        <td><input type="checkbox" name="choose" value="Mustard">Mustard</td>
        <td><input type="checkbox" name="choose" value="Sprouts">Sprouts</td>
      </tr>
      <hr/>
      <tr>
        <td><input type="submit" value="save"></td>
      </tr>
    </table>
  </form>
  </center>
  </body>
</html>
