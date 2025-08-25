package lillahwelfarefoundationms;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import lillahwelfarefoundationms.DBHandler;

public class Get_DonationRequests {

 public static DefaultTableModel FetchRequestStatus(String email) {
    String[] columns = {"Category", "Date", "Purpose", "Status"};
    DefaultTableModel request = new DefaultTableModel(columns, 0);

    String getRequestsQuery =
        "SELECT dc.name AS category, dr.date, dr.purpose, dr.status " +
        "FROM donationrequests dr " +
        "JOIN donationcategories dc ON dr.category_id = dc.id " +
        "JOIN students s ON dr.student_id = s.id " +
        "JOIN users u ON s.id = u.id " +
        "WHERE u.email = ?";

    try {
        Connection conn = DBHandler.connect();
        PreparedStatement stmt = conn.prepareStatement(getRequestsQuery);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String category = rs.getString("category");
            Date date = rs.getDate("date");
            String purpose = rs.getString("purpose");
            String status = rs.getString("status");

            Object[] row = {category, date.toString(), purpose, status};
            request.addRow(row);
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return request;
}
 public static void SetStatus(String choice, int id){
    try{
        // Validate only allowed values go to DB
        if (choice == null || (!choice.equals("Pending") && !choice.equals("Approved") && !choice.equals("Rejected"))) {
            System.out.println("Invalid status: " + choice);
            return; // Don't continue
        }

        Connection conn = DBHandler.connect();
        String query = "UPDATE donationrequests SET status = ? WHERE id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, choice);
        st.setInt(2, id);
        st.executeUpdate();

        st.close();
        conn.close();

        System.out.println("Status updated to " + choice + " for ID " + id);
    } catch(Exception e){
        e.printStackTrace();
    }
}
}
