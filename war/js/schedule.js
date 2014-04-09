/**
 * Schedule.js is used to render the jquery ui dialog containing one individual schedule for saving
 */


var minTime = null;
var minDate = null;
var isScheduleRepeat = false;
var repeatOption = null;
var repeatDay = null;
var repeatMonth = null;
var repeatWeek = null;
var startTime = null;
var endTime = null;
var startDate = null;
var endDate = null;
var description = null;

$(function() {
    $( '#start_time' ).timepicker();
    $( '#end_time' ).timepicker();
    $( '#start_time' ).timepicker('setTime', new Date());
    $( '#end_time' ).timepicker('setTime', new Date());
    $( "#start_date" ).datepicker("setDate", 'today');
    $( "#end_date" ).datepicker("setDate", 'today');
    $( ".repeat-mode" ).hide();
    $( "#repeat-summary" ).html("");
    setDateAndTime();
    /*
     * This triggers the change time function that only shows the time after the time picked in the first date picker
     * and also display the duration in the second date picker
     */
    $('#start_time').on('changeTime', function() {
    	minTime = $(this).val();
        $('#end_time').timepicker({
        	'minTime': minTime,
            'maxTime': '11:59am',
        });
        setDateAndTime();
	});
    
    /*
     * event handler for the end time summary
     */
    $('#end_time').on('changeTime', function() {
    	setDateAndTime();
	});
    /*
     * Triggers the all day check box that fills up the two time text input
     */
    $('input[name=all_day]').click(function () {
    	if($(this).is(':checked')){
        	$('#start_time').timepicker('setTime', "12:00am");
        	$('#end_time').timepicker('setTime', "11:59pm");
        	$('#start_date').datepicker('setDate', 'today');
        	$('#end_date').datepicker('setDate', 'today');
    	}
    	setDateAndTime();
    }); 
    /*
     * Repeat check box trigger event handler
     */
    $('input[name=repeat]').click(function () {
    	if($(this).is(':checked')){ 
    		$( "#repeat-option td select option[value=day]" ).prop('selected', true);
    		repeatOption = $('#repeat-option td select').find(":selected").text();
    		repeatDay = parseInt($('#repeat-daily td select').find(":selected").text());
    		$("#repeat-summary").html("Repeat every " + repeatDay + " day(s)");
    		$( "#repeat-option" ).show();
    		$( "#repeat-daily" ).show();
    		isScheduleRepeat = true;
    	}
    	else{ 
    		$( ".repeat-mode" ).hide(); 
    		isScheduleRepeat = false;
    		$("#repeat-summary").html("");
    	}
    }); 
    
    /*
     * 	Checkboxes click event handler 
     */
    $('input[name=repeat-day]').click(function () {
		repeatWeek = new Array();
		$("input:checkbox[name=repeat-day]:checked").each(function() {
			repeatWeek.push($(this).val());
		});
		 
		var message = "Repeat weekly on ";
		$("input:checkbox[name=repeat-day]:checked").each(function() {
			message += " " + $(this).val();
		});
		$("#repeat-summary").html(message);
    }); 

    
	 // initialize the days and months
	 if(isScheduleRepeat == true){
		 repeatOption = $('#repeat-option td select').find(":selected").val();
		 if(repeatOption == 'monthly'){
			 repeatMonth = parseInt($('#repeat-monthly td select').find(":selected").text());
			 $("#repeat-summary").html("Repeat every " + repeatMonth + " month(s)");
		 }
		 else if(repeatOption == 'day' ){
			 repeatDay = parseInt($('#repeat-daily td select').find(":selected").text());
			 $("#repeat-summary").html("Repeat every " + repeatDay + " day(s)");
		 }
		 //get all days from check box and time
		 else if(repeatOption == 'weekly'){
			 repeatWeek = new Array();
		   	 $("input:checkbox[name=repeat-day]:checked").each(function() {
		   		 repeatWeek.push($(this).val());
		   	 });
		 }
	 }
	 
   /*
    * repeat daily event handler
    */
   $("#repeat-daily td select").change(function () {
	   var repeat = $(this).val();
	   $("#repeat-summary").html("Repeat every " + repeat + " day(s)");
	   repeatDay = parseInt(repeat);
	});
	
   /*
    * repeat month event handler
    */
   $("#repeat-monthly td select").change(function () {
 	   var repeat = $(this).val();
 	   $("#repeat-summary").html("Repeat every " + repeat + " month(s)");
 	   repeatMonth = parseInt(repeat);
 	});
   
   /*
    * Repeat option event handler
    */
   $("#repeat-option td select").change(function () {
   	   var txt = $(this).val();
   	   repeatOption = txt;
   	   if(txt == 'day'){
		    $( "#repeat-daily" ).show();
		    $( "#repeat-weekly" ).hide();
		    $( "#repeat-monthly" ).hide();
		    repeatMonth = null;
		    var r = parseInt($('#repeat-daily td select').find(":selected").text());
		    $("#repeat-summary").html("Repeat every " + r + " day(s)");
   	   }
   	   else if(txt == 'weekday'){
   		    $( "#repeat-daily" ).hide();
   		    $( "#repeat-weekly" ).hide();
   		    $( "#repeat-monthly" ).hide();
   		    repeatDay = null;
   		    repeatMonth = null;
   		    $("#repeat-summary").html("Repeat every Monday to Friday");
   		    repeatWeek = ['monday','tuesday','wednesday','thursday','friday'];
   	   }
   	   else if(txt == 'MWF'){
   		    $( "#repeat-daily" ).hide();
   		    $( "#repeat-weekly" ).hide();
   		    $( "#repeat-monthly" ).hide();
   		    repeatDay = null;
   		    repeatMonth = null;
   		    $("#repeat-summary").html("Repeat every Monday, Wednesday and Friday");
   		    repeatWeek = ['monday','wednesday','friday'];
   	   }
   	   else if(txt == 'TH'){
   		    $( "#repeat-daily" ).hide();
   		    $( "#repeat-weekly" ).hide();
   		    $( "#repeat-monthly" ).hide();
   		    repeatDay = null;
   		    repeatMonth = null;
   		    $("#repeat-summary").html("Repeat every Tuesday and Thursday");
   		    repeatWeek = ['tuesday','thursday'];
   	   }
   	   else if(txt == 'weekly'){
   		    $( "#repeat-daily" ).hide();
   		    $( "#repeat-weekly" ).show();
   		    $( "#repeat-monthly" ).hide();
   		    $("#repeat-summary").html("Repeat weekly on");
			 repeatWeek = new Array();
		   	 $("input:checkbox[name=repeat-day]:checked").each(function() {
		   		 repeatWeek.push($(this).val());
		   	 });
   		    repeatMonth = null;
   		    repeatDay = null;
   	   }
   	   else if(txt == 'monthly'){
   		    $( "#repeat-daily" ).hide();
   		    $( "#repeat-weekly" ).hide();
   		    $( "#repeat-monthly" ).show(); 
   		    var r = parseInt($('#repeat-monthly td select').find(":selected").text());
   		    $("#repeat-summary").html("Repeat every " + r + " month(s)");
   		    repeatDay = null;
   	   } 	   
   });
});

