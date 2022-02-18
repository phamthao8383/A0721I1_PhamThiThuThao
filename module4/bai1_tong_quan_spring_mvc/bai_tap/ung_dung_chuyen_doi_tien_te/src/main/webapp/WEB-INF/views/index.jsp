<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body{
        width: 500px;
        text-align: center;
        margin: auto;
    }
    table{
        width: 300px;
        height: 50px;
    }
</style>
<head>
    <title>Currency Conversion</title>
</head>
<body>
<h1>Currency Conversion</h1>
<form action="/convert">
    <fieldset>
        <legend>Currency Conversion</legend>
        <table>
            <tr>
                <td>USD:</td>
                <td><input name="usd" placeholder="Enter USD" value="0"></td>
            </tr>
            <tr>
                <td>Rate:</td>
                <td><input name="rate" placeholder="Enter rate" value="23000"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" id="submit" value="Converter"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>