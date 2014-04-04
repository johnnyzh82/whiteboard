package ajaxServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.whiteboard.ConnectionManager;

public class AjaxDBManager {
	
	private static Connection conn = ConnectionManager.getInstance().getConnection();

	public static boolean validateUser(Integer inputStudentId)
	{
		boolean valid = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String existence_sql = "SELECT Count(*) as num FROM wb_students where student_id = ?;";
			PreparedStatement pstmt1 = conn.prepareStatement(existence_sql);
			pstmt1.setInt(1, inputStudentId);
			ResultSet rs1 = pstmt1.executeQuery();
			
			int count = 0;
			while (rs1.next()) 
			{
				count  = rs1.getInt("num");
			}
			ConnectionManager.getInstance().closeConnection();
			if(count > 0)
			{
				valid = true;
			}
		} 
		catch (ClassNotFoundException | SQLException e1) 
		{
			e1.printStackTrace();
		}
		return valid;
	}
}
