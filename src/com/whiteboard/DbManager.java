package com.whiteboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbManager {
	
	private static Connection conn = ConnectionManager.getInstance().getConnection();
	public static boolean validateUser(UserBeanModel user)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Constructing the SQL query
			int inputStudentId = user.getStudentId();
			String inputPassword = user.getPassword();
			int studentId = 0;
			String password = null;
			
			String sql = "SELECT * FROM wb_students where student_id = ? and password = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inputStudentId);
			pstmt.setString(2, inputPassword);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				studentId  = rs.getInt("student_id");
				password = rs.getString("password");
 
				System.out.println("student_id : " + studentId);
				System.out.println("password : " + password);
			}
			ConnectionManager.getInstance().closeConnection();
			if(studentId != 0 && password != null)
			{
				if(studentId == inputStudentId && password == inputPassword)
				{
					return true;
				}
			}
		} 
		catch (ClassNotFoundException | SQLException e1) 
		{
			e1.printStackTrace();
		}
		return false;
	}
}
