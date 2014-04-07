package com.whiteboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import whiteboard.bean.UserBeanModel;
import connection.config.ConnectionManager;
import connection.config.ConstructClass;

public class DbManager {
	
	private static Connection conn = ConnectionManager.getInstance().getConnection();
	public static boolean validateUser(Integer inputStudentId,  String inputPassword)
	{
		boolean valid = false;
		try {	
			ConstructClass.constructClass();
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
				}
				ConnectionManager.getInstance().closeConnection();
				if(studentId.equals(inputStudentId) && password.equals(inputPassword)) 
				{
					valid = true;
				} 
			}
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return valid;
	}

	public static boolean insertUser(UserBeanModel user){
		Integer id = user.getStudentId();
		String password = user.getPassword();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String phone = user.getPhone();
		String address = user.getAddress();
		String city = user.getCity();
		Integer zipcode = user.getZipcode();
		boolean isPrivate = user.isPrivate();
		
		ConstructClass.constructClass();
		String insert_sql = "INSERT INTO wb_students values(?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement dbStatement = conn.prepareStatement(insert_sql);
			dbStatement.setInt(1, id);
			dbStatement.setString(2, password);
			dbStatement.setString(3, firstName);
			dbStatement.setString(4, lastName);
			dbStatement.setString(5, phone);
			dbStatement.setString(6, email);
			dbStatement.setString(7, address);
			dbStatement.setString(8, city);
			if(zipcode!=null){dbStatement.setInt(9, zipcode);}else{dbStatement.setNull(9, java.sql.Types.INTEGER);};
			dbStatement.setInt(10, 1);
			dbStatement.setBoolean(11, isPrivate);
			dbStatement.executeUpdate();
			ConnectionManager.getInstance().closeConnection();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
}
