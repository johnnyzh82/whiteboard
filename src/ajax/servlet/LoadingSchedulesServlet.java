package ajax.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import whiteboard.bean.ScheduleBeanModel;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class LoadingSchedulesServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    /***************************************************
     * URL: /LoadingSchedulesServlet
     * doPost(): receives JSON , parse it, map it and send back as JSON
     ****************************************************/
    public LoadingSchedulesServlet() {  
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
    	HttpSession session = request.getSession();
		Integer student_id = (Integer) session.getAttribute("user_id");
    	ArrayList<ScheduleBeanModel> schedules = new ArrayList<>();	
    	schedules = AjaxDBManager.getSchedules(student_id);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);

    	JSONArray arrayObj = new JSONArray();
    	try{
	    	for(ScheduleBeanModel schedule : schedules){
	    		 JSONObject jsonObj =new JSONObject();
	    		 jsonObj.put("id", schedule.getSchedule_id());
	    		 Date modified_timeStart = sdf.parse(schedule.getDate() + " " + schedule.getStartTime());
	    		 Date modified_timeEnd = sdf.parse(schedule.getDate() + " " + schedule.getStartTime());
	    		 jsonObj.put("title", schedule.getTitle());
	    		 jsonObj.put("start", formatter.format(modified_timeStart));
	    		 jsonObj.put("end", formatter.format(modified_timeEnd));
	    		 jsonObj.put("editable", true);
	    		 jsonObj.put("allDay", false);
	    		 jsonObj.put("color", generateColor());
	    		 arrayObj.put(jsonObj);
	    	}
    	}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	response.setContentType("text/json");  
    	// Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	out.write(arrayObj.toString());
    }
    
    private String generateColor(){
        int red, green, blue;
        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        return "rgb("+red+","+green+","+blue+")";
    }
    
}