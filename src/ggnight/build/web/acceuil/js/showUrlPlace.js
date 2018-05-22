$(document).ready(function(){
    var urlPlace ="";
   $("#showUrlPlace tbody tr").click(function(){
       $(this).each(function(){
           urlPlace = $(this).find("td:eq(5) input[type='hidden']").val();
           window.open(urlPlace,"Détail du lieu","width=800,height=700,left=0,top=0");
       });
   });
});

