<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Acceuil - BIENVENUE -</title>
    <link href='https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,500' rel='stylesheet' type='text/css'>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
    <% 
        request.getSession().invalidate();
    %>
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar">
<div id="main-wrapper">
    <div id="preloader">
        <div id="status">
            <div class="status-mes"></div>
        </div>
    </div>
    <header class="header">
        <!-- Navigation -->
        <nav class="navbar main-menu" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                    <ul class="nav navbar-nav">
                        <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                        <li class="hidden"><a href="#page-top"></a></li>
                        <li><a class="page-scroll" href="#section-intro">Déscription</a></li>
                        <li><a class="page-scroll" href="#section-pricing">Services Présentés</a></li>
                    </ul>
                </div>

            </div>
  
        </nav>


    </header>

    <div class="jumbotron text-center">
        <div class="content">
            <div class="event-date">BIENVENUE / WELCOME / WILKOMMEN </div>
            <h1>GoGo-Night</h1>
            <p class="lead">Organiser une sortie pour féter votre retrouvailles et passer une bonne soirée</p>
            <button onclick="window.location.href='loginregister/login.html'" type="button" class="btn btn-default btn-lg">LOGIN / REGISTER</button>
        </div>
    </div>
    <!-- .Jumbotron-->


    <section id="section-intro" class="section-wrapper about-event">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <p class="lead">
                        GoGoNight est un assistant d'organisation des soirées, il  permet à un ensemble d'amis d'organiser une sortie pour fêter leurs retrouvailles. Pour cela, le site a pour objectif de leur trouver un lieu qui  arrange tout le monde parmi les trois lieux suivants( restaurant, bar ou boite de nuit). le site fonctionne sur la region parisienne et accepte que des personnes majeurs.
                    </p>
                    <p class="lead">
                        L'utilisateur a une liste d'ami/es sur un compte sécurisé, il reçoit des notifications d'invitations à des évènements comme il peut lui meme etre organisateur d'une sorties et inviter ses amis.
                    </p>
                </div>
            </div>
        </div>
    </section>
    <!-- .about-event -->

    <!-- .team -->


    <section id="section-pricing" class="section-wrapper pricing-section gray-bg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-title">
                        <h1>SERVICES PRESENTES</h1>
                        <p>Voici les principaux services contenant dans notre siteweb</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="pricing-table-default text-center">
                        <div class="pricing-head">
                            <h3>GESTION DES AMIS</h3>
                        </div>
                        <div class="pricing-detail">
                            <ul class="pricing-list pink-i">
                                <li>Chercher des amis</li>
                                <li>Ajouter & Supprimer des amis</li>
                                <li>Consulter la liste des amis & liste d'attente</li>
                            </ul>
                        </div>
                    </div>
                    <!-- /.pricing-table-wrapper -->
                </div>
                <!-- .col-sm-4 -->

                <div class="col-sm-4">
                    <div class="pricing-table-default text-center">
                        <div class="pricing-head">
                            <h3>GESTION DES SOIREES</h3>
                        </div>
                        <div class="pricing-detail">
                            <ul class="pricing-list pink-i">
                                <li>Organiser une soirée</li>
                                <li>Consulter le planning des soirées</li>
                                <li>Notifier vos invités</li>
                                <li>La recherche du lieu se fait en se basant sur les préférences alimentaire, budget, date/heure d'ouverture et ferméture du lieu</li>
                            </ul>
                        </div>
                    </div>
                    <!-- /.pricing-table-wrapper -->
                </div>
                <!-- .col-sm-4 -->

                <div class="col-sm-4">
                    <div class="pricing-table-default text-center">
                        <div class="pricing-head">
                            <h3>GESTION DU PROFIL</h3>
                        </div>
                        <div class="pricing-detail">
                            <ul class="pricing-list pink-i">
                                <li>Modifier vos informations personneles </li>
                                <li>Modifier votre mot de passe actuelle</li>
                                <li>Changer vos préférences alimentaires</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </section>
</div>
<script src="js/jquery-2.1.4.min.js"></script>

<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>

<!-- Plugin JavaScript -->
<script src="js/jquery.easing.min.js"></script>

<!--<script src="js/one-page-nav.js"></script>-->
<script src="js/scripts.js"></script>
</body>
</html>