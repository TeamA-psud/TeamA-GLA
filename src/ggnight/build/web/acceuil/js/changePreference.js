$(document).ready(function(){
	var hiddenChangePreferences = "hiddenChangePreferences";
	var PreferenceAlimentaire = [];
	var idUser=0;
	$("#alimentationChange").click(function(){
		idUser = $("#idUser").val();
		$('input[name="pref"]:checked').each(function() {
			PreferenceAlimentaire.push(this.value);
		});
		var PrefAlimentaireString = PreferenceAlimentaire.toString();
		$.ajax({
			url : "http://localhost:8080/ggnight/UserControl",
			method : "GET",
			dataType : "text",
			data : {
				hiddenChangePreferences : hiddenChangePreferences,
				PrefAlimentaireString : PrefAlimentaireString,
				idUser : idUser
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