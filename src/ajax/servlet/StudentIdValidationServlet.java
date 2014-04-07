package ajax.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class StudentIdValidationServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    /***************************************************
     * URL: /StudentIdValidationServlet
     * doPost(): receives JSON data, parse it, map it and send back as JSON
     ****************************************************/
    
    public StudentIdValidationServlet() {  
        super();   
    }  
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	
    	JSONObject json = new JSONObject();
    	
    	String studentId = request.getParameter("id");
    	
    	Integer studentIdNum = 0;
    	boolean valid = false;
    	try{
    		studentIdNum = Integer.valueOf(studentId);
	  		valid = AjaxDBManager.validateUser(studentIdNum);
		}
    	catch (NumberFormatException e) 
    	{
    		valid = false;
		}
    	
    	response.setContentType("text/json");  
    	// Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8");
	    try {
			json.put("valid", valid);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	PrintWriter out = response.getWriter();
    	out.write(json.toString());
    }
}