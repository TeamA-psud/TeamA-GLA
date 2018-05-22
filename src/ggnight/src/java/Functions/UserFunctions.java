package Functions;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.UserAlim;
import Models.Utilisateur;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class UserFunctions {

	//m�thode pour inscrir un utilisateur
	public static boolean Inscription(Utilisateur user) throws SQLException{
		String sql = "INSERT INTO utilisateur(Nom,Prenom,Age,Adresse,DateNaiss,Phone,Email,Password,Sex,MoyTrans,Budget)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		String dateNaissance = user.getDate();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date NaissDate = null;
                Date todayDate = null;
                int YEARS = 0;
                try{
                    NaissDate = format.parse(dateNaissance);//
                    Date date = new Date();
                    String todayStringDate = dateFormat.format(date);
                    todayDate = format.parse(todayStringDate);//
                    LocalDate localTodayDate = todayDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate localNaissDate = NaissDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    YEARS = Period.between(localNaissDate, localTodayDate).getYears();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                if(YEARS < 18){
                    return false;
                }else{
                    Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stat.setString(1,user.getNom());
		stat.setString(2,user.getPrenom());
		stat.setInt(3,user.getAge());
		stat.setString(4,user.getAdresse());
		stat.setString(5,user.getDate());
		stat.setInt(6,user.getPhone());
		stat.setString(7,user.getEmail());
		stat.setString(8,user.getPassword());
		stat.setString(9,user.getSex());
		stat.setString(10,user.getTransport());
		stat.setDouble(11,user.getBudget());
		int resultQuery = stat.executeUpdate();
		if(resultQuery <= 0){
			return false;
		}else{
			ResultSet result = stat.getGeneratedKeys();
			if(result.next()){
				long id = result.getLong(1);
				int ID = (int)id;
				ArrayList<Integer> allIdAlim = user.getIdAlimPref();
				for(int i=0 ; i<allIdAlim.size(); i++){
					int ID_ALIM = allIdAlim.get(i);
					UserAlim userAlim = new UserAlim(ID, ID_ALIM);
					UserAlimFunction.relationUserAlim(userAlim);
				}
			}
			return true;
		}
                }
                
	}
	
	//m�thode pour l'authentification 
	
	public static Utilisateur Authentification(String email,String password) throws SQLException{
		Utilisateur utilisateur = null;
		String sql = "SELECT * FROM utilisateur WHERE Email = ? AND Password = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setString(1,email);
		stat.setString(2,password);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			utilisateur = new Utilisateur(result.getString("Nom"),result.getString("Prenom"),result.getString("Email"));
		}
		return utilisateur;
	}
	
	//m�thode pour r�cup�rer les informations de l'utilisateur
	public static Utilisateur PersonelInformationUser(String email) throws SQLException{
		Utilisateur user = null;
		String sql = "SELECT * FROM utilisateur WHERE Email = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setString(1,email);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			String NOM = result.getString("Nom");
			String PRENOM = result.getString("Prenom");
			int AGE = result.getInt("Age");
			String ADRESSE = result.getString("Adresse");
			String DATE_NAISS = result.getString("DateNaiss");
			int PHONE = result.getInt("Phone");
			String SEX = result.getString("Sex");
			String TRANSPORT = result.getString("MoyTrans");
			double BUDGET = result.getDouble("Budget");
			user = new Utilisateur(NOM, PRENOM,AGE,ADRESSE,DATE_NAISS,PHONE,SEX,TRANSPORT,BUDGET);
		}
		return user;
	}
	//m�thode pour modifier les informations perso
	public static boolean ConfirmePersoChange(Utilisateur user,String email) throws SQLException{
		String sql = "UPDATE utilisateur SET Nom = ? , Prenom = ? ,Age = ? ,Adresse = ? , DateNaiss = ? , Phone = ? ,Sex = ?,MoyTrans = ?,Budget = ? WHERE Email = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setString(1,user.getNom());
		stat.setString(2,user.getPrenom());
		stat.setInt(3,user.getAge());
		stat.setString(4,user.getAdresse());
		stat.setString(5,user.getDate());
		stat.setInt(6,user.getPhone());
		stat.setString(7,user.getSex());
		stat.setString(8,user.getTransport());
		stat.setDouble(9,user.getBudget());
		stat.setString(10,email);
		int returnResult = stat.executeUpdate();
		if(returnResult <= 0){
			return false;
		}else{
			return true;
		}
	}
	//m�thode pour modifier le mot de passe
	public static boolean ChangerPassword(String email,String newPassword) throws SQLException{
		String sql = "UPDATE utilisateur SET Password = ? WHERE Email = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setString(1,newPassword);
		stat.setString(2,email);
		int executeReturn = stat.executeUpdate();
		if(executeReturn <= 0){
			return false;
		}else{
			return true;
		}
	}
	
	//m�thode pour afficher la liste d'amis a ajouter
	public static ArrayList<Utilisateur> showListFriendToAdd(int idUser) throws SQLException{
		ArrayList<Utilisateur> user = new ArrayList<Utilisateur>();
		ArrayList<Integer> idFriends = new ArrayList<Integer>();
		String sqlAmi = "SELECT idAmi FROM amis WHERE idUtilisateur = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sqlAmi);
		stat.setInt(1,idUser);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			int ID = result.getInt("idAmi");
			idFriends.add(ID);
		}
		System.out.println(idFriends.toString());
		String sqlShowFriend = "SELECT idUtilisateur,Nom,Prenom,Age,Adresse,MoyTrans,DateNaiss FROM utilisateur WHERE idUtilisateur != ?";
		//if(idFriends.toString() != "[]"){
			/*for(int i=0 ; i<idFriends.size() ; i++){
				System.out.println("Parameter is : "+idFriends.get(i));
				PreparedStatement statFriend = cnx.prepareStatement(sqlShowFriend);
				statFriend.setInt(1,idFriends.get(i));
				ResultSet res = statFriend.executeQuery();
				while(res.next()){
					int IDUSER = res.getInt("idUtilisateur");
					String NOM = res.getString("Nom");
					String PRENOM = res.getString("Prenom");
					int AGE = res.getInt("Age");
					String ADRESSE = res.getString("Adresse");
					String TRANSPORT = res.getString("MoyTrans");
					Utilisateur us = new Utilisateur(NOM,PRENOM,AGE,ADRESSE,IDUSER,TRANSPORT);
					user.add(us);
				}
			}*/
		//}else{
			PreparedStatement statFriend = cnx.prepareStatement(sqlShowFriend);
			statFriend.setInt(1,idUser);
			ResultSet res = statFriend.executeQuery();
			while(res.next()){
				int IDUSER = res.getInt("idUtilisateur");
				String NOM = res.getString("Nom");
				String PRENOM = res.getString("Prenom");
				int AGE = res.getInt("Age");
				String ADRESSE = res.getString("Adresse");
				String TRANSPORT = res.getString("MoyTrans");
                                String DateNaiss = res.getString("DateNaiss");
				Utilisateur us = new Utilisateur(NOM,PRENOM,AGE,ADRESSE,IDUSER,TRANSPORT,DateNaiss);
				user.add(us);
			}
		//}
		return user;
	}
	
	//m�thode pour r�cup�rer l'ID a partir de l'email
	public static int getIdUser(String email) throws SQLException{
		String sql = "SELECT idUtilisateur FROM utilisateur WHERE Email = ?";
		int ID_USER=0;
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setString(1,email);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			ID_USER = result.getInt("idUtilisateur");
		}
		return ID_USER;
	}
	
	//m�thode pour r�cup�rer les informations d'une personne a partir de l'ID
	public static Utilisateur getInfoUserFromId(int idUser) throws SQLException{
		String sql = "SELECT Nom,Prenom,Adresse,Age,MoyTrans,DateNaiss FROM utilisateur WHERE idUtilisateur = ?";
		Utilisateur user = null;
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setInt(1,idUser);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			user = new Utilisateur(result.getString("Nom"),
						result.getString("Prenom"), 
						result.getInt("Age"),
						result.getString("Adresse"), 
						idUser,result.getString("MoyTrans"),
                                                    result.getString("DateNaiss"));
		}
		return user;
	}
	//m�thode pour supprimer les alims
	public static boolean DeleteAlimentationUser(int userId) throws SQLException{
		String sqlDELETE = "DELETE FROM useralim WHERE idUtilisateur = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sqlDELETE);
		stat.setInt(1,userId);
		int executeQuery = stat.executeUpdate();
		if(executeQuery <= 0){
			return false;
		}else{
			return true;
		}
	}
	//m�thode pour changer les pr�f�rences alimentaires relative a un utilisateur
	public static boolean PreferencesChange(int userId , int idPrefs) throws SQLException{
		boolean confirmeChange = false;
		String sql = "INSERT INTO useralim(idUtilisateur,idPrefAlim)VALUES(?,?)";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat1 = cnx.prepareStatement(sql);
		stat1.setInt(1,userId);
		stat1.setInt(2,idPrefs);
		int executeInsert = stat1.executeUpdate();
		if(executeInsert <= 0){
			confirmeChange = false;
			return confirmeChange;
		}else{
			confirmeChange = true;
			return confirmeChange;
		}
	}
	
	//m�thode pour r�cup�rer les ID des pr�f�rences alimentaires
	public static ArrayList<String> AlimentationType(ArrayList<Integer> allIds) throws SQLException{
		String sql = "SELECT TypeAlimentation FROM alimentation JOIN useralim WHERE alimentation.idAlimentation=useralim.idPrefAlim AND useralim.idUtilisateur=?";
		ArrayList<String> typeAlimentation = new ArrayList<String>();
                Connection cnx = DBConnect.ConnectDB();
                PreparedStatement stat = cnx.prepareStatement(sql);
                for(int i=0 ; i<allIds.size() ; i++){
                    stat.setInt(1,allIds.get(i));
                    ResultSet result = stat.executeQuery();
                    while(result.next()){
                        typeAlimentation.add(result.getString("TypeAlimentation"));
                    }
                }
	return typeAlimentation;
	}
        
        //méthode pour crypter le mot de passe
        public static String encryptPasswordMD5(String password) throws NoSuchAlgorithmException{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte [] passwordByte =  password.getBytes();
            md.reset();
            byte[] digested = md.digest(passwordByte);
            StringBuffer sb = new StringBuffer();
            for(int i=0 ; i<digested.length ; i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        }
}