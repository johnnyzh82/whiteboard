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

public class UpdateScheduleServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    /***************************************************
     * URL: /updateScheduleServlet
     * doPost(): receives JSON , parse it, map it and send back as JSON
     ****************************************************/
    public UpdateScheduleServlet() {  
        super();   
    }  
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	String id = request.getParameter("id");
    	String date = request.getParameter("date");
    	String title = request.getParameter("title");
    	String startTime = request.getParameter("startTime");
    	String endTime = request.getParameter("endTime");
    	String description = request.getParameter("description");

    	/*
    	 * call the ajax manager and store everything to bean
    	 */
    	HttpSession session = request.getSession();
		Integer student_id = (Integer) session.getAttribute("user_id");
    	ScheduleBeanModel schedule = new ScheduleBeanModel();
    	
    	Integer schedule_id = Integer.valueOf(id);
    	schedule.setSchedule_id(schedule_id);
    	schedule.setStudentId(student_id);
    	schedule.setTitle(title);
    	schedule.setDate(date);
    	schedule.setStartTime(startTime);
    	schedule.setEndTime(endTime);
    	if(description != null && !description.equals("")){ schedule.setDescription(description); }
    	
    	boolean valid = AjaxDBManager.updateSchedule(schedule);
    	
    	JSONObject json = new JSONObject();
    	response.setContentType("text/json");  
    	// Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8");
	    try {
			json.put("succeed", valid);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	PrintWriter out = response.getWriter();
    	out.write(json.toString());
    }
}