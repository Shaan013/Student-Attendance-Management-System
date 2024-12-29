/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import DB_for_jsp.DB_list;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author shaan
 */
import java.io.IOException;


public class addClass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String className = request.getParameter("className");
        DB_list db = new DB_list();

        if (!className.isEmpty()) {
            boolean success = db.addClass(className);
            if (success) {
                response.sendRedirect("classes.jsp"); // Redirect back to the JSP page
            } else {
                response.getWriter().println("Error adding class.");
            }
        } else {
            response.getWriter().println("Class name cannot be empty.");
        }
    }
}
