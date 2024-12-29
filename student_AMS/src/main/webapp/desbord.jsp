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
                <li><a href="wholeRepo.jsp">attendence repo</a></li>
               // <li><a href="student.jsp">Students</a></li>
               // <li><a href="classes.jsp">Classes</a></li>
                <li><a href="attendence.jsp">mark Attendance</a></li>
                <li><a href="users.html">Users</a></li>
                <li><a href="index.html">Logout</a></li>
            </ul>
        </nav>
    </header>

    <!-- Welcome Message -->
    <section class="welcome">
        <%
            String username = (String)session.getAttribute("username");
            out.print("<h2>Welcome, "+username +"</h2>");
        %>
        
    </section>

    <!-- Summary Cards -->
    <section class="summary-cards">
        <div class="card">
            <% 
DB_con DBC=new DB_con();
String totel_student=DBC.getTotalStudents();
String totel_class=DBC.getTotalclass();
String totel_attendence=DBC.getTotalAttendance();

            %>
            <h3>Total Students</h3>
            <p><%= totel_student%></p>
        </div>
        <div class="card">
            <h3>Total Classes</h3>
            <p><%=totel_class%></p>
        </div>
        <div class="card">
            <h3>Total Attendance Records</h3>
            <p><%=totel_attendence%></p>
        </div>
    </section>

    <!-- Recent Attendance Records -->
<!--    <section class="attendance-table">
        <h2>Recent Attendance Records</h2>
        <table>
            <thead>
                <tr>
                    <th>Student Name</th>
                    <th>Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>John Doe</td>
                    <td>2024-10-14</td>
                    <td>Present</td>
                </tr>
                <tr>
                    <td>Jane Smith</td>
                    <td>2024-10-14</td>
                    <td>Absent</td>
                </tr>
            </tbody>
        </table>
    </section>-->

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 Attendance Management System</p>
    </footer>

</body>
</html>
