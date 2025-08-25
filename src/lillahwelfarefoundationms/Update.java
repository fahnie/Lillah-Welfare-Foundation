/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lillahwelfarefoundationms;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rufah
 */
public class Update {
   public static void updateStudent(Student s) {
    try {
        Connection conn = DBHandler.connect();

        String idQuery = "SELECT id FROM Users WHERE email=?";
        PreparedStatement idStmt = conn.prepareStatement(idQuery);
        idStmt.setString(1, s.getEmail());
        ResultSet rs = idStmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");

            String updateUsers = "UPDATE Users SET name=?, contact=?, username=?, password=? WHERE id=?";
            PreparedStatement st1 = conn.prepareStatement(updateUsers);
            st1.setString(1, s.getName());
            st1.setString(2, s.getContact());
            st1.setString(3, s.getUser());
            st1.setString(4, s.getpwd());
            st1.setInt(5, id);

            int userRows = st1.executeUpdate();
            System.out.println("Users table rows affected: " + userRows);

            String updateStudents = "UPDATE Students SET age=?, guardian_name=?, gender=?, address=? WHERE id=?";
            PreparedStatement st2 = conn.prepareStatement(updateStudents);
            st2.setInt(1, Integer.parseInt(s.getAge()));
            st2.setString(2, s.getGuardianName());
            st2.setString(3, s.getGender());
            st2.setString(4, s.getAddress());
            st2.setInt(5, id);

            int studentRows = st2.executeUpdate();
            System.out.println("Students table rows affected: " + studentRows);

            if (userRows > 0 || studentRows > 0) {
                JOptionPane.showMessageDialog(null, "✅ Student updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "⚠️ No changes were made.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "❌ User not found for this email: " + s.getEmail());
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "❌ Error: " + e.getMessage());
    }
}


    public static void updateDonor(Donor d) {
    try (Connection conn = DBHandler.connect()) {

        // Update USERS table
        String updateUser = "UPDATE Users SET name=?, contact=?, username=?, password=? WHERE email=?";
        PreparedStatement pst1 = conn.prepareStatement(updateUser);
        pst1.setString(1, d.getName());
        pst1.setString(2, d.getContact());
        pst1.setString(3, d.getUser());
        pst1.setString(4, d.getpwd());
        pst1.setString(5, d.getEmail());
        pst1.executeUpdate();

       
        String getId = "SELECT id FROM Users WHERE email=?";
        PreparedStatement getIdStmt = conn.prepareStatement(getId);
        getIdStmt.setString(1, d.getEmail());
        ResultSet rs = getIdStmt.executeQuery();

        int id = -1;
        if (rs.next()) id = rs.getInt("id");

       
        if (id != -1) {
            String updateDonor = "UPDATE Donors SET organization=?, donation_frequency=? WHERE id=?";
            PreparedStatement pst2 = conn.prepareStatement(updateDonor);
            pst2.setString(1, d.getOrganization());
            pst2.setString(2, d.getDonationFrequency()); // e.g. "Monthly"
            pst2.setInt(3, id);
            pst2.executeUpdate();
            pst2.close();
        }

        pst1.close();
        getIdStmt.close();
        rs.close();
        System.out.println("✅ Donor updated successfully.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
