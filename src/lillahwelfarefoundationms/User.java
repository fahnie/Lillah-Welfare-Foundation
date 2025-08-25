/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lillahwelfarefoundationms;

/**
 *
 * @author Rufah
 */
public  class  User {
  
    public int id;
     String name;
     String contact;
     String username;
     String password;
     String userType;
     String email;
  
    public User(){
        
    }
    public User(String name, String contact, String username, String password, String userType,String email) {
        this.name = name;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.email=email;
    }
    int getid() {
       return id;}
    String getName(){
        return name;
    }
String getContact(){
    return contact;
}
String getpwd(){
    return password;
    
}
String getUser(){
    return username;
}
String getEmail(){
    return email;
}
}

