  <jsp:include page="includes/header.jsp" />
  
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
            <a class="navbar-brand" href="./login.jsp">WhiteBoard</a>
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

          <form class="form-horizontal">
            <div class="panel-body">
                <fieldset>
                    <legend><span class="glyphicon glyphicon-user"></span> Basic Information</legend>
                    <div class="form-group">
                      <div align='left' class='col-sm-2'>
	                      <label for="inputStudentId" class="control-label">* Student Id:</label>
                      </div>
                      <div class="col-sm-6">
                        <input type="text" class="form-control" id="inputStudentId" placeholder="Student id" value="${student_id_signup}"/>                     
                      </div>               
                    </div>

                    <div class="form-group">
                      <div align='left' class='col-sm-2'>
                      	<label for="inputPassword" class="control-label">* Password:</label>
                      </div>
                      <div class="col-sm-6">
                        <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                      </div>
                    </div>
                    
                    <div class="form-group">
                    	<div align='left' class='col-sm-2'>
                      <label for="inputPassword" class="control-label">* Retype Password:</label>
                      </div>
                      <div class="col-sm-6">
                        <input type="password" class="form-control" id="inputRepassword" placeholder="Retype Password">
                      </div>
                    </div>
                    
                    <div class="form-group">
                    	<div class="col-sm-offset-2 col-sm-6">
                    		<span class="text-muted">Use at least one lowercase letter, one numeral, and seven characters.</span>
                   		</div>
                	</div>
                </fieldset>

                <fieldset>
                    <legend><span class="glyphicon glyphicon-tag"></span>Full Name</legend>
                    <div class="form-group">
                	  <div align='left' class='col-sm-2'>
                      	<label for="inputFisrtName" class="control-label">* First Name:</label>
                      </div>
                      <div class="col-sm-6">
                        <input type="text" class="form-control" id="inputFisrtName" placeholder="First Name" value="${first_name_signup}">
                      </div>
                    </div>
                    
                    <div class="form-group">
                   	  <div align='left' class='col-sm-2'>
                      	<label for="inputLastName" class="control-label">* Last Name:</label>
                      </div>
                      <div class="col-sm-6">
                        <input type="text" class="form-control" id="inputLastName" placeholder="Last Name" value="${last_name_signup}">
                      </div>
                    </div>

                </fieldset>

                <fieldset>
                    <legend><span class="glyphicon glyphicon-envelope"></span> Contact</legend>
                    <div class="form-group">
                    	<div align='left' class='col-sm-2'>
                        	<label for="inputEmail" class="control-label">* Email:</label>
                        </div>
                        <div class="col-sm-6">
                          <input type="email" class="form-control" id="inputEmail" placeholder="Email" value="${email_signup}">
                        </div>
                    </div>
                    
                    <div class="form-group">
                    	<div align='left' class='col-sm-2'>
                        	<label for="inputPhone" class="control-label">Phone:</label>
                        </div>
                        <div class="col-sm-6">
                          <input type="text" class="form-control" id="inputPhone" placeholder="Phone">
                        </div>
                    </div>

                    <div class="form-group">
                    	<div align='left' class='col-sm-2'>
                        	<label for="inputAddress" class="control-label"> Address:</label>
                        </div>
                        <div class="col-sm-6">
                          <input type="text" class="form-control" id="inputAddress" placeholder="Address">
                        </div>
                    </div>
                    
                    <div class="form-group">
                    	<div align='left' class='col-sm-2'>
                        	<label for="inputCity" class="control-label"> City:</label>
                        </div>
                        <div class="col-sm-6">
                          <input type="text" class="form-control" id="inputCity" placeholder="City">
                        </div>
                    </div>
                    
                    <div class="form-group">
                    <div align='left' class='col-sm-2'>
                        <label for="inputZipcode" class="control-label"> Zipcode:</label>
                        </div>
                        <div class="col-sm-6">
                          <input type="number" class="form-control" id="inputCity" placeholder="Zipcode">
                        </div>
                    </div>

                    <div class="form-group">
                      <div class="col-sm-offset-2 col-sm-6">
                        <div class="checkbox">
                          <label>
                            <input id="contactPrivate" type="checkbox"> Private
                          </label>
                        </div>
                      </div>
                    </div>                    
                  </fieldset>

                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
                      <button type="button" class="btn btn-primary btn-lg btn-block">Create My Account</button>
                    </div>
                  </div>
                  
                  <div class="row">
                    <div class="alert alert-success alert-dismissable col-md-offset-3 col-md-6">
                      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                      <strong>Success!</strong> THe record is saved.
                    </div>
                  </div>

                  <div class="row">
                    <div class="alert alert-danger alert-dismissable col-md-offset-3 col-md-6">
                      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                      <strong>Error!</strong> The record is not saved.
                    </div>
                  </div>
              </div>
      </form>
      </div>
</div>
<jsp:include page="includes/footer.jsp" />