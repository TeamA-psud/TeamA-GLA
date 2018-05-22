/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InviteFunction {
    
    //méthode pour envoi la notification aux invités
    public static boolean SendNotificationEvent(ArrayList<Integer> idPersons,int idSoiree) throws SQLException{
        String sql ="INSERT INTO invite(idOrganisateur,idAmi,idSoiree,etatEnvoi,notiVue)VALUES(?,?,?,?,?)";
        boolean testInsert = false;
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idPersons.get(0));
        stat.setInt(3,idSoiree);
        stat.setInt(4,1);
        stat.setInt(5,1);
        for(int i=1 ; i<idPersons.size() ; i++){
            stat.setInt(2,idPersons.get(i));
            int executeQuery = stat.executeUpdate();
            if(executeQuery <= 0){
                testInsert = false;
                break;
            }else{
                testInsert = true;
            }
        }
        return testInsert;
    }
    
    public static boolean deleteInvitation(int idOrganisateur) throws SQLException{
        String sql = "DELETE FROM invite WHERE idOrganisateur = ?";
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idOrganisateur);
        int executeQuery = stat.executeUpdate();
        if(executeQuery <= 0){
            return false;
        }else{
            return true;
        }
    }
    
    //méthode pour confirmer un evenement
    public static boolean confirmeEvent(int idAmi) throws SQLException{
        String sql = "UPDATE invite SET etatEnvoi = 2 WHERE idAmi = ? ";
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idAmi);
        int executeQuery = stat.executeUpdate();
        if(executeQuery <= 0){
            return false;
        }else{
            return true;
        }
    }
    
    //méthode pour refuser un evenement
    public static boolean rejectEvent(int idAmi) throws SQLException{
        String sql = "UPDATE invite SET etatEnvoi = 0 WHERE idAmi = ? ";
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idAmi);
        int executeQuery = stat.executeUpdate();
        if(executeQuery <= 0){
            return false;
        }else{
            return true;
        }
    }
}
