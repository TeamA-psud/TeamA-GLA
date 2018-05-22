package Functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatistiqueFunction {
    
    //méthode pour afficher le nombre des préférences gouts.
    public static int getPreferenceGoutNumber(int idUser) throws SQLException{
        int counter=0;
        String sql = "SELECT * FROM useralim WHERE idUtilisateur = ?";
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idUser);
        ResultSet result = stat.executeQuery();
        while(result.next()){
            counter++;
        }
        return counter;
    }
    
    //méthode pour afficher le nombre des amis
    public static int getFriendsNumber(int idUser) throws SQLException{
        int counter=0;
        String sql = "SELECT * FROM amis WHERE idUtilisateur = ?";
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idUser);
        ResultSet result = stat.executeQuery();
        while(result.next()){
            counter++;
        }
        return counter;
    }
    
    //méthode pour afficher les soirées organisées
    public static int getEventOrganised(int idUser) throws SQLException{
        int counter=0;
        String sql = "SELECT * FROM soiree WHERE idOrganisateur = ?";
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idUser);
        ResultSet result = stat.executeQuery();
        while(result.next()){
            counter++;
        }
        return counter;
    }
    
    //méthode pour afficher les amis invités
    public static int getFriendsInvited(int idUser) throws SQLException{
       int counter=0;
       String sql = "SELECT * FROM invite WHERE idOrganisateur = ?";
       Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idUser);
        ResultSet result = stat.executeQuery();
        while(result.next()){
            counter++;
        }
       return counter;
    }
}
