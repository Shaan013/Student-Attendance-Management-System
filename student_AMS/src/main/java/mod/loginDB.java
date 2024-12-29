package mod;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shaan
 */
 public class loginDB {
    String urlDB;
    String usernameDB;
    String passwordDB;
    
    public loginDB()
    {
        urlDB="jdbc:mysql://localhost:3306/student_management_system";
        usernameDB="root";
        passwordDB="*******";         
    
    }
    
    public boolean loginCheck(String username,String password)
    {
        Connection con;
        PreparedStatement ps;
        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
             
             con=DriverManager.getConnection(urlDB,usernameDB,passwordDB);
             
             String sql = "select password from user where username = ?";
             ps =con.prepareStatement(sql);
              ps.setString(1,username);
              
              
              ResultSet rs = ps.executeQuery();
            if (rs.next()) { // Move cursor to the first row
                String pass = rs.getString("password"); // Access the password column
                boolean res = pass.equals(password); // Compare with the input password
               
                return res;
            } else {
               return false;
            }
            
        }catch(ClassNotFoundException e)
        {
            System.out.println(e.getStackTrace() + ", , , "+ e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(loginDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
 public String getrole (String username)    {
     String role = null;
     String sql=" select role from user where username = ? ;";
     
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(urlDB,usernameDB,passwordDB);
             PreparedStatement ps= con.prepareStatement(sql);
             ps.setString(1,username);
              ResultSet rs = ps.executeQuery();
             
             while (rs.next())
             {
               role=rs.getString("role");
             }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginDB.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return role;
     
 }
    
    
}
