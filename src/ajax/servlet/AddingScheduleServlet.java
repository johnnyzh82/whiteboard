package ajax.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	
    	/*
    	 * convert json string to object for weekly customized days 
    	 */
    	@SuppressWarnings("unused")
		JSONObject repeatWeeks = null;
    	if(repeatWeek!=null && !"".equals(repeatWeek)){
    		try {
				repeatWeeks = new JSONObject(repeatWeek);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	/*
    	 * convert repeat day/month to interval
    	 */
    	@SuppressWarnings("unused")
		int interval = 0;
    	if(repeatDay!=null && !"".equals(repeatDay)){	interval = Integer.valueOf(repeatDay);	}
    	else if(repeatMonth!=null && !"".equals(repeatMonth)){	interval = Integer.valueOf(repeatMonth);	}
    	
    	/*
    	 * convert repeat day/month to interval when choose repeat option daily/monthly
    	 * dd/MM/yyyy HH::mma date format for example "14/09/2011 12:00pm" sample
    	 */
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH::mma");
        Date convertedStartDate = null;
        Date convertedEndDate = null;
    	if(startDate!=null && !"".equals(startDate) && startTime!=null && !"".equals(startTime)){
    		try {
				convertedStartDate = (Date) formatter.parse(startDate + " " + startTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Date from dd/MM/yyyy HH::mma String in Java : " + convertedStartDate);
    	}
    	if(endDate!=null && !"".equals(endDate) && endTime!=null && !"".equals(endTime)){
            try {
				convertedEndDate = (Date) formatter.parse(endDate + " " + endTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Date from dd/MM/yyyy HH::mma String in Java : " + convertedEndDate);
    	}
    	
    	/*
    	 * call the ajax manager and store everything to bean
    	 */
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
    	
    	ScheduleBeanModel schedule = new ScheduleBeanModel();
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