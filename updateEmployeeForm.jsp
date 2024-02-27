<%@ page import="com.praveen.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
</head>
<body>
<h2>Update Employee</h2>
<%
    List<Employee> emps=new ArrayList<>();

    Employee employee = (Employee) request.getAttribute("employee");

%>
<form action="/update">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id" value="<%=employee.getId()%>"><br><br>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<%=employee.getName()%>"><br><br>

    <label for="salary">Salary:</label>
    <input type="text" id="salary" name="salary" value="<%=employee.getSalary()%>"><br><br>

    <label for="designation">Designation:</label>
    <input type="text" id="designation" name="designation" value="<%=employee.getDesignation()%>"><br><br>

    <input type="submit" value="Update Employee">

</form>

</body>
</html>
