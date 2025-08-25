/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lillahwelfarefoundationms;


import java.sql.*;
/**
 *
 * @author Rufah
 */
public class Delete_Entity {
    public static void deleteUser(int id){
        try{
            Connection conn=DBHandler.connect();
            String string="Delete from Users where id=?";
            PreparedStatement st=conn.prepareStatement(string);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("User deleted successfully.");
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    public static void deleteStudent(int id){
        try{
            Connection conn=DBHandler.connect();
            String string="Delete from Students where id=?";
            PreparedStatement st=conn.prepareStatement(string);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Student deleted successfully.");
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    public static void deleteTeacher(int id){
        try{
            Connection conn=DBHandler.connect();
            String string="Delete from Teachers where id=?";
            PreparedStatement st=conn.prepareStatement(string);
            st.setInt(1, id);
             st.executeUpdate();
            System.out.println("Teacher deleted successfully.");
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    public static void deleteDonor(int id){
        try{
            Connection conn=DBHandler.connect();
            String string="Delete from donors where id=?";
            PreparedStatement st=conn.prepareStatement(string);
            st.setInt(1, id);
             st.executeUpdate();
            System.out.println("Donor deleted successfully.");
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    public static void deleteCourse(int id){
        
        try{
            Connection conn=DBHandler.connect();
            String string="Delete from courses where id=?";
            PreparedStatement st=conn.prepareStatement(string);
            st.setInt(1, id);
             st.executeUpdate();
            System.out.println("Course deleted successfully.");
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    public static void deleteDonationCategory(int id){
     
        try{
            Connection conn=DBHandler.connect();
            String string="Delete from Donationcategories where id=?";
            PreparedStatement st=conn.prepareStatement(string);
            st.setInt(1, id);
             st.executeUpdate();
            System.out.println("Donation Category deleted successfully.");
        }catch(Exception e){
           e.printStackTrace();
        }
    }}
