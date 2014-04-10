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
	                    	<button id="add-schedule" type="button" class="btn btn-primary btn-lg col-md-3">Add New Schedule</button>
	                    	<button id="skip-schedule" type="button" class="btn btn-warning btn-lg col-md-3">Skip</button>
	                    </legend>
	                    <div id="dialog" title="Select your schedule:">
	                    	<table class="table">
	                    		<tr>	
	                    			<td><b>Schedule:</b></td>
	                    			<td width="100px">
	                    				<input style="width:0px; height:0px; border:none;"/>
	                    				<input id="start_date" name="start_date" type="text" class="date" />
	                    			</td>
	                    			<td width="85px"><input id="start_time" name="start_time" class="time" type="text" /></td>
	                    			<td width="20px">to</td>
	                    			<td width="100px"><input id="end_date" name="end_date" type="text" class="date" /></td>
	                    			<td width="85px"><input id="end_time" name="end_time" class="time" type="text" /></td>
	                    		</tr>
	                    		<tr>
	                    			<td></td>
	                    			<td><input name="all_day" type="checkbox"> All day&nbsp;&nbsp;</td>
	                    			<td><input name="repeat" type="checkbox"> Repeat</td>
	                    		</tr>
	                    		<tr id="repeat-option" class="repeat-mode">
	                    			<td><b>Repeat:</b></td>
	                    			<td colspan='5'>
	                    				<select>
	                    					<option value="day">Daily</option>
	                    					<option value="weekday">Every Weekday From Monday to Friday</option>
	                    					<option value="MWF">Every Monday, Wednesday, Friday</option>
	                    					<option value="TH">Every Tuesday, Thursday</option>
	                    					<option value="weekly">Weekly</option>
	                    					<option value="monthly">Monthly</option>
	                    				</select>
	                    			</td>
	                    		</tr>
	                    		<tr id="repeat-daily" class="repeat-mode">
	                    			<td><b>Repeat every:</b></td>
	                    			<td>	
	                    				<select>
	                    					<option value="1">1</option>
	                    					<option value="2">2</option>
	                    					<option value="3">3</option>
	                    					<option value="4">4</option>
	                    					<option value="5">5</option>
	                    					<option value="6">6</option>
	                    					<option value="7">7</option>
	                    				</select>	                    					
	                    			</td>
	                    			<td colspan="4">day(s)</td>
	                    		</tr>
	                    		<tr id="repeat-weekly" class="repeat-mode">
	                    			<td><b>Repeat on:</b></td>
	                    			<td colspan='5'>
	                    				<input type="checkbox" name="repeat-day" value="Sunday" id="repeat-sunday"/> S	
	                    				<input type="checkbox" name="repeat-day" value="Monday" id="repeat-monday"/> M	  
	                    				<input type="checkbox" name="repeat-day" value="Tuesday" id="repeat-tuesday"/> T
	                    				<input type="checkbox" name="repeat-day" value="Wednesday" id="repeat-wednesday"/> W
	                    				<input type="checkbox" name="repeat-day" value="Thusday" id="repeat-thusday"/> T
	                    				<input type="checkbox" name="repeat-day" value="Friday" id="repeat-friday"/> F
	                    				<input type="checkbox" name="repeat-day" value="Saturday" id="repeat-Saturday"/> S                  					
	                    			</td>
	                    		</tr>
	                    		<tr id="repeat-monthly" class="repeat-mode">
	                    			<td><b>Repeat every:</b></td>
	                    			<td>	
	                    				<select>
	                    					<option value="1">1</option>
	                    					<option value="2">2</option>
	                    					<option value="3">3</option>
	                    					<option value="4">4</option>
	                    					<option value="5">5</option>
	                    				</select>	                    					
	                    			</td>
	                    			<td colspan="4">month(s)</td>
	                    		</tr>
	                    		<tr>
	                    			<td rowspan="2"><b>Summary:</b></td>
	                    			<td id="time-summary" colspan='5'></td>
	                    		</tr>
           			            <tr>
	                    			<td id="repeat-summary" colspan='5'></td>
	                    		</tr>
	                    		<tr>
	                    			<td><b>Description:</b></td>
	                    			<td colspan='5'>
	                    				<textarea id="schedule-description" name="schedule-description" class="form-control" rows="3"></textarea>
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