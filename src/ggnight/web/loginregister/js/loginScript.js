$(document).ready(function(){
	var HiddenLoginValue ="HiddenLoginValue";
	$("#login").click(function(){
		var email = $("#email").val();
		var password = $("#password").val();
		$.ajax({
			url : "http://localhost:8080/ggnight/UserControl",
			method : "GET",
			dataType : "text",
			data : {
				HiddenLoginValue : HiddenLoginValue,
				email : email,
				password : password
			},
			success : function(result){
				if(result == "error"){
					getMsg("Email ou mot de passe incorrect !");
				}else{
					window.location.href = "../acceuil/acceuil.jsp";
				}
				
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