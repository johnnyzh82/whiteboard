package com.whiteboard;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ajax.servlet.AjaxDBManager;
import whiteboard.bean.UserBeanModel;
 

public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UserController() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	UserBeanModel user = new UserBeanModel();
    	//First step: get all parameters from form
    	String studentId = request.getParameter("inputStudentId").trim();
    	String password = request.getParameter("inputPassword");
    	String rePassword = request.getParameter("inputRepassword");
    	String firstName = request.getParameter("inputFirstName").trim();
    	String lastName = request.getParameter("inputLastName").trim();
    	String email = request.getParameter("inputEmail").trim();
    	String phone = request.getParameter("inputPhone").trim();
    	String address = request.getParameter("inputAddress").trim();
    	String city = request.getParameter("inputCity").trim();
    	String zipcode = request.getParameter("inputZipcode").trim();
    	String isContactPrivate = request.getParameter("contactPrivate");
    	System.out.println(isContactPrivate);
    	//validate data and store
    	boolean valid = true;
    	//validate id
    	//including id format, id existed in database
    	Integer studentIdNum = null;
    	try{
    		studentIdNum = Integer.valueOf(studentId);
	  		boolean existed = AjaxDBManager.validateUser(studentIdNum);
	  		if(existed == true){
	  			request.setAttribute("valid_id", studentId);
	  			valid=!existed;
	  		}
		}
    	catch (NumberFormatException e) 
    	{
    		request.setAttribute("valid_id_format", studentId);
    		System.out.println("password invalid");
    		valid = false;
		}
    	//password
    	//including password format and password = retype password??
    	// At least 7 characters.
        // Contain both upper and lower case alphabetic characters.
        // Contain at least 1 digit.
    	Pattern p = Pattern.compile("^.*(?=.{7,})(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$");
    	Matcher m = p.matcher(password);
    	if (!(m.matches()) || !rePassword.equals(password)){
    		System.out.println("invalid password.");
    		request.setAttribute("valid_password", "password_error");
    		valid = false;
    	} 
    	else{
    		System.out.println("valid password.");
    	}
    	
    	//validate the zipcode, must be numerical
    	Integer zipcodeNum = null;
    	if(!"".equals(zipcode))
    	{
        	try{
        		System.out.println("zipcode is a number");
        		zipcodeNum = Integer.valueOf(zipcode);
    		}
        	catch (NumberFormatException e) 
        	{
        		System.out.println("Zipcode is not valid");
        		request.setAttribute("valid_zip", zipcode);
        		valid = false;
    		}
    	}
    	System.out.println(valid);
    	
    	boolean success = true;
    	if(valid){
	    	user.setStudentId(studentIdNum);
	    	user.setPassword(password);
	    	user.setFirstName(firstName);
	    	user.setLastName(lastName);
	    	user.setEmail(email);
	    	if( !"".equals(phone) && phone != null){user.setPhone(phone);}
	    	if( !"".equals(address) && address != null){user.setAddress(address);}
	    	if( !"".equals(city) && city != null){user.setCity(city);}
	    	if( !"".equals(zipcode) && zipcode != null){user.setZipcode(zipcodeNum);}
	    	if(isContactPrivate == null){	user.setPrivate(false);	}else{	user.setPrivate(true);	}
	    	//store it to database, set session login value 
	    	success = DbManager.insertUser(user);
	    	if(success == true){
		    	request.setAttribute("set_loading", true);
		    	//then remove all attribute in request scope
		    	request.removeAttribute("student_id_signup");
		    	request.removeAttribute("valid_firstname");
		    	request.removeAttribute("valid_lastname");
		    	request.removeAttribute("valid_email");
		    	request.removeAttribute("valid_phone");
		    	request.removeAttribute("valid_city");
		    	request.removeAttribute("isContactPrivate");
		    	request.removeAttribute("valid_password");
		    	request.removeAttribute("valid_zip");
		    	request.removeAttribute("valid_lastname");
		    	request.removeAttribute("valid_id_format");
		    	request.removeAttribute("valid_id");
		    	//store session values
	    		HttpSession session = request.getSession();
	    		session.setAttribute("user_id", studentId);
	    		session.setAttribute("welcome_logging", firstName+" "+lastName);
	    		
		    	//then direct to the my profile page
		    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/signup.jsp");
	    		dispatcher.forward(request, response);
	    	}
    	}
    	if(!valid || !success)
    	{
    		if(!success){request.setAttribute("set_loading", false);}
    		//this is the situation that inputs are not valid, redirect them and display error message
    		request.setAttribute("student_id_signup", studentId);
    		request.setAttribute("valid_firstname", firstName);
    		request.setAttribute("valid_lastname", lastName);
    		request.setAttribute("valid_email", email);
    		request.setAttribute("valid_phone", city);
    		request.setAttribute("valid_address", address);
    		request.setAttribute("valid_city", city);
    		request.setAttribute("zip_signup", zipcode);
    		request.setAttribute("isContactPrivate", isContactPrivate);
    		
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/signup.jsp");
    		dispatcher.forward(request, response);
    	}
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/signup.jsp");
		dispatcher.forward(request, response);
    }
 
}