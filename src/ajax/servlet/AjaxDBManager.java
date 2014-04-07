package ajax.servlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.config.ConnectionManager;
import connection.config.ConstructClass;

public class AjaxDBManager {
	
	private static Connection conn = ConnectionManager.getInstance().getConnection();
	public static boolean validateUser(Integer inputStudentId)
	{
		boolean valid = false;
		try {
			ConstructClass.constructClass();
			String existence_sql = "SELECT Count(*) as num FROM wb_students where student_id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(existence_sql);
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
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return valid;
	}
}
