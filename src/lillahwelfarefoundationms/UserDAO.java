package lillahwelfarefoundationms;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static lillahwelfarefoundationms.DBHandler.connect;

public class UserDAO {

     public static void insertUser(User user) {
        String insertUserSQL = "INSERT INTO Users(name, userType, contact, email, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBHandler.connect()) {
            conn.setAutoCommit(false);

            PreparedStatement psUser = conn.prepareStatement(insertUserSQL, Statement.RETURN_GENERATED_KEYS);
            psUser.setString(1, user.name);
            psUser.setString(2,user.userType );
            psUser.setString(3, user.contact);
            psUser.setString(4, user.email);
            psUser.setString(5, user.username);
            psUser.setString(6, user.password);
            psUser.executeUpdate();

            ResultSet rs = psUser.getGeneratedKeys();
            if (rs.next()) {
                int userId = rs.getInt(1);
          conn.commit();
                System.out.println("✅ User inserted successfully.");
            } else {
                conn.rollback();
                System.out.println("❌ User insertion failed: no user ID generated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  public static void insertStudent(Student student) {
    String insertUserSQL = "INSERT INTO Users(name, userType, contact, email, username, password) VALUES (?, ?, ?, ?, ?, ?)";
    String insertStudentSQL = "INSERT INTO Students(id, age, address, guardian_name, Gender) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = DBHandler.connect()) {
        conn.setAutoCommit(false);

        PreparedStatement psUser = conn.prepareStatement(insertUserSQL, Statement.RETURN_GENERATED_KEYS);
        psUser.setString(1, student.name);
        psUser.setString(2, "Student");
        psUser.setString(3, student.contact);
        psUser.setString(4, student.email);
        psUser.setString(5, student.username);
        psUser.setString(6, student.password);
        psUser.executeUpdate();

        ResultSet rs = psUser.getGeneratedKeys();
        if (rs.next()) {
            int userId = rs.getInt(1);

            PreparedStatement psStudent = conn.prepareStatement(insertStudentSQL);
            psStudent.setInt(1, userId);
            psStudent.setString(2, student.getAge());
            psStudent.setString(3, student.getAddress());
            psStudent.setString(4, student.getGuardianName());
            psStudent.setString(5, student.getGender());
            psStudent.executeUpdate();

            conn.commit();
            System.out.println("✅ User and Student inserted successfully.");
        } else {
            conn.rollback();
            System.out.println("❌ User insertion failed: no user ID generated.");
        }
    } catch (SQLException e) {
       e.printStackTrace();
    }
}


    // Insert Donor
    public static void insertDonor(Donor donor) {
        String insertUserSQL = "INSERT INTO Users(name, userType, contact, email, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        String insertDonorSQL = "INSERT INTO Donors(id, organization, donation_frequency) VALUES (?, ?, ?)";

        try (Connection conn = DBHandler.connect()) {
            conn.setAutoCommit(false);

            PreparedStatement psUser = conn.prepareStatement(insertUserSQL, Statement.RETURN_GENERATED_KEYS);
            psUser.setString(1, donor.name);
            psUser.setString(2, "Donor");
            psUser.setString(3, donor.contact);
            psUser.setString(4, donor.email);
            psUser.setString(5, donor.username);
            psUser.setString(6, donor.password);
            psUser.executeUpdate();

            ResultSet rs = psUser.getGeneratedKeys();
            if (rs.next()) {
                int userId = rs.getInt(1);

                PreparedStatement psDonor = conn.prepareStatement(insertDonorSQL);
                psDonor.setInt(1, userId);
                psDonor.setString(2, donor.getOrganization());
                psDonor.setString(3, donor.getDonationFrequency());
                psDonor.executeUpdate();

                conn.commit();
                System.out.println("✅ Donor inserted successfully.");
            } else {
                conn.rollback();
                System.out.println("❌ Donor insertion failed: no user ID generated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert Admin with roles and permissions
    public static void insertAdmin(Admin admin) {
        String insertUserSQL = "INSERT INTO Users(name, userType, contact, email, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        String insertAdminSQL = "INSERT INTO Admins(id, role, assigned_date, can_edit_users, can_manage_donations, can_manage_courses, can_view_reports) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBHandler.connect()) {
            conn.setAutoCommit(false);

            PreparedStatement psUser = conn.prepareStatement(insertUserSQL, Statement.RETURN_GENERATED_KEYS);
            psUser.setString(1, admin.name);
            psUser.setString(2, "Admin");
            psUser.setString(3, admin.contact);
            psUser.setString(4, admin.email);
            psUser.setString(5, admin.username);
            psUser.setString(6, admin.password);
            psUser.executeUpdate();

            ResultSet rs = psUser.getGeneratedKeys();
            if (rs.next()) {
                int userId = rs.getInt(1);

                PreparedStatement psAdmin = conn.prepareStatement(insertAdminSQL);
                psAdmin.setInt(1, userId);
                psAdmin.setString(2, admin.getRole());
              if (admin.getAssignedDate() != null) {
    psAdmin.setDate(3, new java.sql.Date(admin.getAssignedDate().getTime()));
} else {
    psAdmin.setNull(3, java.sql.Types.DATE);
}
                psAdmin.setBoolean(4, admin.canEditUsers());
                psAdmin.setBoolean(5, admin.canManageDonations());
                psAdmin.setBoolean(6, admin.canManageCourses());
                psAdmin.setBoolean(7, admin.canViewReports());
                psAdmin.executeUpdate();

                conn.commit();
                System.out.println("✅ Admin inserted successfully.");
            } else {
                conn.rollback();
                System.out.println("❌ Admin insertion failed: no user ID generated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert Teacher
    public static void insertTeacher(Teacher teacher) {
        String insertUserSQL = "INSERT INTO Users(name, userType, contact, email, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        String insertTeacherSQL = "INSERT INTO Teachers(id, qualification, specialization, joining_date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBHandler.connect()) {
            conn.setAutoCommit(false);

            PreparedStatement psUser = conn.prepareStatement(insertUserSQL, Statement.RETURN_GENERATED_KEYS);
            psUser.setString(1, teacher.name);
            psUser.setString(2, "Teacher");
            psUser.setString(3, teacher.contact);
            psUser.setString(4, teacher.email);
            psUser.setString(5, teacher.username);
            psUser.setString(6, teacher.password);
            psUser.executeUpdate();

            ResultSet rs = psUser.getGeneratedKeys();
            if (rs.next()) {
                int userId = rs.getInt(1);

                PreparedStatement psTeacher = conn.prepareStatement(insertTeacherSQL);
                psTeacher.setInt(1, userId);
                psTeacher.setString(2, teacher.getQualification());
                psTeacher.setString(3, teacher.getSpecialization());
                psTeacher.setDate(4, new java.sql.Date(teacher.getDate().getTime()));
                psTeacher.executeUpdate();

                conn.commit();
                System.out.println("✅ Teacher inserted successfully.");
            } else {
                conn.rollback();
                System.out.println("❌ Teacher insertion failed: no user ID generated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert Course
    public static void insertCourse(Courses course) {
        String sql = "INSERT INTO Courses(course_name, course_description, duration_weeks, start_date, end_date, teacher_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBHandler.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getCourseDescription());
            ps.setInt(3, course.getDurationWeeks());
            ps.setDate(4, new java.sql.Date(course.getStartDate().getTime()));
            ps.setDate(5, new java.sql.Date(course.getEndDate().getTime()));
            ps.setInt(6, course.getTeacherId());

            ps.executeUpdate();
            System.out.println("✅ Course inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void DonationCategory(String name,String Description){
        try{
            Connection conn=DBHandler.connect();
            String query="INSERT INTO donationcategories(NAME,DESCRIPTION)vALUES(?,?)";
            PreparedStatement stmt=conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, Description);
            stmt.executeUpdate();
            System.out.println("Category Added ✅");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void DonationRequest(String Category,String Purpose,String Email,String status){
        
        try{
            Connection conn=DBHandler.connect();
            String query="Select id from users where email=?";
            PreparedStatement st=conn.prepareStatement(query);
            st.setString(1, Email);
            ResultSet rs=st.executeQuery();
            int studentId=0;
            if (rs.next()) {
            studentId = rs.getInt("id");
        } else {
            System.out.println("No user found with the given email.");
            return;
        }

        
        String getCategoryIdQuery = "SELECT id FROM DonationCategories WHERE name = ?";
        PreparedStatement catStmt = conn.prepareStatement(getCategoryIdQuery);
        catStmt.setString(1, Category);
        ResultSet catRs = catStmt.executeQuery();

        int  categoryId=0;
        if (catRs.next()) {
           categoryId = catRs.getInt("id");
        } else {
            System.out.println("No category found with the given name.");
            return;
        }

       
        String insertQuery = "INSERT INTO DonationRequests (student_id, category_id, status, date, purpose) " +
                             "VALUES (?, ?, ?, CURDATE(), ?)";
        PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
        insertStmt.setInt(1, studentId);
        insertStmt.setInt(2, categoryId);
        insertStmt.setString(3, status); 
        insertStmt.setString(4, Purpose);

        int rows = insertStmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Donation request submitted successfully.");
        } else {
            System.out.println("Failed to submit donation request.");
        }

        rs.close();
        catRs.close();
        st.close();
        catStmt.close();
        insertStmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public static DefaultTableModel FetchPendingDonationRequests() {
    String[] columns = {"Request ID", "Student ID", "Category", "Purpose", "Status"};
    DefaultTableModel model = new DefaultTableModel(columns, 0) {
        
        public boolean isCellEditable(int row, int column) {
            return column == 4; 
        }
    };

    String query = """
     SELECT dr.id, dr.student_id, dc.name AS category, dr.purpose, dr.status
        FROM donationrequests dr
        JOIN donationcategories dc ON dr.category_id = dc.id
        WHERE dr.status = 'Pending';""";

    try (Connection conn = DBHandler.connect();
         PreparedStatement st = conn.prepareStatement(query);
         ResultSet rs = st.executeQuery()) {

        while (rs.next()) {
            int requestId = rs.getInt("id"); 
            int studentId = rs.getInt("student_id");
            String category = rs.getString("category");
            String purpose = rs.getString("purpose");
            String status = rs.getString("status");

            model.addRow(new Object[]{requestId, studentId, category, purpose, status});
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return model;
}
public static boolean submitDonation(String email, String categoryName, double amount, String notes, Date dateStr) {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        conn = DBHandler.connect(); 

        
        String donorQuery = "SELECT d.id FROM Donors d JOIN Users u ON d.id = u.id WHERE u.email = ?";
        pst = conn.prepareStatement(donorQuery);
        pst.setString(1, email);
        rs = pst.executeQuery();

        int donorId = 0;
        if (rs.next()) {
            donorId = rs.getInt("id");
        } else {
            System.out.println("No donor found for email: " + email);
            return false;
        }
        rs.close();
        pst.close();

        
        String categoryQuery = "SELECT id FROM DonationCategories WHERE name = ?";
        pst = conn.prepareStatement(categoryQuery);
        pst.setString(1, categoryName);
        rs = pst.executeQuery();

        int categoryId = -1;
        if (rs.next()) {
            categoryId = rs.getInt("id");
        } else {
            System.out.println("No category found: " + categoryName);
            return false;
        }
        rs.close();
        pst.close();

        
        String insertQuery = "INSERT INTO Donations (donor_id, category_id, amount, date, notes) VALUES (?, ?, ?, ?, ?)";
        pst = conn.prepareStatement(insertQuery);

        
        

        pst.setInt(1, donorId);
        pst.setInt(2, categoryId);
        pst.setDouble(3, amount);
        pst.setDate(4, dateStr);
        pst.setString(5, notes);

        int rows = pst.executeUpdate();
        return rows > 0;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();}
   }
    }
public static void loadDonationsByEmail(String email, JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Clear table

    String query = "SELECT d.id, dc.name AS category, d.amount, d.date, d.notes " +
                   "FROM Donations d " +
                   "JOIN DonationCategories dc ON d.category_id = dc.id " +
                   "JOIN Donors dn ON d.donor_id = dn.id " +
                   "JOIN Users u ON dn.id = u.id " +
                   "WHERE u.email = ?";

    try (Connection conn = DBHandler.connect(); 
         PreparedStatement pst = conn.prepareStatement(query)) {

        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String category = rs.getString("category");
            double amount = rs.getDouble("amount");
            Date date = rs.getDate("date");
            String notes = rs.getString("notes");

            model.addRow(new Object[]{id, category, amount, date, notes});
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading donations.");
    }
}
public static boolean submitAttendance(JTable table, String courseName, String teacherEmail, java.sql.Date date) {
    String insertQuery = "INSERT INTO Attendance (course_id, student_id, attendance_date, status, marked_by) " +
                         "VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = connect()) {

        int teacherId = -1;
        String teacherQuery = "SELECT id FROM Users WHERE email = ? AND userType = 'Teacher'";
        try (PreparedStatement teacherStmt = conn.prepareStatement(teacherQuery)) {
            teacherStmt.setString(1, teacherEmail);
            ResultSet rs = teacherStmt.executeQuery();
            if (rs.next()) {
                teacherId = rs.getInt("id");
            } else {
                JOptionPane.showMessageDialog(null, "Teacher not found for email: " + teacherEmail);
                return false;
            }
        }

        int courseId = -1;
        String courseQuery = "SELECT id FROM Courses WHERE course_name = ?";
        try (PreparedStatement courseStmt = conn.prepareStatement(courseQuery)) {
            courseStmt.setString(1, courseName);
            ResultSet rs = courseStmt.executeQuery();
            if (rs.next()) {
                courseId = rs.getInt("id");
            } else {
                JOptionPane.showMessageDialog(null, "Course not found: " + courseName);
                return false;
            }
        }

        // Step 3: Insert attendance records
        try (PreparedStatement pst = conn.prepareStatement(insertQuery)) {
            for (int i = 0; i < table.getRowCount(); i++) {
                int studentId = (int) table.getValueAt(i, 0);
                String status = table.getValueAt(i, 2).toString();

                pst.setInt(1, courseId);
                pst.setInt(2, studentId);
                pst.setDate(3, date);
                pst.setString(4, status);
                pst.setInt(5, teacherId);

                pst.addBatch();
            }

            pst.executeBatch();
        }

        return true;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}


}