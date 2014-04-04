package ajaxServlet;
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 
    	String studentId = request.getParameter("id");
    	System.out.println(studentId);
    	Integer studentIdNum = 0;
    	boolean valid = false;
    	try
    	{
    		studentIdNum = Integer.valueOf(studentId);
	  		valid = AjaxDBManager.validateUser(studentIdNum);
		}
    	catch (NumberFormatException e) 
    	{
    		valid = false;
		}
    	System.out.println(valid);
    	response.setContentType("text/plain");  
    	// Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	out.println(valid);
    }
}