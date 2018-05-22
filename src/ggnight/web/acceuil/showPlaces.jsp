<%@page import="Models.Soiree"%>
<%@page import="Functions.PlaceAPIFunction"%>
<%@page import="Functions.GeoLocationFunction"%>
<%@page import="Models.GeoLocation"%>
<%@page import="Models.Place"%>
<%@page import="Functions.FriendFunctions"%>
<%@page import="Models.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Functions.NotificationFunction"%>
<%@page import="Functions.UserFunctions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Résultat de la recherche</title>
	<link href="acceuil/css/bootstrap.min.css" rel="stylesheet">
	<link href="acceuil/css/font-awesome.min.css" rel="stylesheet">
	<link href="acceuil/css/datepicker3.css" rel="stylesheet">
	<link href="acceuil/css/styles.css" rel="stylesheet">
	
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        <!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
        	<%
		String nom = (String)request.getSession().getAttribute("nom");
		String prenom = (String)request.getSession().getAttribute("prenom");
		String email = (String)request.getSession().getAttribute("email");
		int idUser = UserFunctions.getIdUser(email);
		int notificationNotSeen = NotificationFunction.getNotSeenFriendRequest(idUser);
		ArrayList<Utilisateur> userSendenRequest = FriendFunctions.userSendenRequest(idUser);
                int notificationSoireeNotSeen = NotificationFunction.getNotSeenEventSend(idUser);
                ArrayList<Soiree> InviteSoiree = NotificationFunction.showNotSeenNoti(idUser);
                ArrayList<Integer> allIds = (ArrayList<Integer>) request.getAttribute("ids");
                String date = (String)request.getAttribute("date");
                String time = (String)request.getAttribute("time");
                String timeEnd = (String)request.getAttribute("timeEnd");
                String IDPersons = allIds.toString();
                if(allIds == null){
                    System.out.println("Integer IDs are null");
                }
                ArrayList<GeoLocation> allLocations = new ArrayList<GeoLocation>();
                ArrayList<String> PrefAlim = new ArrayList<String>();
                System.out.println("Integer IDs in JSP are : "+allIds.toString());
                try{
                    PrefAlim = UserFunctions.AlimentationType(allIds);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                    ArrayList<Place> allPlacesResto = new ArrayList<Place>();
                    ArrayList<Place> allPlacesBar = new ArrayList<Place>();
                    ArrayList<Place> allPlacesNightClub = new ArrayList<Place>();
                try{
                        allPlacesResto = PlaceAPIFunction.getPlace(PrefAlim,"restaurant", allIds,date,time,timeEnd);
			allPlacesBar = PlaceAPIFunction.getPlace(PrefAlim, "bar",allIds,date,time,timeEnd);
			allPlacesNightClub = PlaceAPIFunction.getPlace(PrefAlim, "night_club",allIds,date,time,timeEnd);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
		/*ArrayList<Place> placeResto = (ArrayList<Place>)request.getAttribute("resto");
		ArrayList<Place> placeBar = (ArrayList<Place>) request.getAttribute("bar");
                ArrayList<Place> placeNightClub = (ArrayList<Place>) request.getAttribute("nightclub");
                System.out.println("Resto in JSP : "+placeResto.toString());
                System.out.println("Bar in JSP : "+placeBar.toString());
                System.out.println("NightClub in JSP :"+placeNightClub.toString());*/
	%>
</head>

<body>
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a class="navbar-brand" href="#"><span><%= nom %></span><%= prenom %></a>
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                                <em class="fa fa-envelope"></em><span class="label label-danger"><%= notificationSoireeNotSeen %></span>
					</a>
						<ul class="dropdown-menu dropdown-messages">
							<li class="divider"></li>
							<li>
								<% for(int i=0 ; i< InviteSoiree.size() ; i++ ){ %>
                                                                <div class="dropdown-messages-box"><a href="profile.html" class="pull-left">
									</a>
									<div class="message-body"><small class="pull-right">Pour une soirée</small>
                                                                            <a href="#">Vous avez été inviter par :<strong><%= InviteSoiree.get(i).getOrganisateur() %></strong>.</a>
                                                                            <br /><small class="text-muted"><%= InviteSoiree.get(i).getDate()+" a :"+InviteSoiree.get(i).getdHeure() %></small></div>
								<input type="hidden" id="idUser" value="<%= idUser%>"/>
                                                                    <input type="submit" id="confirme" value="Confirmer" />
                                                                    <input type="submit" id="reject" value="Refuser" />
                                                                </div>
                                                                <% } %>
							</li>
							
						</ul>
					</li>
					<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
						<em class="fa fa-bell"></em><span class="label label-info"><%=notificationNotSeen %></span>
					</a>
						<ul class="dropdown-menu dropdown-alerts">
							<strong>Vous avez <%=notificationNotSeen %> demande d'ajout</strong>
						    <%for(int i=0 ; i<userSendenRequest.size() ; i++){ %>
							<li><a href="">
								<div><em class="fa fa-envelope"></em><%=userSendenRequest.get(i).getNom()+" "+userSendenRequest.get(i).getPrenom() %>
									<span class="pull-right text-muted small"></span></div>
									<input type="hidden" id="idUser" value="<%=userSendenRequest.get(i).getId()%>"/>
									<input type="hidden" id="idFriend" value="<%=idUser%>"/>
									<input type="submit" value="Confirmer" id="confirmAdd"/>
									<input type="submit" value="Rejeter" id="rejectAdd"/>
							</a></li>
							<%} %>
						</ul>
					</li>
				</ul>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-usertitle">
				<div class="profile-usertitle-name"><%=prenom %></div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<ul class="nav menu">
			<li class="active"><a href="acceuil/acceuil.jsp"><em class="fa fa-dashboard">&nbsp;</em>Acceuil</a></li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-2">
				<em class="fa fa-navicon">&nbsp;</em>Gestion des soirées<span data-toggle="collapse" href="#sub-item-2" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li><a class="" href="acceuil/addEvent.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Organiser une soirée
					</a></li>
					<li><a class="" href="acceuil/deleteEvent.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Supprimer une soirée
					</a></li>
					<li><a class="" href="acceuil/planningEvent.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Planning soirée
					</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-1">
				<em class="fa fa-navicon">&nbsp;</em>Gestion des amis<span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li><a class="" href="acceuil/allUsers.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Consulter liste amis
					</a></li>
					<li><a class="" href="acceuil/addUser.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Ajouter des amis
					</a></li>
					<li><a class="" href="acceuil/deleteFriend.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Supprimer des amis
					</a></li>
				</ul>
			</li>
			<li><a href="acceuil/gestionCompte.jsp"><em class="fa fa-calendar">&nbsp;</em>Gestion du compte</a></li>
			<li><a href="http://localhost:8080/ggnight/"><em class="fa fa-power-off">&nbsp;</em>Déconnecter</a></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		
		
		<div class="row">
			<div class="col-lg-8">
				<h4 class="page-header">Résultat de la recherche</h4>
			</div>
		</div><!--/.row-->
				<h4>Réstaurants</h4>
                                <table id="restoSearch" class="table">
					<thead>
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Adresse</th>
							<th scope="col">Rating</th>
							<th scope="col">Distance</th>
							<th scope="col">Duration</th>
                                                        <th scope="col">Transport</th>
							<th scope="col">Ouvert maintenant ?</th>
						</tr>
					</thead>
					<tbody>
							<%for(int i=0; i<allPlacesResto.size() ; i++){ %>
                                                <tr>
								<td><%=allPlacesResto.get(i).getName() %></td>
								<td><%=allPlacesResto.get(i).getAdresse() %></td>
								<td><%=allPlacesResto.get(i).getRating() %></td>
								<td><%=allPlacesResto.get(i).getDistance().getDistance() %></td>
								<td><%=allPlacesResto.get(i).getDistance().getDuration() %></td>
                                                                <td><%=allPlacesResto.get(i).getTransport() %></td>
								<td><%=allPlacesResto.get(i).isOpennow() %></td>
                                                                <td><input type="hidden" value="<%=allPlacesResto.get(i).getPlaceId() %>" /></td>
                                                                <td><input type="hidden" value="<%=IDPersons %>" /></td>
                                                                <td><input type="hidden" value="<%=allPlacesResto.get(i).getUrl() %>" /></td>
						</tr>       
                                                                <%} %>
					</tbody>
				</table>
				
				
				<h4>Bar</h4>
				<table id="barSearch" class="table">
					<thead>
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Adresse</th>
							<th scope="col">Rating</th>
							<th scope="col">Distance</th>
							<th scope="col">Duration</th>
                                                        <th scope="col">Transport</th>
							<th scope="col">Ouvert maintenant ?</th>
						</tr>
					</thead>
					<tbody>
							<%for(int i=0; i<allPlacesBar.size() ; i++){ %>
                                                        <tr>
								<td><%=allPlacesBar.get(i).getName() %></td>
								<td><%=allPlacesBar.get(i).getAdresse() %></td>
								<td><%=allPlacesBar.get(i).getRating() %></td>
								<td><%=allPlacesBar.get(i).getDistance().getDistance() %></td>
								<td><%=allPlacesBar.get(i).getDistance().getDuration() %></td>
                                                                <td><%=allPlacesBar.get(i).getTransport() %></td>
								<td><%=allPlacesBar.get(i).isOpennow() %></td>
                                                                <td><input type="hidden" id="placeId" value="<%= allPlacesBar.get(i).getPlaceId() %>" /></td>
                                                                <td><input type="hidden" value="<%=IDPersons %>" /></td>
                                                                <td><input type="hidden" value="<%=allPlacesBar.get(i).getUrl() %>" /></td>
                                                        </tr>
                                                                <%} %>
					</tbody>
				</table>
				
				<h4>NightClub</h4>
				<table id="nightClubSearch" class="table">
					<thead>
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Adresse</th>
							<th scope="col">Rating</th>
							<th scope="col">Distance</th>
							<th scope="col">Duration</th>
                                                        <th scope="col">Transport</th>
							<th scope="col">Ouvert maintenant ?</th>
						</tr>
					</thead>
					<tbody>
						
							<%for(int i=0; i<allPlacesNightClub.size() ; i++){ %>
                                                        <tr>
								<td><%=allPlacesNightClub.get(i).getName() %></td>
								<td><%=allPlacesNightClub.get(i).getAdresse() %></td>
								<td><%=allPlacesNightClub.get(i).getRating() %></td>
								<td><%=allPlacesNightClub.get(i).getDistance().getDistance() %></td>
								<td><%=allPlacesNightClub.get(i).getDistance().getDuration() %></td>
                                                                <td><%=allPlacesNightClub.get(i).getTransport() %></td>
								<td><%=allPlacesNightClub.get(i).isOpennow() %></td>
                                                                <td><input type="hidden" id="placeId" value="<%= allPlacesNightClub.get(i).getPlaceId() %>" /></td>
                                                                <td><input type="hidden" value="<%=IDPersons %>" /></td>
                                                                <td><input type="hidden" value="<%=allPlacesNightClub.get(i).getUrl() %>" /></td>
                                                        </tr>
							<%} %>
					</tbody>
				</table>
	</div>	<!--/.main-->
        <script type="text/javascript" src="acceuil/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="acceuil/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="acceuil/js/chart.min.js"></script>
	<script type="text/javascript" src="acceuil/js/chart-data.js"></script>
	<script type="text/javascript" src="acceuil/js/easypiechart.js"></script>
	<script type="text/javascript" src="acceuil/js/easypiechart-data.js"></script>
	<script type="text/javascript" src="acceuil/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="acceuil/js/custom.js"></script>
	<script type="text/javascript" src="acceuil/js/jquery.confirm.js"></script>
	<script type="text/javascript" src="acceuil/js/jquery.confirm.min.js"></script>
	<script type="text/javascript" src="acceuil/js/jquery-ui.js"></script>
	<script type="text/javascript" src="acceuil/js/jquery-ui.min.js"></script>
        <script src="acceuil/js/confirmAddEvent.js"></script>
	<script src="acceuil/js/rejectFriend.js"></script>
	<script src="acceuil/js/confirmAddFriend.js"></script>		
</body>
</html>