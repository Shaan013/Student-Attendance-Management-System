<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Attendance</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
        }
        h2 {
            margin-top: 20px;
            font-size: 24px;
            color: #333;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            background-color: #ffffff;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #e1e1e1;
        }
    </style>
</head>
<body>
    

    <h2>Student Attendance Table</h2>
    
    <table>
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Class ID</th>
                <th>Date</th>
                <th>Attendance Status</th>
                <th>Made By</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>001</td>
                <td>101</td>
                <td>2024-10-27</td>
                <td>Present</td>
                <td>Admin</td>
            </tr>
            <tr>
                <td>002</td>
                <td>102</td>
                <td>2024-10-27</td>
                <td>Absent</td>
                <td>Admin</td>
            </tr>
            <tr>
                <td>003</td>
                <td>101</td>
                <td>2024-10-27</td>
                <td>Present</td>
                <td>Admin</td>
            </tr>
            <tr>
                <td>004</td>
                <td>103</td>
                <td>2024-10-27</td>
                <td>Late</td>
                <td>Admin</td>
            </tr>
            <tr>
                <td>005</td>
                <td>102</td>
                <td>2024-10-27</td>
                <td>Present</td>
                <td>Admin</td>
            </tr>
        </tbody>
    </table>

</body>
</html>
