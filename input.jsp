<!-- employee.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
</head>
<body>
<center>
<h1>Employee Details</h1>

<form action="/get" method="get">
    Enter Employee ID: <input type="number" name="id" required/>
    <input type="submit" value="Get Employee">
</form>
</center>
</body>
</html>
