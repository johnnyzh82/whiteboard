package com.whiteboard;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginController() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
//    	UserBeanModel user = new UserBeanModel();
    	String studentId = request.getParameter("student_id").trim();
        String password = request.getParameter("password").trim();
//        user.setStudentId(studentId);
//        user.setPassword(password);
//        request.setAttribute("User", user);
        boolean valid = false;
        if(!"".equals(studentId) && !"".equals(password))
        {
        	Integer studentIdNum = Integer.valueOf(studentId);
            valid = DbManager.validateUser(studentIdNum, password);
            request.setAttribute("ValidUser", valid);
        }
        else
        {
        	request.setAttribute("ValidUser", "blank");
        }
        
        
        if(!valid)
        {
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
    		dispatcher.forward(request, response);
        }
        else
        {
        	//direct to the my profile page
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
    }
 
}