/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import DB_for_jsp.DB_list;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shaan
 */



/**
 * Servlet implementation for adding a student.
 */

public class AddStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters from the request
        String studentName = request.getParameter("studentName");
        String classIdStr = request.getParameter("classId");

        // Initialize DB_list for database interaction
        DB_list db = new DB_list();
        PrintWriter out = response.getWriter();

        try {
            // Validate and convert classId
            int classId = Integer.parseInt(classIdStr);

            // Add student to the database
            boolean success = db.addStudent(classId, studentName);

            // Respond with a success or error message
            if (success) {
                response.sendRedirect("student.jsp"); // Redirect to the student page
            } else {
                out.println("<h3>Failed to add student. Please try again.</h3>");
            }
        } catch (NumberFormatException e) {
            Logger.getLogger(AddStudentServlet.class.getName()).log(Level.SEVERE, null, e);
            out.println("<h3>Invalid class ID. Please enter a numeric value.</h3>");
        } catch (Exception e) {
            Logger.getLogger(AddStudentServlet.class.getName()).log(Level.SEVERE, null, e);
            out.println("<h3>An error occurred. Please try again later.</h3>");
        } finally {
            out.close();
        }
    }
}

