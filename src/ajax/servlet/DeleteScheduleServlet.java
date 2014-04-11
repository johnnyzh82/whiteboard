package ajax.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import whiteboard.bean.ScheduleBeanModel;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class DeleteScheduleServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    /***************************************************
     * URL: /updateScheduleServlet
     * doPost(): receives JSON , parse it, map it and send back as JSON
     ****************************************************/
    public DeleteScheduleServlet() {  
        super();   
    }  
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	String id = request.getParameter("id");
    	/*
    	 * call the ajax manager and store everything to bean
    	 */
    	Integer schedule_id = Integer.valueOf(id);	
    	boolean succeed = AjaxDBManager.deleteSchedule(schedule_id);
    	
    	JSONObject json = new JSONObject();
    	response.setContentType("text/json");  
    	// Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8");
	    try {
			json.put("succeed", succeed);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	PrintWriter out = response.getWriter();
    	out.write(json.toString());
    }
}