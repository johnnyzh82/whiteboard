package com.whiteboard;

import java.io.IOException;

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
    	
    	UserBeanModel user = new UserBeanModel();
        int studentId = Integer.valueOf(request.getParameter("student_id"));
        String password = request.getParameter("password");
        user.setStudentId(studentId);
        user.setPassword(password);
        
        request.setAttribute("User", user);
        boolean valid = DbManager.validateUser(user);
        
//        RequestDispatcher rd = null;
        
        if(valid)
        {
        	System.out.println("Valid User");
        }
        else
        {
        	System.out.println("Not Valid");
        }
    }
 
}