<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DB_for_jsp.*" %>
<% 
    DB_list db = new DB_list();
    ArrayList<String> list = db.getListOfClass();
    if (list == null) {
        list = new ArrayList<>(); // Prevent null issues
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Class Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1, h2 {
            text-align: center;
        }
        form {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }
        input {
            padding: 10px;
            font-size: 16px;
            margin-right: 10px;
        }
        button {
            padding: 10px 20px;
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
            background: #f1f1f1;
            margin-bottom: 5px;
        }
    </style>
    <script>
        // JavaScript validation
        document.addEventListener("DOMContentLoaded", function () {
            document.querySelector("form").addEventListener("submit", function (event) {
                const className = document.getElementById("class").value.trim();
                if (className === "") {
                    event.preventDefault();
                    alert("Class name cannot be empty!");
                }
            });
        });
    </script>
</head>
<body>
    <div class="container">
        <h1>Class Management</h1>
        
        <form action="addClass" method="post">
            <input type="text" id="class" name="className" placeholder="Enter class name" autocomplete="off">
            <button type="submit">Add Class</button>
        </form>
        
        <!-- Display the list of added classes -->
        <div class="existing-classes">
            <h2>Existing Classes</h2>
            <ul>
                <% 
                    if (!list.isEmpty()) {
                        for (String x : list) { 
                %>
                    <li><%= x %></li>
                <% 
                        }
                    } else { 
                %>
                    <li>No classes available.</li>
                <% 
                    } 
                %>
            </ul>
        </div>
    </div>
</body>
</html>
