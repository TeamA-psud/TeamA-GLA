package Functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Utilisateur;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FriendFunctions {
	
	//m�thode pour ajouter un ami 
	public static boolean AjouterAmi(int idUser,int idFriend) throws SQLException{
		int etatEnvoi =1;int notiVue=0;
		String sql = "INSERT INTO amis(idUtilisateur,idAmi,etatEnvoi,notiVue)VALUES(?,?,?,?)";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setInt(1,idUser);
		stat.setInt(2,idFriend);
		stat.setInt(3,etatEnvoi);
		stat.setInt(4,notiVue);
		int executeQuery = stat.executeUpdate();
		if(executeQuery <= 0){
			return false;
		}else{
			return true;
		}
	}
	
	//m�thode pour r�cup�rer les utilisateurs qui ont envoy� une demande d'ami
	public static ArrayList<Utilisateur> userSendenRequest(int idUser) throws SQLException{
		String sql = "SELECT idUtilisateur FROM amis WHERE idAmi = ? AND etatEnvoi = 1 AND notiVue = 0";
		ArrayList<Utilisateur> userSenden = new ArrayList<Utilisateur>();
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setInt(1,idUser);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			int ID_USER = result.getInt("idUtilisateur");
			Utilisateur user = UserFunctions.getInfoUserFromId(ID_USER);
			userSenden.add(user);
		}
		return userSenden;
	}
	
	//m�thode pour rejeter une demande d'ami
	public static boolean rejectRequestFriend(int idUser,int idFriend) throws SQLException{
		String sql = "DELETE FROM amis WHERE idUtilisateur = ? AND idAmi = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setInt(1,idUser);
		stat.setInt(2,idFriend);
		int resultRequest = stat.executeUpdate();
		if(resultRequest <= 0){
			return false;
		}else{
			return true;
		}
	}
	
	//m�thode pour confirmer l'ajout d'un ami
	public static boolean acceptRequestFriend(int idUser,int idFriend) throws SQLException{
		String sql = "UPDATE amis SET notiVue = 1 , etatEnvoi = 2 WHERE idUtilisateur = ? AND idAmi = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setInt(1,idUser);
		stat.setInt(2,idFriend);
		int resultRequest = stat.executeUpdate();
		if(resultRequest <= 0){
			return false;
		}else{
			String sqlRelation = "INSERT INTO amis(idUtilisateur,idAmi,etatEnvoi,notiVue)VALUES(?,?,?,?)";
			PreparedStatement stat1 = cnx.prepareStatement(sqlRelation);
			stat1.setInt(1,idFriend);
			stat1.setInt(2,idUser);
			stat1.setInt(3,2);
			stat1.setInt(4,1);
			int resultRequest1 = stat1.executeUpdate();
			if(resultRequest1 <= 0){
				return false;
			}else{
				return true;
			}
		}
	}
	
	//m�thode pour afficher la liste d'amis
	public static ArrayList<Utilisateur> listFriend(int idUser) throws SQLException{
		ArrayList<Utilisateur> allFriends = new ArrayList<Utilisateur>();
		String sqlIdFriends = "SELECT idAmi FROM amis WHERE idUtilisateur = ? AND etatEnvoi = 2";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sqlIdFriends);
		stat.setInt(1,idUser);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			int ID_USER = result.getInt("idAmi");
			Utilisateur oneUser = UserFunctions.getInfoUserFromId(ID_USER);
			allFriends.add(oneUser);
		}
		return allFriends;
	}
	
	//m�thode pour afficher la liste d'attente des amis
	public static ArrayList<Utilisateur> listAttente(int idUser) throws SQLException{
		ArrayList<Utilisateur> attente = new ArrayList<Utilisateur>();
		String sql = "SELECT idAmi FROM amis WHERE idUtilisateur = ? AND etatEnvoi = 1";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setInt(1,idUser);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			int ID_USER = result.getInt("idAmi");
			Utilisateur oneUser = UserFunctions.getInfoUserFromId(ID_USER);
			attente.add(oneUser);
		}
		return attente;
	}
	
	//m�thode pour supprimer un ami
	public static boolean DeleteFriend(int idUser , int idFriend) throws SQLException{
		String sql = "DELETE FROM amis WHERE idUtilisateur = ? AND idAmi = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setInt(1,idUser);
		stat.setInt(2,idFriend);
		int confirmeDelete = stat.executeUpdate();
		if(confirmeDelete <= 0){
			return false;
		}else{
			return true;
		}
	}
	
	//m�thode pour chercher un ami
	public static ArrayList<Utilisateur> friendSearchFind(String nom,String prenom) throws SQLException{
		String sql ="";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = null;
		ArrayList<Utilisateur> friendsFind = new ArrayList<Utilisateur>();
		if(nom.equalsIgnoreCase("")){
			sql = "SELECT Nom,Prenom,Age,Adresse FROM utilisateur WHERE Prenom = ?";
			stat = cnx.prepareStatement(sql);
			stat.setString(1,prenom);
		}else if(prenom.equalsIgnoreCase("")){
			sql = "SELECT Nom,Prenom,Age,Adresse FROM utilisateur WHERE Nom = ?";
			stat = cnx.prepareStatement(sql);
			stat.setString(1,nom);
		}else{
			sql = "SELECT idUtilisateur,Nom,Prenom,Age,Adresse FROM utilisateur WHERE Nom = ? AND Prenom = ?";
			stat = cnx.prepareStatement(sql);
			stat.setString(1,nom);
			stat.setString(2,prenom);
		}
		ResultSet result = stat.executeQuery();
		while(result.next()){
			int ID = result.getInt("idUtilisateur");
			String NOM = result.getString("Nom");
			String PRENOM = result.getString("Prenom");
			int AGE = result.getInt("Age");
			String ADRESSE = result.getString("Adresse");
			Utilisateur user = new Utilisateur(NOM, PRENOM, AGE,ADRESSE,ID);
			friendsFind.add(user);
		}
		return friendsFind;
	}
        
        //méthode pour afficher les anniversaires des amis
        public static ArrayList<Utilisateur> birthdaysFriends(int idUser) throws SQLException {
            ArrayList<Utilisateur> allFriendsBirthdays = new ArrayList<Utilisateur>();
            System.out.println("idUser from birthdayFriends is : "+idUser);
            String sqlIdFriend = "SELECT * FROM amis WHERE idUtilisateur = ?";
            Connection cnx = DBConnect.ConnectDB();
            PreparedStatement stat = cnx.prepareStatement(sqlIdFriend);
            stat.setInt(1,idUser);
            ResultSet result = stat.executeQuery();
            while(result.next()){
                    int idAmi = result.getInt("idAmi");
                    System.out.println("idAmi est : "+idAmi);
                    String dateFriendString = UserFunctions.getInfoUserFromId(idAmi).getDate();
                    System.out.println("Date friend is : "+dateFriendString);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateFriend = null;
                try {
                    dateFriend = format.parse(dateFriendString); //
                } catch (ParseException ex) {
                    Logger.getLogger(FriendFunctions.class.getName()).log(Level.SEVERE, null, ex);
                }
                    Date getTodayDate = new Date();
                    String stringTodayDate = format.format(getTodayDate);
                    Date todayDate = null;
                try {
                    todayDate = format.parse(stringTodayDate); //
                } catch (ParseException ex) {
                    Logger.getLogger(FriendFunctions.class.getName()).log(Level.SEVERE, null, ex);
                }
                    Calendar calFriend = Calendar.getInstance();
                    Calendar calToday = Calendar.getInstance();
                    calFriend.setTime(dateFriend);
                    calToday.setTime(todayDate);
                    if((calFriend.get(Calendar.MONTH) == calToday.get(Calendar.MONTH))&&(calFriend.get(Calendar.DAY_OF_MONTH) == calToday.get(Calendar.DAY_OF_MONTH))){
                    String NOM = UserFunctions.getInfoUserFromId(idAmi).getNom();
                    String PRENOM = UserFunctions.getInfoUserFromId(idAmi).getPrenom();
                    String name = NOM + " " + PRENOM;
                    Utilisateur userBirthday = new Utilisateur(name);
                    allFriendsBirthdays.add(userBirthday);
                    }
            }
            String userDate = UserFunctions.getInfoUserFromId(idUser).getDate();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateUser = null;
            try {
                dateUser = format.parse(userDate);
            } catch (ParseException ex) {
                Logger.getLogger(FriendFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
            Date getTodayDate = new Date();
            String stringTodayDate = format.format(getTodayDate);
            Date todayDate = null;
            try {
                todayDate = format.parse(stringTodayDate); //
            } catch (ParseException ex) {
                Logger.getLogger(FriendFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
            Calendar calFriend = Calendar.getInstance();
            Calendar calToday = Calendar.getInstance();
            calFriend.setTime(dateUser);
            calToday.setTime(todayDate);
            if((calFriend.get(Calendar.MONTH) == calToday.get(Calendar.MONTH))&&(calFriend.get(Calendar.DAY_OF_MONTH) == calToday.get(Calendar.DAY_OF_MONTH))){
                String NOM = UserFunctions.getInfoUserFromId(idUser).getNom();
                String PRENOM = UserFunctions.getInfoUserFromId(idUser).getPrenom();
                String name = NOM + " " + PRENOM;
                Utilisateur userBirthday = new Utilisateur(name);
                allFriendsBirthdays.add(userBirthday);
            }
            return allFriendsBirthdays;
        }
}
