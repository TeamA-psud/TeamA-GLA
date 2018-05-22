$(document).ready(function(){
   var HiddenConfirmAddEvent = "HiddenConfirmAddEvent";
   var placeId="";
   var nom = "";
   var adresse ="";
   var testIDPL="";
   var rating = 0;
   var idPersons = "";
   //reservation du réstaurant
   $("#restoSearch tbody tr").click(function(){
       $(this).each(function(){
           nom = $(this).find("td:eq(0)").text();
           adresse = $(this).find("td:eq(1)").text();
           rating = $(this).find("td:eq(2)").text();
           placeId = $(this).find("td:eq(7) input[type='hidden']").val();
           idPersons = $(this).find("td:eq(8) input[type='hidden']").val();
           $.confirm({
               text: 'Vous etes sur de vouloir réserver ce réstaurant ?',
               confirm : function(){
                   $.ajax({
                       url : "http://localhost:8080/ggnight/EventControl",
                       method : "POST",
		       dataType : "text",
		       data : {
			 HiddenConfirmAddEvent : HiddenConfirmAddEvent,
			 nom : nom,
			 adresse : adresse,
                         rating : rating,
                         placeId : placeId,
                         idPersons : idPersons
                        },
			success : function(result){
			    if(result === "0"){
                                showMsg("Reservation du lieu confirmée !");
                            }else if(result === "-1"){
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
                            }else if(result === "-2"){
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
                            }else if(result === "-3"){
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
                            }else{
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
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
           //showMsg("le nom est : "+nom+" l'adresse est : "+adresse+" rating est : "+rating+" placeId est : "+placeId);
       });
   });
   
   
   //reservation du bar
   $("#barSearch tbody tr").click(function(){
       $(this).each(function(){
           nom = $(this).find("td:eq(0)").text();
           adresse = $(this).find("td:eq(1)").text();
           rating = $(this).find("td:eq(2)").text();
           placeId = $(this).find("td:eq(7) input[type='hidden']").val();
           idPersons = $(this).find("td:eq(8) input[type='hidden']").val();
           $.confirm({
               text: 'Vous etes sur de vouloir réserver ce bar ?',
               confirm : function(){
                   $.ajax({
                       url : "http://localhost:8080/ggnight/EventControl",
                       method : "POST",
		       dataType : "text",
		       data : {
			 HiddenConfirmAddEvent : HiddenConfirmAddEvent,
			 nom : nom,
			 adresse : adresse,
                         rating : rating,
                         placeId : placeId,
                         idPersons : idPersons
                        },
			success : function(result){
			    if(result === "0"){
                                showMsg("Reservation du lieu confirmée !");
                            }else if(result === "-1"){
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
                            }else if(result === "-2"){
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
                            }else if(result === "-3"){
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
                            }else{
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
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
           //showMsg("le nom est : "+nom+" l'adresse est : "+adresse+" rating est : "+rating+" placeId est : "+placeId);
       });
   });
   
   
   //reservation du nightclub
   $("#nightClubSearch tbody tr").click(function(){
       $(this).each(function(){
           nom = $(this).find("td:eq(0)").text();
           adresse = $(this).find("td:eq(1)").text();
           rating = $(this).find("td:eq(2)").text();
           placeId = $(this).find("td:eq(7) input[type='hidden']").val();
           idPersons = $(this).find("td:eq(8) input[type='hidden']").val();
           $.confirm({
               text: 'Vous etes sur de vouloir réserver cette boite ?',
               confirm : function(){
                   $.ajax({
                       url : "http://localhost:8080/ggnight/EventControl",
                       method : "POST",
		       dataType : "text",
		       data : {
			 HiddenConfirmAddEvent : HiddenConfirmAddEvent,
			 nom : nom,
			 adresse : adresse,
                         rating : rating,
                         placeId : placeId,
                         idPersons : idPersons
                        },
			success : function(result){
			    if(result === "0"){
                                showMsg("Reservation du lieu confirmée !");
                            }else if(result === "-1"){
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
                            }else if(result === "-2"){
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
                            }else if(result === "-3"){
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
                            }else{
                                showMsg("Une érreur a survenu ! refaire a nouveau!");
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
           //showMsg("le nom est : "+nom+" l'adresse est : "+adresse+" rating est : "+rating+" placeId est : "+placeId);
       });
   });
});


function showMsg(msg){
    alert(msg);
}