$(function() {
    $( "#dialog" ).dialog({
    	 autoOpen: false,
         maxWidth:700,
         maxHeight: 550,
         width: 700,
         height: 550,
         modal: true,
         buttons: {
	         "Create": function() {
	        	 	setDateAndTime();
		     	    $.ajax({
		    	        type: "POST",
		    	        url: "insertSchedule",
		    	        data: { "isRepeat":isScheduleRepeat,
		    	        		"repeatOption":repeatOption,
		    	        		"repeatDay":repeatDay,
		    	        		"repeatMonth":repeatMonth,
		    	        		"repeatWeek":JSON.stringify(repeatWeek),
		    	        		"startTime":startTime,
		    	        		"endTime":endTime,
		    	        		"startDate":startDate,
		    	        		"endDate":endDate,
		    	        		"description":description	},
		    	        success: function (data) {
		    	        	 //success insert data		   	        	 
							 //for debugging purposes
							 console.log(isScheduleRepeat);
							 console.log(repeatOption + "option");
							 console.log(repeatDay + "day");
							 console.log(repeatMonth + "month");
							 console.log(repeatWeek);
							 console.log(startTime);
							 console.log(endTime);
							 console.log(startDate);
							 console.log(endDate);
							
//							 alert("created");
							//$(this).dialog("close");
		    	        },
		    	        error: function (request, status, error) {
		    	            console.log(request.responseText);
		    	        }
		    	    });
	         },
	         Cancel: function() {
	        	 $(this).dialog("close");
	         }
         },
         close: function() {
         }	
   });
});

function setDateAndTime(){
	startDate = $('#start_date').val();
	endDate = $('#end_date').val();
	startTime = $('#start_time').val();
	endTime  = $("#end_time").val();
	description  = $("#schedule-description").val();
	$("#time-summary").html("From " + startDate + " " + startTime + " to " + endDate + " " + endTime);
}
/*
 * Full calendar plug in 
 */
$(document).ready(function() { 
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    var calendar = $('#calendar').fullCalendar({
    //configure options for the calendar
       header: {
          left: 'prev,next today',
          center: 'title',
          right: 'month,agendaWeek,agendaDay'
       },
       // this is where you specify where to pull the events from.
       editable:false,
       weekMode:'liquid'
       //etc etc
    });
    
    /*
     * add schedule button event handler
     */
    $('#add-schedule').click(function () {
    	$("#dialog").dialog('open')
    });
});