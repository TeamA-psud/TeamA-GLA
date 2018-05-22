$(document).ready(function(){
    var HiddenDeleteEvent = "HiddenDeleteEvent";
    var idLieu=0;
    var idSoiree = 0;
    var idOrganisateur = 0;
    
    $("#deleteEventTable tbody tr").click(function(){
        $(this).each(function(){
            idLieu = $(this).find("td:eq(5) input[type='hidden']").val();
            idSoiree = $(this).find("td:eq(6) input[type='hidden']").val();
            idOrganisateur = $(this).find("td:eq(7) input[type='hidden']").val();
            $.confirm({
               text : "Vous etes sur de vouloir supprimer cette soirée",
               confirm : function(){
                   $.ajax({
                       url : "http://localhost:8080/ggnight/EventControl",
                       method : "POST",
		       dataType : "text",
                       data : {
                           HiddenDeleteEvent : HiddenDeleteEvent,
                           idLieu : idLieu,
                           idSoiree : idSoiree,
                           idOrganisateur : idOrganisateur
                       },
                       success : function(result){
                           if(result === "0"){
                                showMsg("Invitation supprimé avec success");
                           }else if(result === "-1"){
                                showMsg("L'invitation n'a pas été supprimer!");
                           }else if(result === "-2"){
                                showMsg("La soirée n'a pas été supprimer !");
                           }else if(result === "-3"){
                                showMsg("Le lieu n'a pas été supprimer !");
                           }else {
                                showMsg("Une érreur est apparu ! refaire a nouveau !");
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
               },
               cancel : function(){
                   location.reload();
               }
            });
        });
    });
});

function showMsg(msg){
    alert(msg);
}
