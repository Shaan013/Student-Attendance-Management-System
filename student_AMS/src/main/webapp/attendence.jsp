<%@page import="DB_for_jsp.student"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DB_for_jsp.DB_con"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Attendance Page</title>
     <link rel="stylesheet" href="attendence.css"> 
    
</head>
<body>

    <div class="container">
        <h1>Mark Attendance for Class</h1>
        
        <!-- Class Selection -->
        <form method="POST" action="markAttendance">
            <%
                DB_con db= new DB_con();
                ArrayList<String> classes=db.getClassNames();
                String username = (String)session.getAttribute("username");

                String markById = db.getMarkById(username);
                
            %>
            <label for="class">Select Class:</label>
            <select id="class" name="class_id" required>
                <%
                    for (int i=0;i<classes.size();i++)
                    {
                    String result=classes.get(i);
                     out.print("<option value='"
                     +(i+1)+ "'>"+result+"</option>");
                    }
                %>
               
            </select>

            <label for="date">Select Date:</label>
            <input type="date" id="date" name="date" required>
<% ArrayList<student> info=db.getStudentInfo();

%>
            <table>
                <thead>
                    <tr>
                        <th>Student Name</th>
                        <th>Status (Present/Absent)</th>
                    </tr>
                </thead>
               
                <tbody>
                     <% for(student st:info)
{ %>
                    <!-- Dynamically add student rows here -->
                    <tr>
                        <td><%= st.getName()%>(<%=st.getId()%>)</td>
                        <td> 
                            <input type="radio" name="status_<%=st.getId()%>" value="present" required> Present
                            <input type="radio" name="status_<%=st.getId()%>" value="absent"> Absent
                        </td>
                    </tr>
<!--                    <tr>
                        <td>Jane Smith</td>
                        <td>
                            <input type="radio" name="status_2" value="present" required> Present
                            <input type="radio" name="status_2" value="absent"> Absent
                        </td>
                    </tr>-->
                   <%}%>   <!-- Add more students dynamically based on selected class -->
                </tbody>
              
            </table>
                <input type="hidden" name="markById" value="<%= markById %>">
            <button type="submit" class="btn">Submit Attendance</button>
        </form>
    </div>

</body>
</html>
