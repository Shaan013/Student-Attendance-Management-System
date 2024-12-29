package DB_for_jsp;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_list {

    public String DB_url = "jdbc:mysql://localhost:3306/student_management_system";
    public String DB_username = "root";
    public String DB_password = "*********"
    

    public ArrayList<String> ListOf(String query) {
        ArrayList<String> resultList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DB_url, DB_username, DB_password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                resultList.add(rs.getString(1)); // Assumes you're selecting one column
            }

        } catch (SQLException ex) {
            Logger.getLogger(DB_list.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultList;
    }

    public ArrayList<String> getListOfClass() {
        final String query = "SELECT class_name FROM class;";
        return ListOf(query);
    }

    public ArrayList<String> getListOfStudent() {
        final String query = " select name from student;"; // Replace with actual column and table
        return ListOf(query);
    }

    public boolean addClass(String cl) {
        try (Connection con = DriverManager.getConnection(DB_url, DB_username, DB_password);
             PreparedStatement st = con.prepareStatement("INSERT INTO class (class_name) VALUES (?);")) {

            st.setString(1, cl);
            int result = st.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DB_list.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex.getLocalizedMessage());
            return false;
        }
    }

    public boolean addStudent(int cl,String name) {
        try (Connection con = DriverManager.getConnection(DB_url, DB_username, DB_password);
             PreparedStatement st = con.prepareStatement(" INSERT INTO Student (class_id, name) VALUES (?,?);")) {

            st.setInt(1, cl);
            st.setString(2, name);
            int result = st.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DB_list.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex.getLocalizedMessage());
            return false;
        }
    }
//    public static void main(String[] args) {
//        DB_list db = new DB_list();
//
//        ArrayList<String> list = db.getListOfClass();
//        if (list != null) {
//            for (String l : list) {
//                System.out.println("Class: " + l);
//            }
//        } else {
//            System.out.println("No classes found.");
//        }
// }
}
