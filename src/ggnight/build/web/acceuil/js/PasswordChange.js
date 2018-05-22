$(document).ready(function(){
	var HiddenChangePassword = "HiddenChangePassword";
	$("#changePassword").click(function(){
		var email = $("#email").val();
		var newPassword = $("#newPassword").val();
		$.ajax({
			url : "http://localhost:8080/ggnight/UserControl",
			method : "GET",
			dataType : "text",
			data : {
				HiddenChangePassword :HiddenChangePassword,
				email : email,
				newPassword : newPassword
			},
			success : function(result){
				getMsg(result);
				location.reload();
			},
			error : function(jqXHR, exception){
        		var msg = '';
                if (jqXHR.status == 0) {
                    msg = 'Not connect.\n Verify Network.';
                } else if (jqXHR.status == 404) {
                    msg = 'Requested page not found. [404]';
                } else if (jqXHR.status == 500) {
                    msg = 'Internal Server Error [500].';
                } else if (exception === 'parsererror') {
                    msg = 'Requested JSON parse failed.'+jqXHR.responseText;
                } else if (exception === 'timeout') {
                    msg = 'Time out error.';
                } else if (exception === 'abort') {
                    msg = 'Ajax request aborted.';
                } else {
                    msg = 'Uncaught Error.\n' + jqXHR.responseText;
                }
                getError(msg);
        	}
		});
		return false;
	});
});
function getError(msg){
	alert(msg);
}
function getMsg(msg){
	alert(msg);
}