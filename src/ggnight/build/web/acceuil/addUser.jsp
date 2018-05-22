<%@page import="Functions.FriendFunctions"%>
<%@page import="Models.Soiree"%>
<%@page import="Functions.NotificationFunction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Functions.UserFunctions"%>
<%@page import="Models.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ajouter des amis</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>

	<%
		String nom = (String)request.getSession().getAttribute("nom");
		String prenom = (String)request.getSession().getAttribute("prenom");
		String email = (String)request.getSession().getAttribute("email");
		int ID_USER = UserFunctions.getIdUser(email);
                int notificationNotSeen = NotificationFunction.getNotSeenFriendRequest(ID_USER);
		ArrayList<Utilisateur> userSendenRequest = FriendFunctions.userSendenRequest(ID_USER);
		ArrayList<Utilisateur> friendToAdd = UserFunctions.showListFriendToAdd(ID_USER);
                int notificationSoireeNotSeen = NotificationFunction.getNotSeenEventSend(ID_USER);
                ArrayList<Soiree> InviteSoiree = NotificationFunction.showNotSeenNoti(ID_USER);
	%>
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
								<input type="hidden" id="idUser" value="<%=ID_USER%>"/>
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
									<input type="hidden" id="idFriend" value="<%=ID_USER%>"/>
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
			<li class="active"><a href="acceuil.jsp"><em class="fa fa-dashboard">&nbsp;</em>Acceuil</a></li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-2">
				<em class="fa fa-navicon">&nbsp;</em>Gestion des soirées<span data-toggle="collapse" href="#sub-item-2" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li><a class="" href="addEvent.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Organiser une soirée
					</a></li>
					<li><a class="" href="deleteEvent.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Supprimer une soirée
					</a></li>
					<li><a class="" href="planningEvent.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Planning soirée
					</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-1">
				<em class="fa fa-navicon">&nbsp;</em>Gestion des amis<span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li><a class="" href="allUsers.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Consulter liste amis
					</a></li>
					<li><a class="" href="addUser.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Ajouter des amis
					</a></li>
					<li><a class="" href="deleteFriend.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Supprimer des amis
					</a></li>
				</ul>
			</li>
			<li><a href="gestionCompte.jsp"><em class="fa fa-calendar">&nbsp;</em>Gestion du compte</a></li>
			<li><a href="http://localhost:8080/ggnight/"><em class="fa fa-power-off">&nbsp;</em>Déconnecter</a></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
				<div class="panel-heading">Chercher des amis</div>
				<form>
					<div class="form-group">
						<label>Nom</label>
						<input class="form-control" type="text" id="nom" placeholder="Entrer le nom d'un ami"/>
					</div>
					<div class="form-group">
						<label>Prénom</label>
						<input class="form-control" type="text" id="prenom" placeholder="Entrer le prenom d'un ami"/>
					</div>
					<input type="hidden" id="idUser" value="<%=ID_USER %>"/>
					<input type="submit" value="Chercher" id="search" class="btn btn-primary"  />
				</form>
					<div class="panel-body">
						<div class="col-md-12">
							<table id="mytable_cherche" class="table">
								<thead class="thead-dark">
									<tr>
										<th scope="col">Nom</th>
										<th scope="col">Prénom</th>
										<th scope="col">Age</th>
										<th scope="col">Adresse</th>
										<th scope="col">Ajouter</th>
									</tr>
								</thead>
								<tbody>
									
								</tbody>
							</table>
						</div>
					</div>
					<div id="header_add_friend" class="panel-heading">Ajouter des amis</div>
					<div class="panel-body">
						<div class="col-md-12">
							<table id="mytable" class="table">
								<thead class="thead-dark">
									<tr>
										<th scope="col">Nom</th>
										<th scope="col">Prénom</th>
										<th scope="col">Age</th>
										<th scope="col">Adresse</th>
										<th scope="col">Ajouter</th>
									</tr>
								</thead>
								<tbody>
									<%for(int i=0 ; i<friendToAdd.size() ; i++){ %>
										<tr>
											<td><%= friendToAdd.get(i).getNom() %></td>
											<td><%= friendToAdd.get(i).getPrenom() %></td>
											<td><%= friendToAdd.get(i).getAge() %></td>
											<td><%= friendToAdd.get(i).getAdresse() %></td>
											<td><input id="ajouter" type="submit" class="btn btn-primary" value="Confirmer" /></td>
											<td><input type="hidden" id="idFriend" value="<%=friendToAdd.get(i).getId() %>" /></td>
											<td><input type="hidden" id="idUser" value="<%=ID_USER%>" /></td>
										<tr>
									<%} %>
								</tbody>
							</table>
						</div>
					</div>
				</div><!-- /.panel-->
			</div><!-- /.col-->
		</div><!-- /.row -->
	</div><!--/.main-->
	
<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/chercherAmi.js"></script>
	<script src="js/addFriend.js"></script>
        <script src="js/addFriendCherche.js"></script>
        <script src="js/jquery.confirm.js"></script>
	<script src="js/jquery.confirm.min.js"></script>
	<script src="js/rejectFriend.js"></script>
	<script src="js/confirmAddFriend.js"></script>
</body>
</html>