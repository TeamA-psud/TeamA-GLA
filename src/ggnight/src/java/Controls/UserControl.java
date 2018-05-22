package Controls;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Functions.UserFunctions;
import Models.Utilisateur;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class UserControl
 */
public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hiddenRegistration = request.getParameter("hiddenRegistration");
		String HiddenLoginValue = request.getParameter("HiddenLoginValue");
		String changeInfo = request.getParameter("changeInfo");
		String HiddenChangePassword = request.getParameter("HiddenChangePassword");
		String hiddenChangePreferences = request.getParameter("hiddenChangePreferences");
		if(hiddenRegistration != null){
			//inscription
			System.out.println("SERVLET DONE");
			String returnResult = "";
			boolean testInscription = false;
			String nom = request.getParameter("nom");
			System.out.println(nom);
			String prenom = request.getParameter("prenom");
			System.out.println(prenom);
			int age = Integer.parseInt(request.getParameter("age"));
			System.out.println(age);
			String adresse = request.getParameter("adresse");
			System.out.println(adresse);
			String datenaiss = request.getParameter("datenaiss");
			System.out.println(datenaiss);
			String email = request.getParameter("email");
			System.out.println(email);
			String password = request.getParameter("password");
                        String encryptPassword ="";
                    try {
                            encryptPassword = UserFunctions.encryptPasswordMD5(password);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
			System.out.println(password);
			double budget = Double.parseDouble(request.getParameter("budget"));
			System.out.println(budget);
			String sex = request.getParameter("sex");
			System.out.println(sex);
			String transport = request.getParameter("transport");
			System.out.println(transport);
			String prefAlimentaire = request.getParameter("PrefAlimentaireString");
			List<String> prefAlimString = new ArrayList<String>(Arrays.asList(prefAlimentaire.split(",")));
			ArrayList<Integer> idPrefAlim = new ArrayList<Integer>();
			for(int i=0 ; i<prefAlimString.size() ; i++){
				idPrefAlim.add(Integer.parseInt(prefAlimString.get(i).toString()));
			}
			System.out.println(prefAlimentaire);
			int phone = Integer.parseInt(request.getParameter("phone"));
			System.out.println(phone);
			Utilisateur user = new Utilisateur(nom, prenom, adresse, email,encryptPassword, sex, transport, age, phone, budget,datenaiss,idPrefAlim);
			try {
				testInscription = UserFunctions.Inscription(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!testInscription){
				returnResult = "Vous avez un age qui est inférieur a 18 ! ou une érreur est apparue (refaire a nouveau)";
			}else{
				returnResult = "Inscription réussie";
			}
			response.setContentType("text/plain");
			response.getWriter().write(returnResult);
		}
		
		if(HiddenLoginValue != null){
			System.out.println("LOGIN SECTION");
			//authentification
			Utilisateur user = null;
			String email = request.getParameter("email");
			String password = request.getParameter("password");
                        String encryptPassword = "";
                    try {
                        encryptPassword = UserFunctions.encryptPasswordMD5(password);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
			try {
				user = UserFunctions.Authentification(email,encryptPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user == null){
				String returnResult = "error";
				response.setContentType("text/plain");
				response.getWriter().write(returnResult);
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("nom",user.getNom());
				session.setAttribute("prenom",user.getPrenom());
				session.setAttribute("email",user.getEmail());
			}
		}
		
		if(changeInfo != null){
			//modifier les informations perso
			boolean confirmeChange = false;
			String returnResult = "";
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int age = Integer.parseInt(request.getParameter("age"));
			String adresse = request.getParameter("adresse");
			String date = request.getParameter("date");
			int phone = Integer.parseInt(request.getParameter("phone"));
			String sex = request.getParameter("sex");
			double budget = Double.parseDouble(request.getParameter("budget"));
			String email = request.getParameter("email");
			String transport = request.getParameter("transport");
			Utilisateur user = new Utilisateur(nom,prenom,age,adresse,date,phone,sex,transport,budget);
			try {
				confirmeChange = UserFunctions.ConfirmePersoChange(user,email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(confirmeChange){
				returnResult = "Modification apport�s avec succ�es";
				response.setContentType("text/plain");
				response.getWriter().write(returnResult);
			}else{
				returnResult = "Erreur dans la modification des donn�es!";
				response.setContentType("text/plain");
				response.getWriter().write(returnResult);
			}
		}
		if(HiddenChangePassword != null){
			String returnResult = "";
			String email = request.getParameter("email");
			String newPassword = request.getParameter("newPassword");
                        String encryptNewPassword = "";
                    try {
                        encryptNewPassword = UserFunctions.encryptPasswordMD5(newPassword);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
			boolean confirmeChangePass = false;
			try {
				confirmeChangePass = UserFunctions.ChangerPassword(email,encryptNewPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(confirmeChangePass){
				returnResult = "Mot de passe chang� avec succ�es";
				response.setContentType("text/plain");
				response.getWriter().write(returnResult);
			}else{
				returnResult = "Une erreur est apparu";
				response.setContentType("text/plain");
				response.getWriter().write(returnResult);
			}
		}
		
		if(hiddenChangePreferences != null){
			//confirmer le changement des pr�f�rences
			boolean confirmeUpdate = false;
			boolean testConfirme = false;
			String returnQuery = "";
			String prefAlimentaire = request.getParameter("PrefAlimentaireString");
			System.out.println("pref alim are : "+prefAlimentaire);
			List<String> prefAlimString = new ArrayList<String>(Arrays.asList(prefAlimentaire.split(",")));
			int idUser = Integer.parseInt(request.getParameter("idUser"));
			ArrayList<Integer> idPrefAlim = new ArrayList<Integer>();
			for(int i=0 ; i<prefAlimString.size() ; i++){
				idPrefAlim.add(Integer.parseInt(prefAlimString.get(i).toString()));
			}
			try {
				boolean testDeleteUser = UserFunctions.DeleteAlimentationUser(idUser);
				if(testDeleteUser){
					for(int i=0 ; i<idPrefAlim.size(); i++){
						confirmeUpdate = UserFunctions.PreferencesChange(idUser,idPrefAlim.get(i));
						if(confirmeUpdate){
							testConfirme = true;
						}else{
							testConfirme = false;
							//break;
						}
					}
				}else{
					returnQuery = "Une �rreur est apparue ! Refaire a nouveau!";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(testConfirme){
				returnQuery = "Changement valid�s avec succ�es";
			}else{
				returnQuery = "Une �rreur est apparue ! Refaire a nouveau!";
			}
			response.setContentType("text/plain");
			response.getWriter().write(returnQuery);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}