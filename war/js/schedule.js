/**
 * Schedule.js is used to render the jquery ui dialog containing one individual schedule for saving
 */

function pad(str, max) {
	str = str.toString();
	return str.length < max ? pad("0" + str, max) : str;
}

var globalEventId = null;
$(document).ready(function() { 
    //full calendar
	$("#dialog").dialog({
		autoOpen : false,
		maxWidth : 700,
		maxHeight : 400,
		width : 700,
		height : 400,
		modal : true,
		buttons : {
			"Create" : function() {
				 var currentDate = $( '#schedule_date' ).text();
				 var startTime =  $( '#start_time' ).val();
				 var endTime =  $( '#end_time' ).val();
				 var title =  $( '#schedule_title' ).val();
				 var description =  $( '#schedule_description' ).val();
				 
				 var startHour = parseInt(startTime.substring(0,2));
				 var endHour = parseInt(endTime.substring(0,2));
				 if(startTime.trim() == "" || endTime.trim() == "" || title.trim() == ""){
					 alert("You must fill the start time and end time.");
				 }
				 else if(startHour > endHour){
					 alert("Your start time and end time are not valid.");
				 }
				 else{
					 var $this = $(this); 
					 $.ajax({
						 type: "POST",
						 url: "/insertSchedule",
						 data: { "date":currentDate,
								 "startTime":startTime,
								 "endTime":endTime,
								 "title":title,
								 "description":description },
						 success: function (data) {
							 if(data.succeed){
								 alert("Schedule has been succesfully created.");
								 $this.dialog("close");
								 $('#calendar').fullCalendar( 'refetchEvents' );
							 }
							 else{
								 alert("Schedule failed to be created.")
							 }
						 },
						 error: function (request, status, error) {
							 console.log(request.responseText);
						 }
					 });
				 }
			},
			Update: function(){
				 var currentDate = $( '#schedule_date' ).text();
				 var startTime =  $( '#start_time' ).val();
				 var endTime =  $( '#end_time' ).val();
				 var title =  $( '#schedule_title' ).val();
				 var description =  $( '#schedule_description' ).val();
				 var startHour = parseInt(startTime.substring(0,2));
				 var endHour = parseInt(endTime.substring(0,2));
				 if(startTime.trim() == "" || endTime.trim() == "" || title.trim() == ""){
					 alert("You must fill the start time and end time.");
				 }
				 else if(startHour > endHour){
					 alert("Your start time and end time are not valid.");
				 }
				 else{
					 var $this = $(this); 
					 $.ajax({
						 type: "POST",
						 url: "/updateSchedule",
						 data: { "id":globalEventId,
							 	 "date":currentDate,
								 "startTime":startTime,
								 "endTime":endTime,
								 "title":title,
								 "description":description },
						 success: function (data) {
							 if(data.succeed){
								 alert("Schedule has been succesfully updated.");
								 $this.dialog("close");
								 $('#calendar').fullCalendar( 'refetchEvents' );
								 
							 }
							 else{
								 alert("Schedule failed to be updated.")
							 }
						 },
						 error: function (request, status, error) {
							 console.log(request.responseText);
						 }
					 });
				 }
			},
			Delete: function(){
				var confirm = window.confirm("Delete this schedule?");
				if (confirm) {
					 var $this = $(this);
					 $.ajax({
						 type: "POST",
						 url: "/deleteSchedule",
						 data: { "id":globalEventId },
						 success: function (data) {
							 if(data.succeed){
								 alert("Schedule has been succesfully deleted.");
								 $this.dialog("close");
								 $('#calendar').fullCalendar( 'refetchEvents' );
							 }
							 else{
								 alert("Schedule failed to be deleted.")
							 }
						 },
						 error: function (request, status, error) {
							 console.log(request.responseText);
						 }
					 });
				}
			},
			Cancel : function() {
				$(this).dialog("close");
			}
		},
		close : function() {
		}
	});
	
    var calendar = $('#calendar').fullCalendar({
    //configure options for the calendar
       header: {
          left: 'prev,next today',
          center: 'title',
          right: 'month,agendaWeek'
       },
       // this is where you specify where to pull the events from.
       editable:false,
       disableResizing: true,
       disableDragging: true,
       weekMode:'liquid',
       dayClick: function(date, allDay, jsEvent, view) {  
    	   if (allDay) {
    		   	$('.ui-button:contains(Update)').hide()
				$('.ui-button:contains(Delete)').hide()
				alert('Clicked on the entire day: ' + date);
				var year = pad(date.getFullYear(),4);
				var month = pad(date.getMonth()+1,2);
				var day = pad(date.getDate(),2);
			    $( '#schedule_date' ).html(year+"-"+month+"-"+day);
			    $( '#start_time' ).timepicker({ 'timeFormat': 'H:i','forceRoundTime': true });
			    $( '#end_time' ).timepicker({ 'timeFormat': 'H:i','forceRoundTime': true });
			    //open ui dialog
			    $("#dialog").dialog('open');
           }
    	   //unimplemented
           else{
               alert('Clicked on the slot: ' + date);
           }
//           alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
           alert('Current view: ' + view.name);
           alert('what is allday: ' + allDay);

       },
       
       events: {
           url: '/loadSchedules',
           type: 'POST',
           error: function() {
               alert('there was an error while fetching events!');
           }
       },
       
       eventClick: function(calEvent, jsEvent, view) {
    	   alert('Event: ' + calEvent.id);
           alert('Event: ' + calEvent.title);
           alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
           alert('View: ' + view.name);
           var eventId = calEvent.id;
           globalEventId = eventId;
           $.ajax({
				 type: "POST",
				 url: "/loadSchedule",
				 data: { "id":eventId },
				 success: function (data) {
					 if(data!=null){
						$('.ui-button:contains(Create)').hide()
					    $( '#schedule_date' ).html(data.date);
					    $( '#start_time' ).timepicker({ 'timeFormat': 'H:i','forceRoundTime': true });
					    $( '#start_time' ).timepicker('setTime', data.start);
					    $( '#end_time' ).timepicker({ 'timeFormat': 'H:i','forceRoundTime': true });
					    $( '#end_time' ).timepicker('setTime', data.end);
					    $( '#schedule_title' ).val(data.title);
					    $( '#schedule_description' ).val(data.description);
					    //open ui dialog
					    $("#dialog").dialog('open');
						alert("Schedule has been succesfully created.");
					 }
					 else{
						 alert("Schedule failed to be created.")
					 }
				 },
				 error: function (request, status, error) {
					 console.log(request.responseText);
				 }
			 });
       }
    //end of full calendar
    });
//end of document ready
});
