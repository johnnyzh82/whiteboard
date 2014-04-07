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
        String password = request.getParameter("password_signin").trim();
        boolean valid = false;
        if(!"".equals(studentId) && !"".equals(password))
        {
        	Integer studentIdNum = Integer.valueOf(studentId);
            valid = DbManager.validateUser(studentIdNum, password);
           
        }
        
        if(!valid)
        {
        	request.setAttribute("ValidUser", valid);
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
    		dispatcher.forward(request, response);
        }
        else
        {
        	HttpSession session = request.getSession();
        	String username = (String)request.getAttribute("un");
        	session.setAttribute("UserName", username);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
    }
 
}