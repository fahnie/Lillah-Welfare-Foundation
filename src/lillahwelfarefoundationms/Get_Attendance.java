/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lillahwelfarefoundationms;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Rufah
 */
public class Get_Attendance {

    public static DefaultTableModel fetchAttendanceTable() {
        String[] columns = {"Course Name", "Attendance Date", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        String query = """
            SELECT c.course_name, a.attendance_date, a.status
            FROM Attendance a
            JOIN Courses c ON a.course_id = c.id
            ORDER BY a.attendance_date DESC
        """;

        try (Connection conn = DBHandler.connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String courseName = rs.getString("course_name");
                Date date = rs.getDate("attendance_date");
                String status = rs.getString("status");

                Object[] row = {courseName, date, status};
                tableModel.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tableModel;
    }
}


