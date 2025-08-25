/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lillahwelfarefoundationms;


import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static lillahwelfarefoundationms.DBHandler.connect;

/**
 *
 * @author Rufah
 */
public class SelectUser {
    
   public static User selectUser(String email, String password, String userType) {
        
        email = email.trim().toLowerCase();
        password = password.trim();
        userType = userType.trim().toLowerCase();

        System.out.println("Email entered: " + email);
        System.out.println("Password entered: " + password);
        System.out.println("User type entered: " + userType);

        String query = "SELECT * FROM Users WHERE LOWER(email) = ? AND password = ? AND LOWER(userType) = ?";

        try (Connection conn = DBHandler.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, userType);

            ResultSet rs = ps.executeQuery();

            System.out.println("Query executed. Checking for result...");

            if (rs.next()) {
                System.out.println("User found!");

                User user = new User();
                user.name = rs.getString("name");
                user.email = rs.getString("email");
                user.password = rs.getString("password");
                user.userType = rs.getString("userType");
                user.contact = rs.getString("contact");
                user.username = rs.getString("username");
                return user;
            } else {
                System.out.println("No user found with these credentials.");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
  public static Student loadStudentPanel(String email) {
      Student student = null;
    try {
       
        Connection conn = DBHandler.connect();

       
        String query = "SELECT s.id, u.name, s.guardian_name, s.age, s.gender, " +
               "s.address, u.username, u.Email, u.password, u.contact " +
               "FROM Students s JOIN Users u ON s.id = u.id WHERE u.Email = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            student = new Student();
            student.id = rs.getInt("id");
            student.name = rs.getString("name");
            student.Guardian_name = rs.getString("guardian_name");
            student.age = rs.getString("age");
            student.gender = rs.getString("Gender");
            student.contact = rs.getString("contact");
            student.address = rs.getString("address");
            student.username = rs.getString("username");
            student.email = rs.getString("Email");
            student.password = rs.getString("password");
          
        
        } else {
            System.out.println(" No student records found");
        }

        DBHandler.close(conn);
    } catch (Exception e) {
        e.printStackTrace();
      
    }
       return student;
}
  public static Courses SelectCourse(String name) {
    Courses c = null;
    try {
        Connection conn = DBHandler.connect();
        String query = "SELECT * FROM Courses WHERE course_name = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            c = new Courses();
            c.setId(rs.getInt("id"));
            c.setCourseName(rs.getString("course_name"));
            c.description =rs.getString("course_description");
            c.duration=rs.getInt("duration_weeks");
            c.start=rs.getDate("start_date");
            c.end=rs.getDate("end_date");
            c.teacherId=rs.getInt("teacher_id");
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
    return c;
}
public static void enrollStudent(String email, String courseName, java.util.Date utilDate) {
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    try {
        Connection conn = DBHandler.connect();
        int studentId = 0;
        PreparedStatement pst1 = conn.prepareStatement("SELECT id FROM users WHERE email = ?");
        pst1.setString(1, email);
        ResultSet rs1 = pst1.executeQuery();
        if (rs1.next()) {
            studentId = rs1.getInt("id");
        } else {
            System.out.println("No user found with this email.");
            return;
        }
        int courseId = 0;
        PreparedStatement pst2 = conn.prepareStatement("SELECT id FROM courses WHERE course_name = ?");
        pst2.setString(1, courseName);
        ResultSet rs2 = pst2.executeQuery();
        if (rs2.next()) {
            courseId = rs2.getInt("id");
        } else {
            System.out.println("No course found with this name.");
            return;
        }

        PreparedStatement pst3 = conn.prepareStatement(
            "INSERT INTO studentcourses (student_id, course_id, enrollment_date) VALUES (?, ?, ?)"
        );
        pst3.setInt(1, studentId);
        pst3.setInt(2, courseId);
        pst3.setDate(3, sqlDate);

        int rows = pst3.executeUpdate();
        if (rows > 0) {
            System.out.println("Enrollment successful.");
        } else {
            System.out.println("Enrollment failed.");
        }

        loadStudentPanel(email);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public static Donor LoadDonorPanel(String gmail){
    Donor d=new Donor();
    try{
        Connection conn=DBHandler.connect();
        String query="SELECT d.id, u.name, d.organization, d.donation_frequency," +
               "u.username, u.Email, u.password, u.contact " +
               "FROM Donors d JOIN Users u ON u.id = d.id WHERE u.Email = ?";
        PreparedStatement t=conn.prepareStatement(query);
        t.setString(1, gmail);
        ResultSet s=t.executeQuery();
        if (s.next()) {
            
            d.id = s.getInt("id");
            d.name = s.getString("name");
            d.org = s.getString("organization");
            d.don_freq = s.getString("donation_frequency");
            
            d.contact = s.getString("contact");
            
            d.username = s.getString("username");
            d.email = s.getString("Email");
            d.password = s.getString("password");
          
        
        } else {
            System.out.println(" No Donor records found");
        }

        DBHandler.close(conn);
    } catch (Exception e) {
        e.printStackTrace();
      
    }
    
    return d;
}
public static void loadStudentsForAttendance(String courseName, JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); 

    String getCourseIdQuery = "SELECT id FROM Courses WHERE course_name = ?";
    String loadStudentsQuery = "SELECT s.id, u.name FROM StudentCourses sc " +
                                "JOIN Students s ON sc.student_id = s.id " +
                                "JOIN Users u ON s.id = u.id " +
                                "WHERE sc.course_id = ?";

    try (Connection conn = connect();
         PreparedStatement getCourseIdStmt = conn.prepareStatement(getCourseIdQuery)) {
      
        getCourseIdStmt.setString(1, courseName);
        ResultSet rsCourse = getCourseIdStmt.executeQuery();

        if (rsCourse.next()) {
            int courseId = rsCourse.getInt("id");

            
            try (PreparedStatement loadStudentsStmt = conn.prepareStatement(loadStudentsQuery)) {
                loadStudentsStmt.setInt(1, courseId);
                ResultSet rsStudents = loadStudentsStmt.executeQuery();

                while (rsStudents.next()) {
                    int studentId = rsStudents.getInt("id");
                    String name = rsStudents.getString("name");
                    model.addRow(new Object[]{studentId, name, "Present"}); 
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Course not found: " + courseName);
        }

    } catch (Exception e) {
        e.printStackTrace();
       
    }
}

}
