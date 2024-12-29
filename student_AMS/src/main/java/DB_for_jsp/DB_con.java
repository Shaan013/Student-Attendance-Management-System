package DB_for_jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shaan
 */
 //last brecket of student class


public class DB_con {
    public String DB_url = "jdbc:mysql://localhost:3306/student_management_system";  // Corrected DB URL
    public String DB_username = "root";
    public String DB_password = "*******";
    
    public DB_con() {
    }
    
    public String excutequary(String quary) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String totalStudents = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            con = DriverManager.getConnection(DB_url, DB_username, DB_password);

            // Create statement
            st = con.createStatement();

            // Execute query
            rs = st.executeQuery(quary);

            // Process the result
            if (rs.next()) {
                totalStudents = rs.getString(1);  // Fetch the count from the first column
            }
        } catch (SQLException e) {
            // Return an error message if there is an exception
            return "Error: " + e.getMessage();
        } catch (ClassNotFoundException ex) {
            return "Error: " + ex.getMessage();
        } finally {
            // Close resources to avoid resource leak
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                return "Error while closing resources: " + e.getMessage();
            }
        }

        return totalStudents != null ? totalStudents : "Error: Could not retrieve the total number of students.";
    }
    
    public String getTotalStudents() {
       return excutequary("select count(*) from student;");
    }
    
     public String getTotalclass(){
      return excutequary("select count(*) from class;");   
     }
     
      public String getTotalAttendance(){
      return excutequary("SELECT COUNT(*) AS total_entries FROM attendance;");   
     }
     
      public ArrayList<String> getArray(String quary,String pera)
      {
          Connection con = null;
        Statement st = null;
        ResultSet rs = null;
       ArrayList<String> list = new ArrayList<>();
        
         

        
        try{
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            con = DriverManager.getConnection(DB_url, DB_username, DB_password);

            // Create statement
            st = con.createStatement();

            // Execute query
            rs = st.executeQuery(quary);
             while (rs.next())
             {
                 String result=rs.getString(pera);
                 list.add(result);
             }
            return list; 
            
            
            
        }catch(ClassNotFoundException | SQLException e)
        {
            list.add(e.getMessage());
            return list;
            
        }
       
    }     
      
      
       public ArrayList<String> getClassNames() {
        return getArray("SELECT class_name FROM class;", "class_name"); // Correct SQL query and return result
    }
     
       public ArrayList<student> getStudentInfo()
{
            Connection con = null;
        Statement st = null;
        ResultSet rs = null;
         ArrayList<student> list = new ArrayList<>();
         String quary = "SELECT name, student_id FROM student;";   
         try{
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            con = DriverManager.getConnection(DB_url, DB_username, DB_password);

            // Create statement
            st = con.createStatement();

            // Execute query
            rs = st.executeQuery(quary);
             while (rs.next())
             {
                String name = rs.getString("name");
                String id = rs.getString("student_id");
                  list.add(new student(name,id));
             }
            
            
            
            
        }catch(ClassNotFoundException | SQLException e)
        {
            System.out.print("get error:"+e.getLocalizedMessage());
            
        }
        return list;
       
       }   
         
         public String getMarkById(String userName)  {
             String quary="select  user_id from user where username=?;";
             String id = null;
             
             try{
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection con=DriverManager.getConnection(DB_url, DB_username, DB_password);
                  PreparedStatement ps=con.prepareStatement(quary);
                  ps.setString(1,userName);
                  ResultSet rs = ps.executeQuery();
                  
                    if (rs.next()) { // Move cursor to the first row
                id = rs.getString("user_id"); // Access the password column      
            }
                  
             } catch (SQLException ex) {
            Logger.getLogger(DB_con.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_con.class.getName()).log(Level.SEVERE, null, ex);
        }
          return id;
         }
       
}

