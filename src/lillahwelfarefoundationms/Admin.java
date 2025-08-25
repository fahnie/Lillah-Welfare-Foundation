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
public class Admin extends User {
    String role;
    Date assigned_date;
    boolean students;
    boolean donations;
    boolean course;
    boolean reports;
    
    
    public Admin(String name, String contact, String username, String password, String userType,String email,String role,Date assigned_date,
    boolean students,
    boolean donations,
    boolean course,
    boolean reports) {
        super(name, contact, username, password, "Admin",email);
        this.role=role;
        this.assigned_date=assigned_date;
        this.students=students;
        this.donations=donations;
        this.reports=reports;
        this.course=course;
        
    }

    Admin(User user) {
    }

    String getRole() {
        return this.role;}

    Date getAssignedDate() {
        return this.assigned_date;}

    boolean canEditUsers() {
        return this.students;}

    boolean canManageDonations() {
      return this.donations;}

    boolean canManageCourses() {
       return this.course; }

    boolean canViewReports() {
        return this.reports;}
    
}
