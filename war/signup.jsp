  <%@ include file="includes/header.jsp" %>
  
    <div class="navbar navbar-inverse">
      <div class="container">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="./login">WhiteBoard</a>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <jsp:include page="includes/searchddl.jsp" />
      </div><!-- /.container-fluid -->
    </div>
	
    <div class="container">
        <div class="panel panel-success">
          <div class="panel-heading">
            <h3>Join WhiteBoard Today.</h3>
          </div>
		  <c:choose>
		  <c:when test="${not empty set_loading && set_loading eq true}">
		  	  <meta http-equiv="Refresh" content="5;url=login.jsp">
			  <div class="panel-body">
	            	<div class="alert alert-success col-md-6 col-md-offset-3">
	            		<img src="./lib/image/ajax-loader.gif"/> Creating account
	            	</div>
	          </div>
          </c:when>
          
          <c:when test="${not empty set_loading && set_loading eq false}">
		  	  <meta http-equiv="Refresh" content="30;url=login.jsp">
			  <div class="panel-body">
	            	<div class="alert alert-danger col-md-6 col-md-offset-3">
	            		Saving record error, check connection
	            	</div>
	          </div>
          </c:when>
          
          <c:otherwise>
          <form action='/user' method="POST" class="form-horizontal">
            <div class="panel-body">
                <fieldset>
                    <legend><span class="glyphicon glyphicon-user"></span> Basic Information</legend>
                    <c:if test="${not empty valid_id}">
			 			<c:set value="has-error" var="id_error"></c:set>
			 			<c:set value="${valid_id}" var="student_id_signup"></c:set>
				  	</c:if>
				  	<c:if test="${not empty valid_id_format}">
			 			<c:set value="has-error" var="id_error"></c:set>
			 			<c:set value="${valid_id_format}" var="student_id_signup"></c:set>
				  	</c:if>
                    <div class="form-group ${id_error}">
                      <div align='left' class='col-sm-2'>
	                      <label for="inputStudentId" class="control-label">* Student Id:</label>
                      </div>
                      <div class="col-sm-5">              
                        <input type="text" class="form-control" id="inputStudentId" name="inputStudentId" placeholder="Student id" value="${student_id_signup}" required/>                 
                      </div>
                      	
                      <c:if test="${not empty valid_id}">
	                      <div class="alert alert-danger alert-dismissable col-md-5">
		                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		                    <strong>Failed</strong> The student id has already been registered.
	                  	  </div> 
                  	  </c:if>
                  	  <c:if test="${not empty valid_id_format}">
	          	          <div class="alert alert-danger alert-dismissable col-md-5">
		                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		                    <strong>Failed</strong> Id must be a 1-11 digital number.
	                  	  </div>
                  	  </c:if>          
                    </div> 
                    
                    <c:if test="${not empty valid_password}">
	                   <c:set value="has-error" var="password_error"></c:set>
	                   <c:set value="bg-danger" var="password_error_msg"></c:set>
                 	</c:if>
                    <div class="form-group ${password_error}">
                      <div align='left' class='col-sm-2'>
                      	<label for="inputPassword" class="control-label">* Password:</label>
                      </div>
                      <div class="col-sm-5">
                        <input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Password" required>
                      </div>
                      
                      <c:if test="${not empty valid_password}">
	                      <div class="alert alert-danger alert-dismissable col-md-5">
		                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		                    <strong>Failed</strong> Password input aren't valid.
	                  	  </div>
                  	  </c:if>
                    </div>
                    
                    <div class="form-group ${password_error}">
                      <div align='left' class='col-sm-2'>
                      	<label for="inputRepassword" class="control-label">Retype Password:</label>
                      </div>
                      <div class="col-sm-5">
                        <input type="password" class="form-control" id="inputRepassword" name="inputRepassword" placeholder="Retype Password" required>
                      </div>
                    </div>
                    
                    <div class="form-group">
                    	<div class="col-sm-offset-2 col-sm-10">
                    		<span class="text-muted ${password_error_msg}">Use at least one, uppercase letter, one lowercase letter, one numeral, and minimal seven characters.</span>
                   		</div>
                	</div>
                </fieldset>

                <fieldset>
                    <legend><span class="glyphicon glyphicon-tag"></span>Full Name</legend>
                    <c:if test="${not empty valid_firstname}">
	                   <c:set value="${valid_firstname}" var="first_name_signup"></c:set>
                  	</c:if>
                    <div class="form-group">
                	  <div align='left' class='col-sm-2'>
                      	<label for="inputFisrtName" class="control-label">* First Name:</label>
                      </div>
                      <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputFisrtName" name="inputFirstName" placeholder="First Name" value="${first_name_signup}" required>
                      </div>
                    </div>
                    
                    <c:if test="${not empty valid_lastname}">
	                   <c:set value="${valid_lastname}" var="last_name_signup"></c:set>
                  	</c:if>
                    <div class="form-group">
                   	  <div align='left' class='col-sm-2'>
                      	<label for="inputLastName" class="control-label">* Last Name:</label>
                      </div>
                      <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputLastName" name="inputLastName" placeholder="Last Name" value="${last_name_signup}" required>
                      </div>
                    </div>
                </fieldset>

                <fieldset>
                    <legend><span class="glyphicon glyphicon-envelope"></span> Contact</legend>
                    <div class="form-group">
                    	<div align='left' class='col-sm-2'>
                        	<label for="inputEmail" class="control-label">* Email:</label>
                        </div>
                        <div class="col-sm-5">
                          <input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="Email" value="${email_signup }" required>
                        </div>
                    </div>
                    
                    <div class="form-group">
                    	<div align='left' class='col-sm-2'>
                        	<label for="inputPhone" class="control-label">Phone:</label>
                        </div>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="inputPhone" name="inputPhone" placeholder="Phone" value="${valid_phone}">
                        </div>
                    </div>

                    <div class="form-group">
                    	<div align='left' class='col-sm-2'>
                        	<label for="inputAddress" class="control-label"> Address:</label>
                        </div>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="inputAddress" name="inputAddress" placeholder="Address" value="${valid_address}">
                        </div>
                    </div>
                    
                    <div class="form-group">
                    	<div align='left' class='col-sm-2'>
                        	<label for="inputCity" class="control-label"> City:</label>
                        </div>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="inputCity" name="inputCity" placeholder="City" value="${valid_city}">
                        </div>
                    </div>
                    
                    <c:if test="${not empty valid_zip}">
			 			<c:set value="has-error" var="zip_error"></c:set>
			 			<c:set value="${valid_zip}" var="zip_signup"></c:set>
                    </c:if>
                    <div class="form-group ${zip_error} }">
                    <div align='left' class='col-sm-2'>
                        <label for="inputZipcode" class="control-label"> Zipcode:</label>
                        </div>
                        <div class="col-sm-5">
                          <input type="number" class="form-control" id="inputZipcode" name="inputZipcode" placeholder="Zipcode" value="${zip_signup}">
                        </div>
                        
                        <c:if test="${not empty valid_zip}">
					    <div class="alert alert-danger alert-dismissable col-md-5">
					    	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					    	<strong>Failed!</strong> Zipcode must be a numerical value.
					 	</div>
					 	</c:if>
                    </div>

                    <div class="form-group">
                      <div class="col-sm-offset-2 col-sm-5">
                        <div class="checkbox">
                          <label>
                          	<c:choose>
	                          	<c:when test="${isContactPrivate eq 'on'}">
	                            	<input id="contactPrivate" name="contactPrivate" type="checkbox" checked>
	                            </c:when>
	                            <c:otherwise>
	                            	<input id="contactPrivate" name="contactPrivate" type="checkbox">
	                            </c:otherwise>
                          	</c:choose>  	
                            Private 
                            <i>(I want to make information private to others besides those students who trade with me)</i>
                          </label>
                        </div>
                      </div>
                    </div>                    
                  </fieldset>

                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-5">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">Create My Account</button>
                  </div>
                </div> 	
          </div>  
      </form>
      </c:otherwise>
      </c:choose>
      </div>
</div>
<jsp:include page="includes/footer.jsp" />