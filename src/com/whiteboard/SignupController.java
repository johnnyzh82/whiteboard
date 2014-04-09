package com.whiteboard;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

public class SignupController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public SignupController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String studentId = request.getParameter("student_id");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
         
        if( !"".equals(studentId)){	request.setAttribute("student_id_signup", studentId); } 
        if( !"".equals(firstName)){ request.setAttribute("first_name_signup", firstName); }
    	if( !"".equals(lastName)){ request.setAttribute("last_name_signup", lastName); }
		if(	!"".equals(email)){ request.setAttribute("email_signup", email); }
       
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/signup.jsp");
		dispatcher.forward(request, response);
    }
}