<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Dictionary</title>
</head>
<body>
<center>
  <h1>Dictionary</h1>
  <form method="post" action="/index">
    <fieldset>
      <legend>Dictionary information</legend>
      <table>
        <tr>
          <td>English word:</td>
          <td><input type="text" name="word" id="word"></td>
        </tr>
        <tr>
          <td><input type="submit" value="dictionary"></td>
        </tr>
      </table>
    </fieldset>
  </form>
</center>
</body>
</html>