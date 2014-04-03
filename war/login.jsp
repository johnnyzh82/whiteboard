  <jsp:include page="includes/header.jsp" />
  <body>
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
            <li><a href="#">Help</a></li>
            <li><a href="#">Feature</a></li>
            <li><a href="#">Contact</a></li>
          </ul>
          <form action="login" method="POST" class="navbar-form navbar-right" role="form">
            <div class="form-group">
              <input type="text" name="student_id" placeholder="Student id" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" name="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
        </div>
        <!--/.navbar-collapse -->
      </div>
  </div>

  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron">
      <div class="container">
        <form class="form-signin" role="form">
          <input type="text" class="form-control" placeholder="Student id" required autofocus>
          <input type="text" class="form-control" placeholder="First name" required autofocus>
          <input type="text" class="form-control" placeholder="Last name" required autofocus>
          <input type="password" class="form-control" placeholder="Create Password" required>
          <span class="text-muted">Use at least one lowercase letter, one numeral, and seven characters.</span>
          <input type="email" class="form-control" placeholder="Email" required autofocus>
          <button class="btn btn-lg btn btn-success btn-block" type="submit">Sign up for WhiteBoard</button><br/>
          <span class="text-muted">By clicking "Sign up for WhiteBoard", you agree to our terms of service and privacy policy. </span>
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
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
        </div>
        <div class="col-md-4">
          <h1><span class="glyphicon glyphicon-book"></span></h1><h2>Trading/Swapping Books</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
       </div>
        <div class="col-md-4">
          <h1><span class="glyphicon glyphicon-pencil"></span></h1><h2>Getting/Providing Tutor</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam.Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
        </div>
      </div>
    </div>
    
    <jsp:include page="includes/footer.jsp" />