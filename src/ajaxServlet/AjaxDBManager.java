package ajaxServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.google.appengine.api.utils.SystemProperty;

import com.whiteboard.ConnectionManager;

public class AjaxDBManager {
	
	private static Connection conn = ConnectionManager.getInstance().getConnection();

	public static boolean validateUser(Integer inputStudentId)
	{
		boolean valid = false;
		try {
			if (SystemProperty.environment.value() ==
			          SystemProperty.Environment.Value.Production) {
				Class.forName("com.mysql.jdbc.GoogleDriver");
			}
			else {
				Class.forName("com.mysql.jdbc.Driver");
			}
			String existence_sql = "SELECT Count(*) as num FROM wb_students where student_id = ?;";
			PreparedStatement pstmt = getConn().prepareStatement(existence_sql);
			pstmt.setInt(1, inputStudentId);
			ResultSet rs = pstmt.executeQuery();
			
			int count = 0;
			while (rs.next()) 
			{
				count  = rs.getInt("num");
			}
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

	public static Connection getConn() {
		return conn;
	}
}
