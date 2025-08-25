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

public class Teacher extends User {
    String qualification;
    String spec;
    Attendance att;
    Date date;
    public Teacher(String name, String contact, String username, String password, String userType,String email,String q,String s,Date d) {
        super(name, contact, username, password, "Teacher",email);
        this.date=d;
        this.qualification=q;
        this.spec=s;
    }

    Teacher(User user) {
        
    }
    public Date getDate(){
        return date;
    }
    public String getQualification(){
        return qualification;
    }

    String getSpecialization() {
        return spec;
    }

    Object getJoiningDate() {
      return date;
    }
}
