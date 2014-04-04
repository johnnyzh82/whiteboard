  <jsp:include page="includes/header.jsp" />
  <div class="navbar navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="login.jsp">WhiteBoard</a>
        </div>

        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="help.jsp">Help</a></li>
            <li><a href="feature.jsp">Feature</a></li>
            <li><a href="contact.jsp">Contact</a></li>
          </ul>
          <form class="navbar-form navbar-right" role="form">
            <div class="form-group">
              <input type="text" placeholder="Student id" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
  </div>

  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron">
      <div class="container">
        <h1>Contact Us</h1>
        <p>Thank you for using Whiteboard Service. Welcome to contact us if you have any question or advice about our service.</p>
        <div id="left-research">

        <p><a class="redtext"></a> <br />
         Leader Programmer <br />
         Yi Zhou<br />
         <a href="mailto:zy1992000@gmail.com">zy1992000@gmail.com</a> </p>
        </p>

        <p><a class="redtext"></a> <br />
         Project Manager <br />
         Haowang <br />
         <a href="mailto:hao.wang5250@gmail.com">hao.wang5250@gmail.com</a> </p>

        <p><a class="redtext"></a> <br />
          Leader Designer<br />
          Shixiong Liu <br />
        <a href="mailto:pennyliu315@gmail.com">pennyliu315@gmail.com</a> </p>

        <p><a class="redtext"></a> <br />
          Database Designer<br />
          Yunlong Zhang <br />
        <a href="mailto:johnnyzh82@gmail.com">johnnyzh82@gmail.com</a> </p>
        </div>
      </div>
  </div>

    

  
  <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h1><span class="glyphicon glyphicon-search"> </span></h1><h2>Scheduling Service</h2>
          <p>Nowadays, universities pay increasingly more attention to the team work ability of their students. This feature provides students with a way to find a study group and to schedule meeting time for a group. </p>
          <!-- <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p> -->
        </div>
        <div class="col-md-4">
          <h1><span class="glyphicon glyphicon-book"></span></h1><h2>Tutor Service</h2>
          <p>The help from tutoring could be very beneficial for the students who are in trouble with their study. This feature enables studnets to find desirable tutors. </p>
       </div>
        <div class="col-md-4">
          <h1><span class="glyphicon glyphicon-pencil"></span></h1><h2>Textbook Trading</h2>
          <p>Many students are worried at the beginning of every semester to sell or purchase textbooks. This feature solves provide studnets with a convient way to trade textbooks. </p>
        </div>
      </div>
    </div>

    <jsp:include page="includes/footer.jsp" />