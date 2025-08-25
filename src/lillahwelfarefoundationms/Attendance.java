/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lillahwelfarefoundationms;

/**
 *
 * @author Rufah
 */
import java.util.Date;

public class Attendance {

    static void markAttendance(Attendance att) {
    }
    public int course;
    private int studentId;
    private Date attendanceDate;
    private String status;
    private int teacherId;
    public Attendance(int courseId, int studentId, Date attendanceDate, String status) {
        
        this.studentId = studentId;
        this.attendanceDate = attendanceDate;
        this.status = status;
       
        course =courseId;
    }

  public int getCourseId(){
      return course;
  }
  public int getStudentId(){
      return studentId;
  }
  public Date getAttendanceDate(){
      return attendanceDate;
  }
  public String getStatus(){
      return status;
  }

    int getMarkedByTeacherId() {
       return teacherId;}
}