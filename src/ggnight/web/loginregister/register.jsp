<%@page import="Functions.AlimentationFunctions"%>
<%@page import="Models.Alimentation"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>Inscription</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<%
	ArrayList<Alimentation> allAlimentations = AlimentationFunctions.allTypes();
%>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
			<span class="login100-form-title p-b-33">
						Inscription
			</span>
				<form>
  					<div class="form-group">
    				<label for="nom">Nom</label>
    				<input type="text" class="form-control" id="nom" placeholder="Entrer votre nom" required>
  					</div>
  					<div class="form-group">
    				<label for="prenom">Prenom</label>
    				<input type="text" class="form-control" id="prenom" placeholder="Entrer votre prenom" required>
  					</div>
  					<div class="form-group">
    				<label for="nom">Age</label>
    				<input type="number" class="form-control" id="age" placeholder="Entrer votre age" required>
  					</div>
  					<div class="form-group">
    				<label for="nom">Adresse</label>
    				<input type="text" class="form-control" id="adresse" placeholder="Entrer votre adresse" required>
  					</div>
  					<div class="form-group">
    				<label for="nom">Date de naissance</label>
    				<input type="date" class="form-control" id="datenaiss" placeholder="Entrer votre date de naissance" required>
  					</div>
  					<div class="form-group">
    				<label for="nom">Email</label>
    				<input type="email" class="form-control" id="email" placeholder="Entrer votre Email" required>
  					</div>
  					<div class="form-group">
    				<label for="nom">Password</label>
    				<input type="password" class="form-control" id="password" placeholder="Entrer votre password" required>
  					</div>
  					<div class="form-group">
    				<label for="nom">Budget</label>
                                <input type="number" class="form-control" id="budget" placeholder="Entrer votre budget" required>
  					</div>
  					<div class="form-group">
    				<label for="nom">Numéro de téléphone</label>
    				<input type="number" class="form-control" id="phone" placeholder="Entrer votre numéro de téléphone" required>
  					</div>
  					<div class="form-group">
    				<label for="nom">Sex</label>
    				<select class="form-control" id="sex">
						<option value="homme">Homme</option>
						<option value="femme">Femme</option>
					</select>
  					</div>
  					<div class="form-group">
    				<label for="nom">Moyen de transport</label>
    				<select class="form-control" id="transport">
						<option value="voiture">Voiture</option>
						<option value="train">Train</option>
						<option value="tgv">TGV</option>
						<option value="tramway">Tramway</option>
						<option value="bus">Bus</option>
						<option value="walking">A pied</option>
						<option value="velo">Velo</option>
					</select>
  					</div>
  					<div class="form-group">
  					<label for="nom">Préférences Alimentation</label><br>
    				<%for(int i=0 ; i<allAlimentations.size() ; i++){ %>
    					<input type="checkbox" id="pref" name="pref" value="<%=allAlimentations.get(i).getIdAlimentation() %>" /><%=allAlimentations.get(i).getTypeAlimentation() %><br>
    				<%} %>
  					</div>
  					<button type="submit" id="registerButton" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
	

	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
<script src="js/registrationScript.js"></script>
</body>
</html>