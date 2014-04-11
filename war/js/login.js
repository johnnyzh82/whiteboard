/**
 * login.js for validating the sign in format and agreement of policy
 */
function validSignIn()
{
	var inputId = $('input[name=student_id_signin]').val().trim();
    var inputPass = $('input[name=password_signin]').val();
	if ( inputId == '' || inputPass == '') 
    {
		$('tr#account_not_exist').hide();
		$('tr#account_blank').show();
		return false;
    } 
	return true;
}

	
$( document ).ready(function() {
	// Handler for .ready() called.
	//	$('tr#account_not_exist').hide();
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
	

	$('form#signin_form').submit(function(e) {
		 return validSignIn();
	});
	
	$("input[name=student_id_signin]").keyup(function (e) {
	    var student_id = $(this).val();
	
	    $.ajax({
	        type: "POST",
	        url: "validId",
	        data: {"id":student_id},
	        success: function (data) {
//			    console.log(data.valid);
			    var valid = data.valid;
	            if(!valid)
	            {
	            	$('input[name=student_id_signin]').removeClass('good-id');
		            $('input[name=student_id_signin]').addClass('error-shadow');
	            }
	            else if(valid)
	            {
	            	$('input[name=student_id_signin]').removeClass('error-shadow');
	            	$('input[name=student_id_signin]').addClass('good-id');
	            }
	        }
	    });
	});	
});