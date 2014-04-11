package ajax.servlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			while (rs.next()){
				count  = rs.getInt("num");
			}
			rs.close();
			pstmt.close();
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
		String date = schedule.getDate();
		String startTime = schedule.getStartTime();
		String endTime = schedule.getEndTime();
		String title = schedule.getTitle();
		String descirption = schedule.getDescription();
		/*
		 * Construct the insertion String to mysql datetime type column
		 * INSERT INTO table_name (column1,column2,column3,...)
		 * VALUES (value1,value2,value3,...);
		 */
		String insert_sql = "INSERT INTO wb_schedule (student_id, title, date, start_time, end_time, description, is_active) "
				+ " values(?,?,?,?,?,?,?);";
		try {
			PreparedStatement dbStatement = conn.prepareStatement(insert_sql);
			dbStatement.setInt(1, id);
			dbStatement.setString(2, title);
			dbStatement.setString(3, date);
			dbStatement.setString(4, startTime);
			dbStatement.setString(5, endTime);
			if(descirption!=null){dbStatement.setString(6, descirption);}else{dbStatement.setNull(6, java.sql.Types.VARCHAR);}
			dbStatement.setInt(7, 1);
			//execute the Insertion
			dbStatement.executeUpdate();
			//close the connection
			dbStatement.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static ArrayList<ScheduleBeanModel> getSchedules(Integer user_id){
		/*
		 * Select all schedules for given user_id
		 */
		String insert_sql = "SELECT * FROM wb_schedule "
				+ "WHERE is_active = 1 and student_id = ?";
		try {
			PreparedStatement dbStatement = conn.prepareStatement(insert_sql);
			dbStatement.setInt(1, user_id);
			// Create a schedule model
			ArrayList <ScheduleBeanModel> schedules = new ArrayList<>();
			ResultSet rs = dbStatement.executeQuery();
			while (rs.next()){
				ScheduleBeanModel schedule = new ScheduleBeanModel();
				Integer scheduleId  = rs.getInt("schedule_id");
				Integer studentId = rs.getInt("student_id");
				String date = rs.getString("date");
				String startTime = rs.getString("start_time");
				String endTime = rs.getString("end_time");
				String title = rs.getString("title");
				String description = rs.getString("description");
				//store it to bean
				schedule.setSchedule_id(scheduleId);
				schedule.setStudentId(studentId);
				schedule.setDate(date);
				schedule.setStartTime(startTime);
				schedule.setEndTime(endTime);
				schedule.setTitle(title);
				schedule.setDescription(description);
				schedules.add(schedule);
			}
			rs.close();
			dbStatement.close();
			return schedules;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static ScheduleBeanModel getSchedule(Integer schedule_id){
		/*
		 * Select all schedules for given user_id
		 */
		String insert_sql = "SELECT * FROM wb_schedule "
				+ "WHERE is_active = 1 and schedule_id = ?";
		try {
			PreparedStatement dbStatement = conn.prepareStatement(insert_sql);
			dbStatement.setInt(1, schedule_id);
			// Create a schedule model
			ResultSet rs = dbStatement.executeQuery();
			ScheduleBeanModel schedule = new ScheduleBeanModel();
			while (rs.next()){
				Integer scheduleId  = rs.getInt("schedule_id");
				Integer studentId = rs.getInt("student_id");
				String date = rs.getString("date");
				String startTime = rs.getString("start_time");
				String endTime = rs.getString("end_time");
				String title = rs.getString("title");
				String description = rs.getString("description");
				//store it to bean
				schedule.setSchedule_id(scheduleId);
				schedule.setStudentId(studentId);
				schedule.setDate(date);
				schedule.setStartTime(startTime);
				schedule.setEndTime(endTime);
				schedule.setTitle(title);
				schedule.setDescription(description);
			}
			rs.close();
			dbStatement.close();
			return schedule;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean updateSchedule(ScheduleBeanModel schedule){
		/*
		 * Select all schedules for given user_id
		 */
		String insert_sql = "SELECT * FROM wb_schedule "
				+ "WHERE is_active = 1 and schedule_id = ?";
		try {
			PreparedStatement dbStatement = conn.prepareStatement(insert_sql);
			dbStatement.setInt(1, schedule.getSchedule_id());
			// Create a schedule model
			ResultSet rs = dbStatement.executeQuery();
			/*
			 * UPDATE Customers
			 * SET ContactName='Alfred Schmidt', City='Hamburg'
			 * WHERE CustomerName='Alfreds Futterkiste';
			 */
			String update_sql = "UPDATE wb_schedule "
					+ "SET ";
			Integer scheduleId = null;
			String startTime = null;
			String endTime = null;
			String title = null;
			String description = null;
			while (rs.next()){
				scheduleId = rs.getInt("schedule_id");
//				Integer studentId = rs.getInt("student_id");
//				String date = rs.getString("date");
				startTime = rs.getString("start_time");
				endTime = rs.getString("end_time");
				title = rs.getString("title");
				description = rs.getString("description");
				if(!startTime.equals(schedule.getStartTime())){
					update_sql += " start_time = ?, ";
				}
				if(!endTime.equals(schedule.getEndTime())){
					update_sql += " end_time = ?, ";
				}
				if(!title.equals(schedule.getTitle())){
					update_sql += " title = ?, ";
				}
				if(!description.equals(schedule.getDescription())){
					update_sql += " description = ?, ";
				}
				update_sql += " schedule_id = ? WHERE schedule_id = ?;";
			}
			rs.close();
			dbStatement.close();
			
			int counter = 1;
			PreparedStatement dbStatement2 = conn.prepareStatement(update_sql);
			if(!startTime.equals(schedule.getStartTime())){
				dbStatement2.setString(counter, schedule.getStartTime());
				counter ++;
			}
			if(!endTime.equals(schedule.getEndTime())){
				dbStatement2.setString(counter, schedule.getEndTime());
				counter ++;
			}
			if(!title.equals(schedule.getTitle())){
				dbStatement2.setString(counter, schedule.getTitle());
				counter ++;
			}
			if(!description.equals(schedule.getDescription())){
				dbStatement2.setString(counter, schedule.getDescription());
				counter ++;
			}
			dbStatement2.setInt(counter, scheduleId);counter++;
			dbStatement2.setInt(counter, scheduleId);
			dbStatement2.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static boolean deleteSchedule(Integer schedule_id){
		/*
		 * Select all schedules for given user_id
		 */
		String insert_sql = "UPDATE wb_schedule "
				+ " SET is_active = 0 "
				+ " WHERE schedule_id = ?; ";
		try {
			PreparedStatement dbStatement = conn.prepareStatement(insert_sql);
			dbStatement.setInt(1, schedule_id);
			// Create a schedule model
			dbStatement.executeUpdate();
			dbStatement.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
