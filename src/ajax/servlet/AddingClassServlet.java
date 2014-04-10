package ajax.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import whiteboard.bean.ScheduleBeanModel;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class AddingScheduleServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    /***************************************************
     * URL: /AddingScheduleServlet
     * doPost(): receives JSON data, parse it, map it and send back as JSON
     ****************************************************/
    
    public AddingScheduleServlet() {  
        super();   
    }  
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	boolean isRepeat = Boolean.valueOf(request.getParameter("isRepeat"));
    	String repeatOption = request.getParameter("repeatOption");
    	String repeatDay = request.getParameter("repeatDay");
    	String repeatMonth = request.getParameter("repeatMonth");
    	String repeatWeek = request.getParameter("repeatWeek");
    	String startTime = request.getParameter("startTime");
    	String endTime = request.getParameter("endTime");
    	String startDate = request.getParameter("startDate");
    	String endDate = request.getParameter("endDate");
    	String description = request.getParameter("description");
    	System.out.println(isRepeat);
    	System.out.println(repeatOption);
    	System.out.println(repeatDay);
    	System.out.println(repeatMonth);
    	System.out.println(repeatWeek);
    	System.out.println(startTime);
    	System.out.println(endTime);
    	System.out.println(startDate);
    	System.out.println(endDate);
    	System.out.println(description);
    	/*
    	 * convert json string to object for weekly customized days 
    	 */
    	System.out.println("what is" + repeatWeek + "what is this");
		JSONObject repeatWeeks = null;
    	if(!repeatWeek.equals("")){
    		try {  			
    			System.out.println("goes to here");
				repeatWeeks = new JSONObject(repeatWeek);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	/*
    	 * convert repeat day/month to interval
    	 */
		int interval = 0;
    	if(!repeatDay.equals("")){	interval = Integer.valueOf(repeatDay);	}
    	else if(!"".equals(repeatMonth)){	interval = Integer.valueOf(repeatMonth);	}
    	
    	/*
    	 * convert repeat day/month to interval when choose repeat option daily/monthly
    	 * dd/MM/yyyy HH::mma date format for example "14/09/2011 12:00pm" sample
    	 */
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa", Locale.ENGLISH);
        Date convertedStartDate = null;
        Date convertedEndDate = null;
    	if(!"".equals(startDate) && !"".equals(startTime)){
    		try {
    			String date = startDate + " " + startTime;
				convertedStartDate = (Date) formatter.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Date from dd/MM/yyyy HH::mm a String in Java : " + convertedStartDate);
    	}
    	if(!"".equals(endDate) &&  !"".equals(endTime)){
            try {   
            	String date = endDate + " " + endTime;
				convertedEndDate = (Date) formatter.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Date from dd/MM/yyyy HH::mm a String in Java : " + convertedEndDate);
    	}
    	
    	/*
    	 * call the ajax manager and store everything to bean
    	 */
    	HttpSession session = request.getSession();
		Integer student_id = (Integer) session.getAttribute("user_id");
    	ScheduleBeanModel schedule = new ScheduleBeanModel();
    	schedule.setStudentId(student_id);
    	schedule.setRepeat(isRepeat); 
    	if(repeatOption != null && !repeatOption.equals("")){ schedule.setRepeatOption(repeatOption); }
    	schedule.setInterval(interval);
    	if(repeatWeek != null && !repeatWeek.equals("")){ schedule.setWeeklyDays(repeatOption); }
    	if(convertedStartDate != null){ schedule.setStart(convertedStartDate); }
    	if(convertedEndDate != null){ schedule.setEnd(convertedEndDate); }
    	if(description != null && description!=""){ schedule.setDescription(description); }
    	boolean valid = AjaxDBManager.insertSchedule(schedule);
    	
    	JSONObject json = new JSONObject();
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