<%-- 
    Document   : student
    Created on : 28 Dec 2024, 7:46:38 pm
    Author     : shaan
--%>


<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DB_for_jsp.*"%>
<% 
    DB_list db = new DB_list();
    ArrayList<String> students = db.getListOfStudent(); // Get list of students
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f7fc;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
            margin-bottom: 30px;
        }

        input, button {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        .no-data {
            text-align: center;
            color: #888;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Student Management</h1>
        
        <!-- Form to Add Student -->
        <form action="addStudent" method="post">
            <input type="text" name="studentName" placeholder="Enter Student Name" required>
            <input type="number" name="classId" placeholder="Enter Class ID" required>
            <button type="submit">Add Student</button>
        </form>

        <!-- Display List of Students -->
        <h2>Student List</h2>
        <ul>
            <% 
                if (students != null && !students.isEmpty()) {
                    for (String student : students) { 
            %>
                        <li><%= student %></li>
            <% 
                    }
                } else { 
            %>
                    <li class="no-data">No students available.</li>
            <% 
                } 
            %>
        </ul>
    </div>
</body>
</html>

