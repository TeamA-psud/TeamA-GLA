$(document).ready(function(){
   var idUser =0;
   var HiddenConfirmeEvent = "HiddenConfirmeEvent";
   var HiddenRejectEvent = "HiddenRejectEvent";
   $("#confirme").click(function(){
        idUser = $("#idUser").val();
        $.ajax({
            url : "http://localhost:8080/ggnight/EventControl",
            method : "POST",
            dataType : "text",
            data : {
                HiddenConfirmeEvent : HiddenConfirmeEvent,
                idUser : idUser
            },
            success : function(result){
                if(result === "1"){
                    showMsg("Soirée confirmé");
                    location.reload();
                }else if(result === "0"){
                    showMsg("Une érreur est apparue ! refaire a nouveau !");
                }else{
                    showMsg("Une érreur est apparue ! refaire a nouveau !");
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
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
                            showMsg(msg);
		        }
        });
        return false;
   });
   
   
   $("#reject").click(function(){
       idUser = $("#idUser").val();
        $.ajax({
            url : "http://localhost:8080/ggnight/EventControl",
            method : "POST",
            dataType : "text",
            data : {
                HiddenRejectEvent : HiddenRejectEvent,
                idUser : idUser
            },
            success : function(result){
                if(result === "1"){
                    showMsg("Soirée confirmé");
                    location.reload();
                }else if(result === "0"){
                    showMsg("Une érreur est apparue ! refaire a nouveau !");
                }else{
                    showMsg("Une érreur est apparue ! refaire a nouveau !");
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
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
                            showMsg(msg);
		        }
        });
        return false;
   });
});


function showMsg(msg){
    alert(msg);
}