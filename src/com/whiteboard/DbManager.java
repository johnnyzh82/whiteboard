package com.whiteboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.google.appengine.api.utils.SystemProperty;

public class DbManager {
	
	private static Connection conn = ConnectionManager.getInstance().getConnection();
	
	
	public static boolean validateUser(Integer inputStudentId,  String inputPassword)
	{
		boolean valid = false;
		try {	
			 if (SystemProperty.environment.value() ==
			          SystemProperty.Environment.Value.Production) {
			Class.forName("com.mysql.jdbc.GoogleDriver");}
			 else{
			Class.forName("com.mysql.jdbc.Driver");
			 }
			//Constructing the SQL query
			Integer studentId = 0;
			String password = null;
			
			String existence_sql = "SELECT Count(*) as num FROM wb_students where student_id = ?;";
			PreparedStatement pstmt1 = conn.prepareStatement(existence_sql);
			pstmt1.setInt(1, inputStudentId);
			ResultSet rs1 = pstmt1.executeQuery();
			
			int count = 0;
			while (rs1.next()) 
			{
				count  = rs1.getInt("num");
			}
			
			if(count > 0)
			{
				String sql = "SELECT * FROM wb_students where student_id = ? and password = ?;";
				PreparedStatement pstmt2 = conn.prepareStatement(sql);
				pstmt2.setInt(1, inputStudentId);
				pstmt2.setString(2, inputPassword);
				ResultSet rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					studentId  = Integer.valueOf(rs2.getInt("student_id"));
					password = rs2.getString("password");
	 
					System.out.println("student_id : " + studentId);
					System.out.println("password : " + password);
				}
				ConnectionManager.getInstance().closeConnection();
				if(studentId.equals(inputStudentId) && password.equals(inputPassword)) 
				{
					valid = true;
				} 
			}
		} 
		catch (ClassNotFoundException | SQLException e1) 
		{
			e1.printStackTrace();
		}
		return valid;
	}
}
