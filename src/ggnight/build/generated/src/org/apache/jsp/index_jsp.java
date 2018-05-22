package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <title>Acceuil - BIENVENUE -</title>\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,500' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("    \n");
      out.write("    ");
 
        request.getSession().invalidate();
    
      out.write("\n");
      out.write("</head>\n");
      out.write("<body id=\"page-top\" data-spy=\"scroll\" data-target=\".navbar\">\n");
      out.write("<div id=\"main-wrapper\">\n");
      out.write("    <div id=\"preloader\">\n");
      out.write("        <div id=\"status\">\n");
      out.write("            <div class=\"status-mes\"></div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <header class=\"header\">\n");
      out.write("        <!-- Navigation -->\n");
      out.write("        <nav class=\"navbar main-menu\" role=\"navigation\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-main-collapse\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("                <div class=\"collapse navbar-collapse navbar-right navbar-main-collapse\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <!-- Hidden li included to remove active class from about link when scrolled up past about section -->\n");
      out.write("                        <li class=\"hidden\"><a href=\"#page-top\"></a></li>\n");
      out.write("                        <li><a class=\"page-scroll\" href=\"#section-intro\">Déscription</a></li>\n");
      out.write("                        <li><a class=\"page-scroll\" href=\"#section-pricing\">Services Présentés</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("  \n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"jumbotron text-center\">\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <div class=\"event-date\">BIENVENUE / WELCOME / WILKOMMEN </div>\n");
      out.write("            <h1>GoGo-Night</h1>\n");
      out.write("            <p class=\"lead\">Organiser une sortie pour féter votre retrouvailles et passer une bonne soirée</p>\n");
      out.write("            <button onclick=\"window.location.href='loginregister/login.html'\" type=\"button\" class=\"btn btn-default btn-lg\">LOGIN / REGISTER</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- .Jumbotron-->\n");
      out.write("\n");
      out.write("\n");
      out.write("    <section id=\"section-intro\" class=\"section-wrapper about-event\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <p class=\"lead\">\n");
      out.write("                        Le projet a pour but de réaliser un site web permettant à un ensemble d?amis d?organiser une sortie pour fêter leurs retrouvailles et passer une bonne soirée. Pour cela, le site aura pour objectif de leur trouver trois lieus qui arrangent tout le monde sachant que les amis habitent dans différentes villes d?île de France et ils veulent organiser trois sorties successives.\n");
      out.write("                    </p>\n");
      out.write("                    <p class=\"lead\">\n");
      out.write("                        L?utilisateur a une liste d?ami/es sur un compte sécurisé, il reçoit chaque fin de semaine et sur ses journées libres les bons plans ,qui, en ce temps-là le site émettra une notification qui sera envoyée à sa liste d?ami/es\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    <!-- .about-event -->\n");
      out.write("\n");
      out.write("    <!-- .team -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    <section id=\"section-pricing\" class=\"section-wrapper pricing-section gray-bg\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <div class=\"section-title\">\n");
      out.write("                        <h1>SERVICES PRESENTES</h1>\n");
      out.write("                        <p>Voici les principaux services contenant dans notre siteweb</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-4\">\n");
      out.write("                    <div class=\"pricing-table-default text-center\">\n");
      out.write("                        <div class=\"pricing-head\">\n");
      out.write("                            <h3>GESTION DES AMIS</h3>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"pricing-detail\">\n");
      out.write("                            <ul class=\"pricing-list pink-i\">\n");
      out.write("                                <li>Chercher des amis</li>\n");
      out.write("                                <li>Ajouter & Supprimer des amis</li>\n");
      out.write("                                <li>Consulter la liste des amis & liste d'attente</li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.pricing-table-wrapper -->\n");
      out.write("                </div>\n");
      out.write("                <!-- .col-sm-4 -->\n");
      out.write("\n");
      out.write("                <div class=\"col-sm-4\">\n");
      out.write("                    <div class=\"pricing-table-default text-center\">\n");
      out.write("                        <div class=\"pricing-head\">\n");
      out.write("                            <h3>GESTION DES SOIREES</h3>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"pricing-detail\">\n");
      out.write("                            <ul class=\"pricing-list pink-i\">\n");
      out.write("                                <li>Organiser une soirée</li>\n");
      out.write("                                <li>Consulter le planning des soirées</li>\n");
      out.write("                                <li>Notifier vos invités</li>\n");
      out.write("                                <li>La recherche du lieu se fait en se basant sur les préférences alimentaire, budget, date/heure d'ouverture et ferméture du lieu</li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.pricing-table-wrapper -->\n");
      out.write("                </div>\n");
      out.write("                <!-- .col-sm-4 -->\n");
      out.write("\n");
      out.write("                <div class=\"col-sm-4\">\n");
      out.write("                    <div class=\"pricing-table-default text-center\">\n");
      out.write("                        <div class=\"pricing-head\">\n");
      out.write("                            <h3>GESTION DU PROFIL</h3>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"pricing-detail\">\n");
      out.write("                            <ul class=\"pricing-list pink-i\">\n");
      out.write("                                <li>Modifier vos informations personneles </li>\n");
      out.write("                                <li>Modifier votre mot de passe actuelle</li>\n");
      out.write("                                <li>Changer vos préférences alimentaires</li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </section>\n");
      out.write("</div>\n");
      out.write("<script src=\"js/jquery-2.1.4.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- Bootstrap -->\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- Plugin JavaScript -->\n");
      out.write("<script src=\"js/jquery.easing.min.js\"></script>\n");
      out.write("\n");
      out.write("<!--<script src=\"js/one-page-nav.js\"></script>-->\n");
      out.write("<script src=\"js/scripts.js\"></script>\n");
      out.write("</body>\n");
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
