package org.apache.jsp.acceuil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Functions.PlaceAPIFunction;
import Functions.GeoLocationFunction;
import Models.GeoLocation;
import Models.Place;
import Functions.FriendFunctions;
import Models.Utilisateur;
import java.util.ArrayList;
import Functions.NotificationFunction;
import Functions.UserFunctions;

public final class showPlaces_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t<title>Résultat de la recherche</title>\r\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/datepicker3.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/styles.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!--Custom Font-->\r\n");
      out.write("\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\r\n");
      out.write("\t<!--[if lt IE 9]>\r\n");
      out.write("\t<script src=\"js/html5shiv.js\"></script>\r\n");
      out.write("\t<script src=\"js/respond.min.js\"></script>\r\n");
      out.write("\t<![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("\t");

		String nom = (String)request.getSession().getAttribute("nom");
		String prenom = (String)request.getSession().getAttribute("prenom");
		String email = (String)request.getSession().getAttribute("email");
		int idUser = UserFunctions.getIdUser(email);
		int notificationNotSeen = NotificationFunction.getNotSeenFriendRequest(idUser);
		ArrayList<Utilisateur> userSendenRequest = FriendFunctions.userSendenRequest(idUser);
                ArrayList<Integer> allIds = (ArrayList<Integer>) request.getAttribute("ids");
                if(allIds == null){
                    System.out.println("Integer IDs are null");
                }
                ArrayList<GeoLocation> allLocations = new ArrayList<GeoLocation>();
                ArrayList<String> PrefAlim = new ArrayList<String>();
                System.out.println("Integer IDs in JSP are : "+allIds.toString());
                try{
                    allLocations = GeoLocationFunction.getLatLongAdresse(allIds);
                    PrefAlim = UserFunctions.AlimentationType(allIds);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                    ArrayList<Place> allPlacesResto = new ArrayList<Place>();
                    ArrayList<Place> allPlacesBar = new ArrayList<Place>();
                    ArrayList<Place> allPlacesNightClub = new ArrayList<Place>();
                try{
                        allPlacesResto = PlaceAPIFunction.getPlace(allLocations, PrefAlim,"restaurant", allIds);
			allPlacesBar = PlaceAPIFunction.getPlace(allLocations, PrefAlim, "bar",allIds);
			allPlacesNightClub = PlaceAPIFunction.getPlace(allLocations, PrefAlim, "night_club",allIds);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
		/*ArrayList<Place> placeResto = (ArrayList<Place>)request.getAttribute("resto");
		ArrayList<Place> placeBar = (ArrayList<Place>) request.getAttribute("bar");
                ArrayList<Place> placeNightClub = (ArrayList<Place>) request.getAttribute("nightclub");
                System.out.println("Resto in JSP : "+placeResto.toString());
                System.out.println("Bar in JSP : "+placeBar.toString());
                System.out.println("NightClub in JSP :"+placeNightClub.toString());*/
	
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<nav class=\"navbar navbar-custom navbar-fixed-top\" role=\"navigation\">\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#sidebar-collapse\"><span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span></button>\r\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" href=\"#\"><span>");
      out.print( nom );
      out.write("</span>");
      out.print( prenom );
      out.write("</a>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-top-links navbar-right\">\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a class=\"dropdown-toggle count-info\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t<em class=\"fa fa-envelope\"></em><span class=\"label label-danger\">15</span>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-messages\">\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"dropdown-messages-box\"><a href=\"profile.html\" class=\"pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<img alt=\"image\" class=\"img-circle\" src=\"http://placehold.it/40/30a5ff/fff\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"message-body\"><small class=\"pull-right\">3 mins ago</small>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\"><strong>John Doe</strong> commented on <strong>your photo</strong>.</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br /><small class=\"text-muted\">1:24 pm - 25/03/2015</small></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"dropdown-messages-box\"><a href=\"profile.html\" class=\"pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<img alt=\"image\" class=\"img-circle\" src=\"http://placehold.it/40/30a5ff/fff\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"message-body\"><small class=\"pull-right\">1 hour ago</small>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\">New message from <strong>Jane Doe</strong>.</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br /><small class=\"text-muted\">12:27 pm - 25/03/2015</small></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"all-button\"><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<em class=\"fa fa-inbox\"></em> <strong>Vous avez ");
      out.print(notificationNotSeen );
      out.write(" demande d'ajout</strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></div>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a class=\"dropdown-toggle count-info\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t<em class=\"fa fa-bell\"></em><span class=\"label label-info\">");
      out.print(notificationNotSeen );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-alerts\">\r\n");
      out.write("\t\t\t\t\t\t\t<strong>Vous avez ");
      out.print(notificationNotSeen );
      out.write(" demande d'ajout</strong>\r\n");
      out.write("\t\t\t\t\t\t    ");
for(int i=0 ; i<userSendenRequest.size() ; i++){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div><em class=\"fa fa-envelope\"></em>");
      out.print(userSendenRequest.get(i).getNom()+" "+userSendenRequest.get(i).getPrenom() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"pull-right text-muted small\"></span></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"idUser\" value=\"");
      out.print(userSendenRequest.get(i).getId());
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"idFriend\" value=\"");
      out.print(idUser);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"Confirmer\" id=\"confirmAdd\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"Rejeter\" id=\"rejectAdd\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div><!-- /.container-fluid -->\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<div id=\"sidebar-collapse\" class=\"col-sm-3 col-lg-2 sidebar\">\r\n");
      out.write("\t\t<div class=\"profile-sidebar\">\r\n");
      out.write("\t\t\t<div class=\"profile-userpic\">\r\n");
      out.write("\t\t\t\t<img src=\"http://placehold.it/50/30a5ff/fff\" class=\"img-responsive\" alt=\"\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"profile-usertitle\">\r\n");
      out.write("\t\t\t\t<div class=\"profile-usertitle-name\">");
      out.print(prenom );
      out.write("</div>\r\n");
      out.write("\t\t\t\t<div class=\"profile-usertitle-status\"><span class=\"indicator label-success\"></span>Online</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"divider\"></div>\r\n");
      out.write("\t\t<ul class=\"nav menu\">\r\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"acceuil.jsp\"><em class=\"fa fa-dashboard\">&nbsp;</em>Acceuil</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"elements.html\"><em class=\"fa fa-toggle-off\">&nbsp;</em>Organiser soirée</a></li>\r\n");
      out.write("\t\t\t<li class=\"parent \"><a data-toggle=\"collapse\" href=\"#sub-item-1\">\r\n");
      out.write("\t\t\t\t<em class=\"fa fa-navicon\">&nbsp;</em>Gestion des amis<span data-toggle=\"collapse\" href=\"#sub-item-1\" class=\"icon pull-right\"><em class=\"fa fa-plus\"></em></span>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul class=\"children collapse\" id=\"sub-item-1\">\r\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"allUsers.jsp\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-arrow-right\">&nbsp;</span>Consulter liste amis\r\n");
      out.write("\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"addUser.jsp\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-arrow-right\">&nbsp;</span>Ajouter des amis\r\n");
      out.write("\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"deleteFriend.jsp\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-arrow-right\">&nbsp;</span>Supprimer des amis\r\n");
      out.write("\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li><a href=\"gestionCompte.jsp\"><em class=\"fa fa-calendar\">&nbsp;</em>Gestion du compte</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"login.html\"><em class=\"fa fa-power-off\">&nbsp;</em>Déconnecter</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div><!--/.sidebar-->\r\n");
      out.write("\t\t\r\n");
      out.write("\t<div class=\"col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-lg-8\">\r\n");
      out.write("\t\t\t\t<h4 class=\"page-header\">Résultat de la recherche</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div><!--/.row-->\r\n");
      out.write("\t\t\t\t<h4>Réstaurants</h4>\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Nom</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Adresse</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Rating</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Distance</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Duration</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Ouvert maintenant ?</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t");
