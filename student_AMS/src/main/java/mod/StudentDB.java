/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod;

import DB_for_jsp.listValue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shaan
 */
public class StudentDB {
    
    String DBurl;
    String DB_username;
    String DB_password;
    
    public StudentDB()
    {
        this.DBurl="jdbc:mysql://localhost:3306/student_management_system";
        this.DB_username="root";
        this.DB_password="********";
    }
    
    public ArrayList<studentRecord> getAttendence(String student_id)
    {
        ArrayList<studentRecord> list = new ArrayList<>();
        String quary ="SELECT a.date, a.status, c.class_name\n" +
"FROM attendance a\n" +
"JOIN class c ON a.class_id = c.class_id\n" +
"WHERE a.student_id = ?;";
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection(DBurl,DB_username,DB_password); 
             
            PreparedStatement ps=ps = con.prepareStatement(quary);
            
                  ps.setString(1, student_id);
                   ResultSet rs = ps.executeQuery();
                   
                   while (rs.next())
                   {
                       String date= rs.getString("date");
                       String status=rs.getString("status");
                       String classname=rs.getString("class_name");
                       
                       list.add( new studentRecord(classname, status, date));
                       
                       
                   }
                  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;   
    }
    
    public String  parcentege(String username)
    {
        String  pr =null;
        
        String quary = "SELECT \n" +
"  (SUM(CASE WHEN status = 'present' THEN 1 ELSE 0 END) / NULLIF(COUNT(*), 0)) * 100 AS attendance_percentage\n" +
"FROM attendance\n" +
"WHERE student_id = ?;";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection(DBurl,DB_username,DB_password); 
             
            PreparedStatement ps=ps = con.prepareStatement(quary);
            
                  ps.setString(1, username);
                   ResultSet rs = ps.executeQuery();
                   
                   if(rs.next())
                   {
                      pr=rs.getString("attendance_percentage");
                   }
                  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pr;
        
    }
    
    
    
    public  ArrayList<listValue> getAttadenceInfo( String studentId){
        
        ArrayList<listValue> list=new  ArrayList<>();
        String quary="SELECT \n" +
"    c.class_id,\n" +
"    c.class_name,\n" +
"    COUNT(a.attendance_id) AS total_attendance,\n" +
"    SUM(CASE WHEN a.status = 'present' THEN 1 ELSE 0 END) AS total_present,\n" +
"    ROUND(SUM(CASE WHEN a.status = 'present' THEN 1 ELSE 0 END) / COUNT(a.attendance_id) * 100, 2) AS attendance_percentage\n" +
"FROM \n" +
"    class c\n" +
"LEFT JOIN \n" +
"    attendance a ON c.class_id = a.class_id\n" +
"WHERE \n" +
"    a.student_id = ? -- Replace with the specific student_id\n" +
"GROUP BY \n" +
"    c.class_id, c.class_name;";
        
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection(DBurl,DB_username,DB_password); 
             
            PreparedStatement ps=ps = con.prepareStatement(quary);
            
                  ps.setString(1, studentId);
                   ResultSet rs = ps.executeQuery();
                   
                   while (rs.next())
                   {
                      
           String class_id =rs.getString("class_id");
    String class_name=rs.getString("class_name");
    String total_attendance=rs.getString("total_attendance");
    String total_present=rs.getString("total_present");
    String attendance_percentage=rs.getString("attendance_percentage");
    
    list.add(new listValue( class_id ,class_name,total_attendance,total_present,attendance_percentage));
                   }
                  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return list;
         
    }
    
    
    public String getName(String id)
    {
        String name =null;
        String quary="  select name from student where student_id=?;";
        
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection(DBurl,DB_username,DB_password); 
             
            PreparedStatement ps=ps = con.prepareStatement(quary);
            
                  ps.setString(1, id);
                   ResultSet rs = ps.executeQuery();
                   if(rs.next())
                   {
                       name=rs.getString("name");
                   }
                   
                   
                  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return name;
        
        
    }
    
    
}
