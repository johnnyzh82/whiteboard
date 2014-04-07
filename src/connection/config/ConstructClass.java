package connection.config;

import com.google.appengine.api.utils.SystemProperty;

public class ConstructClass {
	public static void constructClass()
	{
		try
		{
			if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) 
			{
				Class.forName("com.mysql.jdbc.GoogleDriver");
			}
			else 
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
