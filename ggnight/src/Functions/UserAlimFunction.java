package Functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
