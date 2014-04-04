/**
 * login.js for validating the sign in format and agreement of policy
 */

$( document ).ready(function() {
	// Handler for .ready() called.
	$('tr#account_not_exist').hide();
	$('tr#account_blank').hide();
	$('input[name=student_id_signin]').removeClass('error-shadow');
	$('input[name=student_id_signin]').removeClass('good-id');
	
	$(function() {
	   $('input#accept_agreement').click(function() {
	        if ($(this).is(':checked')) 
	        {
	            $('#login_accept_agreement_submit').removeAttr('disabled');
	        } 
	        else 
	        {
	            $('#login_accept_agreement_submit').attr('disabled', 'true');
	        }
	    });
	});
	
	
	$("input[name=student_id_signin]").keyup(function (e) {
	    var student_id = $(this).val();
	
	    $.ajax({
	        type: "POST",
	        url: "validId",
	        data: {"id":student_id},
	        success: function (data) {
	        	alert(data);
	            if(data=='false')
	            {
	            	$('input[name=student_id_signin]').addClass('error-shadow');
	            }
	            else if(data=='true')
	            {
	            	$('input[name=student_id_signin]').addClass('good-id');
	            }
	            else{alert("wrong");}
	        }
	    });
	});
	
});