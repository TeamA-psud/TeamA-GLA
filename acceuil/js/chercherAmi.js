$(document).ready(function(){
	var HiddenChercherAmi ="HiddenChercherAmi";
	var nom="";
	var prenom="";
	var idUser = 0;
	var FriendsSearchNom = [];
	var FriendsSearchPrenom = [];
	var FriendsSearchAge = [];
	var FriendsSearchAdresse = [];
	var FriendsSearchId = [];
	$("#mytable_cherche").hide();
	$("#search").click(function(){
		nom = $("#nom").val();
		prenom = $("#prenom").val();
		idUser = $("#idUser").val();
		if(nom === "" || prenom === ""){
			alertMsg("Vous devez entrer le nom ou le prenom de votre ami");
			location.reload();
		}else {
			$.ajax({
				url : "http://localhost:8080/ggnight/FriendControl",
				method : "GET",
				dataType : "text",
				data : {
					HiddenChercherAmi : HiddenChercherAmi,
					nom : nom,
					prenom : prenom,
					idUser : idUser
				},
				success : function(data){
					var obj = $.parseJSON(data);
					var count = Object.keys(obj).length;
					for(var i=0 ; i<count ; i++){
						FriendsSearchNom.push(obj[i].nom);
						FriendsSearchPrenom.push(obj[i].prenom);
						FriendsSearchAge.push(obj[i].age);
						FriendsSearchAdresse.push(obj[i].adresse);
						FriendsSearchId.push(obj[i].id);
					}
					for(var k=0 ; k<count ; k++){
						var nom = FriendsSearchNom[k].toString();
						var prenom = FriendsSearchPrenom[k].toString();
						var age = FriendsSearchAge[k].toString();
						var adresse = FriendsSearchAdresse[k].toString();
						var id = FriendsSearchId[k].toString();
						var makeup = "<tr><td>"+nom+"</td><td>"+prenom+"</td><td>"+age+"</td><td>"+adresse+"</td><td><input type='submit' id='ajouter' class='btn btn-primary' value='Confirmer'/></td><td><input type='hidden' id='idFriend' value='"+id+"'/></td><td><input type='hidden' id='idUser' value='"+idUser+"'/></td></tr>";
						$("#mytable_cherche tbody").append(makeup);
					}
                                        $("#header_add_friend").hide();
                                        $("#mytable").hide();
					$("#mytable_cherche").show();
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
	                alertMsg(msg);
	        	}
		});
			return false;
		}
	});
});

function alertMsg(msg){
	alert(msg);
}