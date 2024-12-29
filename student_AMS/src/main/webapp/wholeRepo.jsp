<%@page import="mod.attendenceRecord"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mod.save_attendance"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Attendance Report</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .container {
            width: 80%;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .status-present {
            color: #28a745;
            font-weight: bold;
        }
        .status-absent {
            color: #dc3545;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <%
        save_attendance sa=new save_attendance();
        ArrayList<attendenceRecord> list = new ArrayList<>();
        list = sa.viewAttendnece();
    %>

    <div class="container">
        <h1>Attendance Report</h1>
        <table>
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Class ID</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Marked By ID</th>
                </tr>
            </thead>
           
            <tbody>
                 <% for(attendenceRecord x : list )
                 {
            %>
                <tr>
                    <td><%= x.getId() %></td>
                    <td><%= x.getClassId() %></td>
                    <td><%= x.getdata() %></td>
                    <td class="status-present"><%= x.getstatus() %></td>
                    <td><%= x.getmarkBy() %></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </div>

</body>
</html>
