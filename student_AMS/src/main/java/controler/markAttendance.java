/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import DB_for_jsp.DB_con;
import DB_for_jsp.student;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mod.attendenceRecord;
import mod.save_attendance;

/**
 *
 * @author shaan
 */
public class markAttendance extends HttpServlet {

    protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
         ArrayList<attendenceRecord> record=new ArrayList<>();
         
        String classId = (String)req.getParameter("class_id");
        String data= (String)req.getParameter("date");
        String markById = (String)req.getParameter("markById");
        int result = 0;
        
        DB_con db = new DB_con();
        ArrayList<student> list= db.getStudentInfo();
        
        for (student x : list)
        {
            String id =(String)x.getId();
           String status = (String)req.getParameter("status_"+id);
           record.add( new attendenceRecord(id,classId,data,status,markById));
        }
        
        save_attendance seveDB=new save_attendance();//last of try    
int [] re = seveDB.savaAttendance(record);

for (int x:re){
          result+=x;
          
      }
       req.setAttribute("result", result);
       
        RequestDispatcher dispatcher = req.getRequestDispatcher("preview.jsp");
        dispatcher.forward(req, res);        
//try(  PrintWriter out= res.getWriter())
//{
//    out.print("is you result :"+result);
//}

    }// last bracte of mathod
 
}// last brecte of class 
