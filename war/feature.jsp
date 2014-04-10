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
          <a class="navbar-brand" href="./login">WhiteBoard</a>
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
        <div id="schedule" style="background-color:lightgrey;height:400px;width:300px;float:left;">
          <b style="font-family:verdana;font-size:15px;">Schedule Service</b><br>
              <br>
              nowadays, universities pay increasingly more attention to the team work ability of their students. Schedule Service provides students with a convenient and efficient platform to improve their team-oriented abilities. It includes two sub-features:<br>
              <br>
              Find A Group: this sub-feature enables students to find out a study group according to the students' searching criteria. It could also enable students to establish a study group according to the students' preferences.<br>
              <br>
              Schedule Common Time: this sub-feature enables two or more students to find out their common available time easily.This service generates a common time table automatically and electronically.<br>
        </div>

        <div id="interval1" style="background-color: #ffffff;opacity: .4;height:400px;width:20px;float:left;">
        </div>

        <div id="tutor" style="background-color:lightblue;height:400px;width:300px;float:left;">
         <b style="font-family:verdana;font-size:15px;">Tutor Service</b><br>
              <br>
              The help from tutoring could be very beneficial for these students who are in trouble with their study. This feature provides students with a convinient way to find out their desirable tutors. It includes two sub-features:<br>
              <br>
              Find A Tutor: this sub-feature enables students to find out desirable tutors according to the students' searching criteria.<br>
              <br>
              Register as A Tutor: this sub-feature enables these students who want to be tutors to make their advertisement.<br>
        </div>

        <div id="interval2" style="background-color: #ffffff;opacity: .4;height:400px;width:20px;float:left;">
        </div>

        <div id="textbook" style="background-color:#EEEEEE;height:400px;width:300px;float:left;">
           <b style="font-family:verdana;font-size:15px;">Trading Textbooks</b><br>
              <br>
              Many students are worried how to purchase or sell textbooks at the beginning of every semester. Compared with the traditional ways to purchase or sell textbooks, this service is very efficient and effective. It includes two sub-features:<br>
              <br>
              Purchase Textbooks: this sub-feature enables students to find out desirable textbooks according to the students' searching criteria. These students could get the list of all the appropriate books, and compare them to get the best one.<br>
              <br>
              Sell Textbooks: this sub-feature enables these students who want to sell textbooks to make their advertisement.<br>
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