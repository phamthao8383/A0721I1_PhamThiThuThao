<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/29/2021
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Ứng dụng Product Discount Calculator</h2>
  <form method="post" action="/display-discount">
    <label> Product Description : </label><br>
    <input type="text" name="Product Description" placeholder="Enter your Product Description "/><br><br>
    <label> List Price : </label><br>
    <input type="text" name="List Price" placeholder="Enter your List Price  "/><br><br>
    <label>Discount Percent: </label><br>
    <input type="text" name="Discount Percent" placeholder="Enter your Discount Percent "/><br><br>
    <input type = "submit" id = "submit" value = "Calculate Discount"/>
  </form>
  </body>
</html>
