<%-- 
    Document   : desbord
    Created on : 16 Oct 2024, 3:36:24 pm
    Author     : shaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DB_for_jsp.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Attendance Management System</title>
    <link rel="stylesheet" href="desbord.css"> 
</head>
<body>

    <!-- Header -->
    <header>
        <h1>Attendance Management System</h1>
        <nav>
            <ul>
                <li><a href="dashboard.html">Dashboard</a></li>
                <li><a href="students.html">Students</a></li>
                <li><a href="classes.html">Classes</a></li>
                <li><a href="attendence.jsp">Mark Attendance</a></li>
                <li><a href="users.html">Users</a></li>
                <li><a href="index.html">Logout</a></li>
            </ul>
        </nav>
    </header>

    <!-- Welcome Message -->
    <section class="welcome">
        <%
            String username = (String) session.getAttribute("username");
            out.print("<h2>Welcome, " + username + "</h2>");
        %>
    </section>

    <!-- Summary Cards -->
    
    <!-- Columns Inserted Section -->
    <section class="columns-inserted">
        <h2>Columns Inserted</h2>
        <%
            // Retrieve the attribute from the request scope and cast it to Integer
            Integer result = (Integer) request.getAttribute("result");

            // Check if the result is not null
            if (result != null) {
                // Convert Integer to int (autounboxing)
                int insert = result;

                out.print("The value of the result is: " + insert);
            } else {
                out.print("Attribute 'result' is not found or is null.");
            }
        %>
    </section>

    <!-- Recent Attendance Records -->
    <a href="desbord.jsp">
        <button type="button">Go to Home Page</button>
    </a>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 Attendance Management System</p>
    </footer>

</body>
</html>
