<%@page import="DB_for_jsp.listValue"%>
<%@page import="mod.studentRecord"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mod.StudentDB"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .header {
            background-color: #4CAF50;
            color: white;
            padding: 15px;
            text-align: center;
            font-size: 24px;
        }
        .container {
            max-width: 1000px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .student-info, .attendance, .courses {
            margin-bottom: 20px;
        }
        h2 {
            color: #333;
            border-bottom: 2px solid #4CAF50;
            padding-bottom: 5px;
        }
        .info-table, .attendance-table, .course-table {
            width: 100%;
            border-collapse: collapse;
        }
        .info-table th, .attendance-table th, .course-table th, 
        .info-table td, .attendance-table td, .course-table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        .action-button {
            display: block;
            width: 100px;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            text-decoration: none;
            margin: 10px auto;
            border-radius: 5px;
        }
        .action-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <div class="header">
        Student Dashboard
    </div>
    <%
         String username = (String)session.getAttribute("username");
        StudentDB db= new StudentDB();
        String name = db.getName(username);
        String  pr = db.parcentege(username);
        
        ArrayList<listValue> list =db.getAttadenceInfo(username);
        

    %>

    <div class="container">

        <!-- Student Information Section -->
        <div class="student-info">
            <h2>Student Information</h2>
            <table class="info-table">
                <tr>
                    <th>student id</th>
                    <td><%=  username %></td> <!-- Replace with dynamic student ID -->
                </tr>
                <tr>
                    <th>Name</th>
                    <td>shaan</td> <!-- Replace with dynamic student name -->
                </tr>
                <tr>
                    <th>attendance pr </th>
                    <td><%= pr %></td> <!-- Replace with dynamic class -->
                </tr>
            </table>
        </div>

        <!-- Attendance Record Section -->
        <div class="attendance">
            <h2>Attendance Record</h2>
            <table class="attendance-table">
                <thead>
                    <tr>
                        <th>class_id</th>
                        <th>class_name</th>
                        <th> total_attendance</th>
                        <th>total_present</th>
                        <th>attendance_percentage</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for(listValue x : list){
                    %>
                    <tr>
                        <td><%= x.getClass_id() %></td>
                        <td><%= x.getClass_name() %></td>
                        <th><%= x.getTotal_attendance() %></th>
                        <th><%= x.getTotal_present() %></th>
                        <th><%= x.getAttendance_percentage() %></th>
                    </tr>
                    <% } %>
                    
                </tbody>
            </table>
        </div>

        <!-- Courses Section -->
       


</body>
</html>
