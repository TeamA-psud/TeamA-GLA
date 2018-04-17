$(document).ready(function(){
	var hiddenRegistration = "HiddenRegistrationValue";
	var PreferenceAlimentaire = [];
	$("#registerButton").click(function(){
		var nom = $("#nom").val();
		var prenom = $("#prenom").val();
		var age = $("#age").val();
		var adresse = $("#adresse").val();
		var datenaiss = $("#datenaiss").val();
		var email = $("#email").val();
		var phone = $("#phone").val();
		var password = $("#password").val();
		var budget = $("#budget").val();
		var sex = $("#sex").val();
		var transport = $("#transport").val();
		$('input[name="pref"]:checked').each(function() {
			PreferenceAlimentaire.push(this.value);
		});
		var PrefAlimentaireString = PreferenceAlimentaire.toString();
		$.ajax({
			url : "http://localhost:8080/ggnight/UserControl",
			method : "GET",
			dataType : "text",
			data : {
				hiddenRegistration : hiddenRegistration,
				nom : nom,
				prenom : prenom,
				age : age,
				adresse : adresse,
				datenaiss : datenaiss,
				email : email,
				password : password,
				budget : budget,
				sex : sex,
				phone : phone,
				transport : transport,
				PrefAlimentaireString : PrefAlimentaireString
			},
			success : function(result){
				getMsg(result);
				window.location.href = "login.html";
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