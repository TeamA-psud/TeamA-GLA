<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<form name="firstForm" action="Controleur"
style="width:50%;margin:auto;background-color:#c1d9fc;padding-bottom:15px;" method="post">
                 
        <h2 style="text-align:center;color:white;background-color:#6683b1;">Espace Client</h2>
        <p style="text-align:center;">Mail : <input type="text" name="login" /></p>
        <p style="text-align:center;">mot de passe : <input type="password" name="pwd" /></p>
             
        <p style="text-align:center;width:50%;margin:auto;"><input type="submit" name="Valider" value="Valider"/></p>
         
    </form>
</body>
</html>
