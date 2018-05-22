/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Soiree;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SoireeFunction {
  
    //méthode pour ajouter une soirée
    public static int AjouterSoiree(Soiree soiree) throws SQLException{
        long id=0;
        String sql = "INSERT INTO soiree(idOrganisateur,idLieu,date,dHeure,fHeure)VALUES(?,?,?,?,?)";
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        stat.setInt(1,soiree.getIdOrganisateur());
        stat.setInt(2,soiree.getIdLieu());
        stat.setString(3,soiree.getDate());
        stat.setString(4,soiree.getdHeure());
        stat.setString(5,soiree.getfHeure());
        int executeQuery = stat.executeUpdate();
        if(executeQuery <= -1){
            return -1;
        }else{
            ResultSet result = stat.getGeneratedKeys();
            if(result.next()){
                id = result.getLong(1);
            }
        }
        int ID = Integer.parseInt(String.valueOf(id));
        return ID;
    }
    
    //méthode pour afficher tous les soirées organisées
    public static ArrayList<Soiree> ListSoiree(int idUser) throws SQLException{
        String sql = "SELECT * FROM lieu JOIN soiree WHERE lieu.idLieu = soiree.idLieu AND soiree.idOrganisateur = ?";
        ArrayList<Soiree> allSoiree = new ArrayList<Soiree>();
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idUser);
        ResultSet result = stat.executeQuery();
        while(result.next()){
            String NOM = result.getString("nom");
            String ADRESSE = result.getString("adresse");
            String PLACEID = result.getString("placeId");
            String DATE = result.getString("date");
            String DHEURE = result.getString("dHeure");
            String FHEURE = result.getString("fHeure");
            int ID_LIEU = result.getInt("idLieu");
            int ID_ORGANISATEUR = result.getInt("idOrganisateur");
            int ID_SOIREE = result.getInt("idSoiree");
            Soiree soiree = new Soiree(NOM, ADRESSE, PLACEID, DATE, DHEURE, FHEURE,ID_LIEU,ID_ORGANISATEUR,ID_SOIREE);
            allSoiree.add(soiree);
        }
        return allSoiree;
    }
    
    //méthode pour afficher les soirées validées
    public static ArrayList<Soiree> ListSoireeConfirme(int idUser) throws SQLException{
        String sql = "SELECT * FROM lieu JOIN soiree JOIN invite WHERE lieu.idLieu = soiree.idLieu AND invite.idSoiree = soiree.idSoiree AND invite.etatEnvoi = 2 AND invite.idAmi = ?";
        ArrayList<Soiree> allSoiree = new ArrayList<Soiree>();
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idUser);
        ResultSet result = stat.executeQuery();
        while(result.next()){
            String NOM = result.getString("nom");
            String ADRESSE = result.getString("adresse");
            String PLACEID = result.getString("placeId");
            String DATE = result.getString("date");
            String DHEURE = result.getString("dHeure");
            String FHEURE = result.getString("fHeure");
            int ID_LIEU = result.getInt("idLieu");
            int ID_ORGANISATEUR = result.getInt("idOrganisateur");
            int ID_SOIREE = result.getInt("idSoiree");
            Soiree soiree = new Soiree(NOM, ADRESSE, PLACEID, DATE, DHEURE, FHEURE,ID_LIEU,ID_ORGANISATEUR,ID_SOIREE);
            allSoiree.add(soiree);
        }
        return allSoiree;
    }
    
    //méthde pour supprimer une soirée
    public static boolean deleteSoiree(int idSoiree) throws SQLException{
        String sql = "DELETE FROM soiree WHERE idSoiree = ?";
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idSoiree);
        int executeQuery = stat.executeUpdate();
        if(executeQuery <= 0){
            return false;
        }else{
            return true;
        }
    }
    
}
