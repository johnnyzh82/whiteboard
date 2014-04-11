package ajax.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import whiteboard.bean.ScheduleBeanModel;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class LoadingScheduleServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    /***************************************************
     * URL: /LoadingScheduleServlet
     * doPost(): receives JSON , parse it, map it and send back as JSON
     ****************************************************/
    public LoadingScheduleServlet() {  
        super();   
    }  
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	/*
    	 * call the ajax manager and store everything to bean
    	 */
    	String scheduleId = request.getParameter("id"); 	
    	Integer schedule_id = Integer.valueOf(scheduleId);
    	ScheduleBeanModel schedule = AjaxDBManager.getSchedule(schedule_id);
    	JSONObject jsonObj =new JSONObject();
    	try{
    		 jsonObj.put("id", schedule.getSchedule_id());
    		 jsonObj.put("date", schedule.getDate());
    		 jsonObj.put("start",  schedule.getStartTime());
    		 jsonObj.put("end", schedule.getEndTime());
    		 jsonObj.put("title", schedule.getTitle());
    		 jsonObj.put("description", schedule.getDescription());
    	}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	response.setContentType("text/json");  
    	// Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	out.write(jsonObj.toString());
    }   
}