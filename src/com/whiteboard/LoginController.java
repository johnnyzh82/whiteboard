package com.whiteboard;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginController() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String studentId = request.getParameter("student_id_signin").trim();
        String password = request.getParameter("password_signin");
        String [] user = null;
        boolean valid = false;
        if(!"".equals(studentId) && !"".equals(password)){
        	Integer studentIdNum = Integer.valueOf(studentId);
            user = DbManager.validateUser(studentIdNum, password); 
            if(user != null){ valid = true;}
        }
        
        if(!valid){
        	request.setAttribute("ValidUser", valid);
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
    		dispatcher.forward(request, response);
        }
        else{
    		HttpSession session = request.getSession();
    		session.setAttribute("user_id", user[0]);
    		session.setAttribute("welcome_logging", user[1]);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	HttpSession session = request.getSession();
    	if(session.getAttribute("user_id") == null){
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
    		dispatcher.forward(request, response);
    	}
    	else{
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/my_profile.jsp");
    		dispatcher.forward(request, response);
    	}
    }
 
}