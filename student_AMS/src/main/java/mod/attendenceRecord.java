/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mod;

import static jakarta.ws.rs.core.Response.status;

/**
 *
 * @author shaan
 */
public class attendenceRecord {
    
String StudentId;
String Status;
String ClassId;
String date;
String markBy=null;


public attendenceRecord(String id ,String ClassId,String date, String stetus)
{
    this.ClassId=ClassId;
    this.date=date;
    this.StudentId=id;
    this.Status=stetus;
} 
public attendenceRecord(String id ,String ClassId,String date, String stetus,String markBy)
{
    this.ClassId=ClassId;
    this.date=date;
    this.StudentId=id;
    this.Status=stetus;
    this.markBy=markBy;
} 
 public String getId()
 {
     return StudentId;
 }
public String getstatus(){
    return Status;
}
public String getClassId()
{
    return ClassId;
}
public String getdata()
{
    return date;
}
public String getmarkBy()
{
    return markBy;
}
}
