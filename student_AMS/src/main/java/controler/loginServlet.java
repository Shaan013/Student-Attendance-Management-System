package controler;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import com.mysql.cj.Session;
import jakarta.servlet.RequestDispatcher;
import mod.loginDB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String username=req.getParameter("username");
        String password =req.getParameter("password");
        
        loginDB ch = new loginDB();
        boolean rs = ch.loginCheck(username, password);
       if (rs){
           HttpSession ss = req.getSession();
           ss.setAttribute("username", username);
           String role = ch.getrole(username);
           
           if ("professor".equals(role) || "admin".equals(role)) 
           {
           RequestDispatcher rd = req.getRequestDispatcher("desbord.jsp");
        rd.forward(req, res);
           }else if ("student".equals(role))
           {
               RequestDispatcher rd = req.getRequestDispatcher("StudentDesbord.jsp");
        rd.forward(req, res);
               
           }
       }
       else {
            req.setAttribute("errorMessage", "Incorrect username or password!");
           RequestDispatcher rd=req.getRequestDispatcher("index.html");
           rd.forward(req, res);
       }
    
        
        
         
       
        
    }
    
}
