package Functions;

import Models.Soiree;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotificationFunction {
	
	//m�thode pour r�cup�rer les notifications non_vue (AMI seulement)
	public static int getNotSeenFriendRequest(int idUser) throws SQLException{
		String sql = "SELECT idUtilisateur FROM amis WHERE idAmi = ? AND etatEnvoi = 1 AND notiVue = 0";
		int returnCount = 0;
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(sql);
		stat.setInt(1,idUser);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			returnCount++;
		}
		return returnCount;
	}
	
        //méthode pour récupérer les notifications non_vue (soiree)
        public static int getNotSeenEventSend(int idUser) throws SQLException{
            int returnCount = 0;
            String sql ="SELECT * FROM invite WHERE idAmi = ? AND etatEnvoi = 1 AND notiVue = 1";
            Connection cnx = DBConnect.ConnectDB();
	    PreparedStatement stat = cnx.prepareStatement(sql);
	    stat.setInt(1,idUser);
	    ResultSet result = stat.executeQuery();
            while(result.next()){
                returnCount++;
	    }
	    return returnCount;
        }
        
        //méthode pour afficher les soirées non_vue_détails (soiree)
        public static ArrayList<Soiree> showNotSeenNoti(int idUser) throws SQLException{
            int idOrganisateur = 0;
            int idSoiree = 0;
            ArrayList<Soiree> inviteSoiree = new ArrayList<Soiree>();
            String sql ="SELECT * FROM invite WHERE idAmi = ? AND etatEnvoi = 1 AND notiVue = 1";
            String sqlSoiree = "SELECT * FROM soiree WHERE idSoiree = ?";
            String sqlLieu = "SELECT * FROM lieu WHERE idLieu = ?";
            Connection cnx = DBConnect.ConnectDB();
	    PreparedStatement stat = cnx.prepareStatement(sql);
	    stat.setInt(1,idUser);
	    ResultSet result = stat.executeQuery();
            while(result.next()){
                idOrganisateur = result.getInt("idOrganisateur");
                idSoiree = result.getInt("idSoiree");
                PreparedStatement stat1 = cnx.prepareStatement(sqlSoiree);
                stat1.setInt(1,idSoiree);
                ResultSet resultSoiree = stat1.executeQuery();
                while(resultSoiree.next()){
                    int idLieu = resultSoiree.getInt("idLieu");
                    String name = UserFunctions.getInfoUserFromId(idOrganisateur).getNom();
                    String lname = UserFunctions.getInfoUserFromId(idOrganisateur).getPrenom();
                    String NOM = name+" "+lname;
                    String DATE = resultSoiree.getString("date");
                    String DHEURE = resultSoiree.getString("dHeure");
                    String FHEURE = resultSoiree.getString("fHeure");
                    PreparedStatement stat2 = cnx.prepareStatement(sqlLieu);
                    stat2.setInt(1,idLieu);
                    ResultSet resultPlace = stat2.executeQuery();
                    while(resultPlace.next()){
                        String NOM_LIEU = resultPlace.getString("nom");
                        String ADRESSE = resultPlace.getString("adresse");
                        Soiree sInvite = new Soiree(NOM,DATE,DHEURE,FHEURE,NOM_LIEU,ADRESSE);
                        inviteSoiree.add(sInvite);
                    }
                    
                }
	    }
	    return inviteSoiree;
        }
	
}
