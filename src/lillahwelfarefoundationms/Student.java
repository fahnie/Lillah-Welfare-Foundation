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
public class Student extends User {
    String age;
    String gender;
    String address;
    String Guardian_name;
    Courses c[];
   public Student(){
       
   }

    public Student(String name, String contact, String username, String password,String usertype,String email,String age,String guardian,String gender,String address) {
        super(name, contact, username, password, usertype,email);
        this.Guardian_name=guardian;
        this.age=age;
        this.gender=gender;
        this.address=address;    
    }

  
    public void RegisterCourse(){
        
        c=new Courses[8];
        
        int i=0;
        
    }

    public String getAge() {
        return this.age;
    }

  
    String getAddress() {
        return this.address;
           }

    String getGuardianName() {
        return this.Guardian_name;
    }
    String getGender(){
        return this.gender;
    }

}