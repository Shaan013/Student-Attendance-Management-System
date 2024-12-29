/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shaan
 */
public class save_attendance {
    String urlDB;
    String usernameDB;
    String passwordDB;
    
    public save_attendance()
    {
        urlDB="jdbc:mysql://localhost:3306/student_management_system";
        usernameDB="root";
        passwordDB="*********";         
    
    }
    
   public  int[] savaAttendance(ArrayList<attendenceRecord> list)
    {
        String quary="INSERT INTO attendance (student_id, class_id, date, status, marked_by_user_id) \n" +
"VALUES (?, ?, ?, ?, ?);";
        boolean result;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             
             Connection con=DriverManager.getConnection(urlDB,usernameDB,passwordDB);
             PreparedStatement ps=con.prepareStatement(quary);
             
             for(attendenceRecord at: list)
             {
                 int ClassId = Integer.parseInt(at.getClassId());
                 int sid = Integer.parseInt(at.getId());
                 String date=at.getdata();
                 String status=at.getstatus();
                 int markById = Integer.parseInt(at.getmarkBy());
                 
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(date, formatter);  // Parse String to LocalDate
            Date sqlDate = Date.valueOf(localDate);
                
                ps.setInt(1, sid);
                ps.setInt(2,ClassId);
                ps.setDate(3, sqlDate);
                ps.setString(4, status);
                ps.setInt(5, markById);
                ps.addBatch();
                          
             }
            int [] pr= ps.executeBatch();
            return pr;
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(save_attendance.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(save_attendance.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
        
    }//last of method brecket
   
   public ArrayList<attendenceRecord> viewAttendnece(){
        ArrayList<attendenceRecord> list = new  ArrayList<>();
        
        String quary="select * from attendance;";
       
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(urlDB, usernameDB, passwordDB);
            Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(quary);
             
             while(rs.next()){
                 String studentId= (String)rs.getString("student_id");
                 String classId= (String)rs.getString("class_id");
                 String date = (String)rs.getString("date");
                 String status= (String)rs.getString("status");
                 String markById = (String)rs.getString("marked_by_user_id");
                     
                list.add(new attendenceRecord(studentId,classId,date,status,markById));    
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(save_attendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(save_attendance.class.getName()).log(Level.SEVERE, null, ex);
        }

            
       
        return list;
//        ArrayList<attendenceRecord> list = new  ArrayList<>();
        
    }
}
