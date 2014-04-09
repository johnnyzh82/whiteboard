package ajax.servlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import whiteboard.bean.ScheduleBeanModel;
import connection.config.ConnectionManager;

public class AjaxDBManager {
	
	private static Connection conn = ConnectionManager.getInstance().getConnection();
	public static boolean validateUser(Integer inputStudentId)
	{
		boolean valid = false;
		try {
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
	
	public static boolean insertSchedule(ScheduleBeanModel schedule){
		Integer id = schedule.getStudentId();
		Date dateStart = schedule.getStart();
		Date dateEnd = schedule.getEnd();
		Boolean isRepeat = schedule.isRepeat();
		String repeatOption = schedule.getRepeatOption();
		Integer interval = schedule.getInterval();
		String weeklyDays = schedule.getWeeklyDays();
		/*
		 * Construct the insertion String to mysql datetime type column
		 */
		String insert_sql = "INSERT INTO wb_schedule values(?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement dbStatement = conn.prepareStatement(insert_sql);
			dbStatement.setInt(1, id);
			dbStatement.setTimestamp(2, new Timestamp (dateStart.getTime()));
			dbStatement.setTimestamp(3, new Timestamp (dateEnd.getTime()));
			dbStatement.setBoolean(4, isRepeat);
			if(repeatOption!=null){dbStatement.setString(5, repeatOption);}else{dbStatement.setNull(5, java.sql.Types.VARCHAR);}
			if(interval!=null){	dbStatement.setInt(6, interval); }else{	dbStatement.setNull(6, java.sql.Types.INTEGER);	}
			if(weeklyDays!=null){dbStatement.setString(7, weeklyDays);}else{dbStatement.setNull(7, java.sql.Types.VARCHAR);}
			dbStatement.setInt(8, 1);
			//execute the Insertion
			dbStatement.executeUpdate();
			//close the connection
			ConnectionManager.getInstance().closeConnection();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
