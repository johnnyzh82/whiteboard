  <jsp:include page="includes/header.jsp" />
  <div class="navbar navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>

          <a class="navbar-brand" href="#">WhiteBoard</a>
        </div>

        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="help.jsp">Help</a></li>
            <li><a href="feature.jsp">Feature</a></li>
            <li><a href="contact.jsp">Contact</a></li>
          </ul>
          <form action="login" method="POST" class="navbar-form navbar-right" role="form">
            <div class="form-group">
              <input type="text" name="student_id_signin" placeholder="Student id" class="form-control">           
            </div>
            <div class="form-group">
              <input type="password" name="password_signin" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
          
        </div>
        <!--/.navbar-collapse -->
      </div>
  </div>
  <div class="container">
  		<table style="width:100%">
  			<c:set var="valid" scope="session" value="${ValidUser}"/>
  			<c:if test="${valid == false}" >
			    <tr id="account_not_exist" class="alert alert-danger">
			        <td valign="middle" align="center">The student id and password are invalid!</td>
			    </tr>
		    </c:if>
		    <c:if test="${valid == 'blank'}" >
	 		    <tr id="account_blank" class="alert alert-danger">
			        <td valign="middle" align="center">The student id and password are blank!</td>
			    </tr>
		    </c:if>
		</table>
  </div>
           
  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron">
      <div class="container">
        <form action="signup" method="GET" class="form-signin" role="form">
          <input type="text" name="student_id" class="form-control" placeholder="Student id">
          <input type="text" name="first_name" class="form-control" placeholder="First name">
          <input type="text" name="last_name" class="form-control" placeholder="Last name">
          <input type="email" name="email" class="form-control" placeholder="Email">
          <button id="login_accept_agreement_submit" class="btn btn-lg btn btn-success btn-block" type="submit">Sign up for WhiteBoard</button><br/>
          <input type="checkbox" id="accept_agreement" name="agreement" checked/><span class="text-muted"> By clicking "Sign up for WhiteBoard", you agree to our terms of service and privacy policy. </span>
        </form>
        <h1>Establish a faster, better communication platform.</h1>
        <p>WhiteBoard provides a platform of group or individual study scheduling, tutor service, trading textbook between students on campus.</p>
      </div>
  </div>

  <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h1><span class="glyphicon glyphicon-search"> </span></h1><h2>Scheduling</h2>
          <p>Nowadays, universities pay increasingly more attention to the team work ability of their students. This feature provides students with a way to find a study group and to schedule meeting time for a group. </p>
        </div>
        <div class="col-md-4">
          <h1><span class="glyphicon glyphicon-book"></span></h1><h2>Trading/Swapping Books</h2>
          <p>The help from tutoring could be very beneficial for the students who are in trouble with their study. This feature enables studnets to find desirable tutors. </p>
       </div>
        <div class="col-md-4">
          <h1><span class="glyphicon glyphicon-pencil"></span></h1><h2>Getting/Providing Tutor</h2>
          <p>Many students are worried at the beginning of every semester to sell or purchase textbooks. This feature solves provide studnets with a convient way to trade textbooks.</p>
        </div>
      </div>
    </div>
    
    <jsp:include page="includes/footer.jsp" />