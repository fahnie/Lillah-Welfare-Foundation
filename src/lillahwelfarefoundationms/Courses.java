/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lillahwelfarefoundationms;

import java.util.Date;

/**
 *
 * @author Rufah
 */
public class Courses {
    public int id;
    public String title;
    public String description;
    public int teacherId;
    public int duration;
    Date start;
    Date end;
    
    public Courses(){
        
    }

    public Courses(String title, String description, int teacherId,Date start,Date end,int d) {
        this.title = title;
        this.description = description;
        this.teacherId = teacherId;
        this.start=start;
        this.end=end;
        this.duration=d;
    }

 public String getTitle(){
     return title;
 }
 public String getDescription(){
     return description;
}
 public int getTeacherId(){
     return teacherId;
 }

    String getCourseName() {
        return title;}

    String getCourseDescription() {
       return description;}

    int getDurationWeeks() {
        return duration;}

    Date getStartDate() {
        return start;}

    Date getEndDate() {
      return end;}

    void setId(int aInt) {
        this.id=aInt;
    }

    void setCourseName(String string) {
        this.title=string;
    }

    void setDuration(int aInt) {
        this.duration=aInt;
    }
}
