package Functions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.UserAlim;
import Models.Utilisateur;

public class UserFunctions {

	//méthode pour inscrir un utilisateur
	public static boolean Inscription(Utilisateur user) throws SQLException{
		String sql = "INSERT INTO utilisateur(Nom,Prenom,Age,Adresse,DateNaiss,Phone,Email,Password,Sex,MoyTrans,Budget)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stat.setString(1,user.getNom());
		stat.setString(2,user.getPassword());
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
	
	//méthode pour l'authentification 
	
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
	
	//méthode pour récupérer les informations de l'utilisateur
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
	//méthode pour modifier les informations perso
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
	//méthode pour modifier le mot de passe
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
}
