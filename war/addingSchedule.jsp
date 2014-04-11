  <%@ include file="includes/header.jsp" %>
  <link href="lib/css/schedule.css" rel="stylesheet">
  <script type="text/javascript" src="js/schedule.js"></script>
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
            <h3>Adding your schedule, this represents your available time.</h3>
          </div>
          <form action="#" method="POST">
	          <div class="panel-body">
	          	 <fieldset>
	                    <legend>
	                    	<!--  add checking session value make sure this is new blank schedule or not then yes dispaly button --> 
	                    	<button id="skip-schedule" type="button" class="btn btn-warning btn-lg col-md-3">Skip</button>
	                    </legend>
	                    <div id="dialog" title="Select your schedule:">
	                    	<table class="table">
	                    		<tr>	
	                    			<td><b>Schedule:<input style="width:0px; height:0px; border:none;"/></b></td>
	                    			<td>
	                    				&nbsp;On&nbsp;<span id="schedule_date" class="bg-success"></span>
	                    				&nbsp;From&nbsp;<input id="start_time" name="start_time" class="time" type="text" />
	                    				&nbsp;To&nbsp;<input id="end_time" name="end_time" class="time" type="text" />		
	                    			</td>
	                    		</tr>
	                    		<tr>
	                    			<td></td>
	                    			<td>
	                    				<input name="all_day" type="checkbox"> All day
	                    			</td>
	                    		</tr>
	                    		<tr>
	                    			<td><b>Title:</b></td>
	                    			<td>
	                    				<input id="schedule_title" type="text" name="schedule_title" class="form-control" required></input>
	                    			</td>
	                    		</tr>
	                    		<tr>
	                    			<td><b>Description:</b></td>
	                    			<td>
	                    				<textarea id="schedule_description" name="schedule_description" class="form-control" rows="3"></textarea>
	                    			</td>
	                    		</tr>
							</table>
		                 </div>
	               </fieldset>
	               <div id="calendar"></div>
	          </div>
          </form>
      	</div>
	</div>
<jsp:include page="includes/footer.jsp" />