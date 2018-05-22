$(document).ready(function(){
	var changeInfo = "changeInfo";
	$("#change").click(function(){
		var nom = $("#nom").val();
		var prenom = $("#prenom").val();
		var age = $("#age").val();
		var adresse = $("#adresse").val();
		var date = $("#date").val();
		var phone = $("#phone").val();
		var sex = $("#sex").val();
		var budget = $("#budget").val();
		var transport = $("#transport").val();
		var email = $("#email").val();
		$.ajax({
			url : "http://localhost:8080/ggnight/UserControl",
			method : "GET",
			dataType : "text",
			data : {
				changeInfo : changeInfo,
				nom : nom,
				prenom : prenom,
				age : age,
				adresse : adresse,
				date : date, 
				phone : phone,
				sex : sex,
				budget : budget,
				transport : transport,
				email : email
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