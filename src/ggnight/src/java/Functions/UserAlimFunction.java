package Functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Alimentation;
import Models.UserAlim;

public class UserAlimFunction {
	
	//méthode pour relier les préférences alimentaire au utilisateur
	public static void relationUserAlim(UserAlim userAlim) throws SQLException{
		String sql = "INSERT INTO useralim(idUtilisateur,idPrefAlim)VALUES(?,?)";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setInt(1,userAlim.getIdUser());
		stat.setInt(2,userAlim.getIdAlimentation());
		stat.executeUpdate();
	}
	
	//méthode pour récupérer les alimentations choisis par l'utilisateur
	public static ArrayList<Alimentation> myPreferenceAlimentation(int idUser) throws SQLException{
		ArrayList<Alimentation> myAlimentation = new ArrayList<Alimentation>();
		String sql = "SELECT idPrefAlim,TypeAlimentation FROM useralim JOIN alimentation WHERE useralim.idPrefAlim = alimentation.idAlimentation AND useralim.idUtilisateur = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setInt(1,idUser);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			int ID_ALIMENTATION = result.getInt("idPrefAlim");
			String TYPE_ALIMENTATION = result.getString("TypeAlimentation");
			myAlimentation.add(new Alimentation(ID_ALIMENTATION, TYPE_ALIMENTATION));
		}
		return myAlimentation;
	}
}
