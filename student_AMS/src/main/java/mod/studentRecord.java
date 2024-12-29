/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod;

/**
 *
 * @author shaan
 */
public class studentRecord {
    String class_name;
    String status;
    String date;
    
    public studentRecord(String class_name, String status, String date)
    {
        this.class_name=class_name;
        this.status=status;
        this.date=date;
    }
    
    public String getClassName ()
    {
        return class_name;
    }
    public String getDate()
    {
        return date;
    }
    public String getStatus()
    {
        return status;
    }
}
