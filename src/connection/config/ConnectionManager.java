package connection.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.google.appengine.api.utils.SystemProperty;
public class ConnectionManager {
	
	private static ConnectionManager instance = null;
	
	private final String USERNAME = "root";
	private final String PASSWORD = "3622723";
	private final String CONN_STRING = "jdbc:mysql://localhost:3306/whiteboard";
	private final String USERNAME_GOOGLE = "root";
	private final String PASSWORD_GOOGLE = "PENNY54950";
	private final String CONN_STRING_GOOGLE = "jdbc:google:mysql://white-test-1:testbylsx/wb1?user=root";
	
	
	private Connection conn = null;
	
	private ConnectionManager(){}
	
	public static ConnectionManager getInstance()
	{
		if(instance == null)
		{
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	private boolean openConnection()
	{
		try {
			if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) 
			{
				conn = DriverManager.getConnection(CONN_STRING_GOOGLE, USERNAME_GOOGLE, PASSWORD_GOOGLE);
			}
			else 
			{
				conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public Connection getConnection()
	{
		if(conn == null)
		{
			if(openConnection())
			{
				System.out.println("Connection Opened");
				return conn;
			}
			else
			{
				return null;
			}
		}
		return conn;
	}
	
	public void closeConnection()
	{
		System.out.println("Closing Connection");
		try {conn.close();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