for(int i=0; i<allPlacesResto.size() ; i++){ 
      out.write("\r\n");
      out.write("                                                <tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesResto.get(i).getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesResto.get(i).getAdresse() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesResto.get(i).getRating() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesResto.get(i).getDistance().getDistance() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesResto.get(i).getDistance().getDuration() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesResto.get(i).isOpennow() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("                                                                ");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h4>Bar</h4>\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Nom</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Adresse</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Rating</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Distance</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Duration</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Ouvert maintenant ?</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t");
for(int i=0; i<allPlacesBar.size() ; i++){ 
      out.write("\r\n");
      out.write("                                                        <tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesBar.get(i).getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesBar.get(i).getAdresse() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesBar.get(i).getRating() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesBar.get(i).getDistance().getDistance() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesBar.get(i).getDistance().getDuration() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesBar.get(i).isOpennow() );
      out.write("</td>\r\n");
      out.write("                                                        </tr>\r\n");
      out.write("                                                                ");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h4>NightClub</h4>\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Nom</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Adresse</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Rating</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Distance</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Duration</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th scope=\"col\">Ouvert maintenant ?</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t");
for(int i=0; i<allPlacesNightClub.size() ; i++){ 
      out.write("\r\n");
      out.write("                                                        <tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesNightClub.get(i).getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesNightClub.get(i).getAdresse() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesNightClub.get(i).getRating() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesNightClub.get(i).getDistance().getDistance() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesNightClub.get(i).getDistance().getDuration() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(allPlacesNightClub.get(i).isOpennow() );
      out.write("</td>\r\n");
      out.write("                                                        </tr>\r\n");
      out.write("\t\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t</div>\t<!--/.main-->\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/chart.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/chart-data.js\"></script>\r\n");
      out.write("\t<script src=\"js/easypiechart.js\"></script>\r\n");
      out.write("\t<script src=\"js/easypiechart-data.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap-datepicker.js\"></script>\r\n");
      out.write("\t<script src=\"js/custom.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery.confirm.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery.confirm.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery-ui.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery-ui.min.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\twindow.onload = function () {\r\n");
      out.write("\tvar chart1 = document.getElementById(\"line-chart\").getContext(\"2d\");\r\n");
      out.write("\twindow.myLine = new Chart(chart1).Line(lineChartData, {\r\n");
      out.write("\tresponsive: true,\r\n");
      out.write("\tscaleLineColor: \"rgba(0,0,0,.2)\",\r\n");
      out.write("\tscaleGridLineColor: \"rgba(0,0,0,.05)\",\r\n");
      out.write("\tscaleFontColor: \"#c5c7cc\"\r\n");
      out.write("\t});\r\n");
      out.write("};\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
