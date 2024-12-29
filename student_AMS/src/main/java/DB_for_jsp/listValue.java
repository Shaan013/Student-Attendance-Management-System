/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB_for_jsp;

/**
 *
 * @author shaan
 */
public class listValue {
    String class_id ;
    String class_name;
    String total_attendance;
    String total_present;
    String attendance_percentage;
    
    public listValue( String class_id ,
    String class_name,
    String total_attendance,
    String total_present,
    String attendance_percentage)
    {
        this.class_id=class_id ;
    this.class_name=class_name;
   this.total_attendance =total_attendance;
    this.total_present=total_present;
    this.attendance_percentage=attendance_percentage;
    } 

public String  getClass_id()    {
    return this.class_id;
}
   public String getClass_name(){
       return this.class_name;
   }
    public String getTotal_attendance(){
        return this.total_attendance;
    }
    public String getTotal_present(){
        return this.total_present;
    }
   public String getAttendance_percentage(){
       return this.attendance_percentage;
   }
   
}
