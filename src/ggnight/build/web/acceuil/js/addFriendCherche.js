$(document).ready(function(){
	var idFriend =0;
	var idUser=0;
	var HiddenAddFriend = "HiddenAddFriend";
	$("#mytable_cherche").click(function(){
		$(this).each(function(){
			idFriend = $(this).find("td:eq(5) input[type='hidden']").val();
			idUser = $(this).find("td:eq(6) input[type='hidden']").val();
			//alert("id ami est : "+idFriend+" id utilisateur est : "+idUser);
			//idFriend = $("#idFriend").val();
			//idUser = $("#idUser").val();
			//return false;
		});
		$.confirm({
			text: 'Vous etes sur de vouloir ajouter cette personne ?',
			confirm : function(){
				$.ajax({
					url : "http://localhost:8080/ggnight/FriendControl",
					method : "GET",
					dataType : "text",
					data : {
						HiddenAddFriend : HiddenAddFriend,
						idFriend : idFriend,
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
		                    msg = 'Requested JSON parse failed.';
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
			},
			cancel : function(){
				location.reload();
			}
		});
	});
});


function getError(msg){
	alert(msg);
}
function getMsg(msg){
	alert(msg);
}


