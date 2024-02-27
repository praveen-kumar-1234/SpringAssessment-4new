<%@ page contentType="text/html;"%>
<%@ page import="java.util.List" %>
<%@ page import="com.praveen.model.Employee" %>
<body>
<center>
<h1>View Employee Table</h1><br>
    <a href="/">home</a><br>
<table border="5">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>SALARY</th>
        <th>DESIGNATION</th>
    </tr>
    <%
        Employee employee = (Employee) request.getAttribute("employee");

    %>
    <tr>
        <td><%=employee.getId()%></td>
        <td><%=employee.getName()%></td>
        <td><%=employee.getSalary()%></td>
        <td><%=employee.getDesignation()%></td>
    </tr>

</table>
</center>
</body>