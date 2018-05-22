/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Lieu;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LieuFunction {
   
    //méthode pour ajouter un lieu a la BD
    public static int AjouterLieu(Lieu lieu) throws SQLException{
        long id = 0;
        String sql = "INSERT INTO lieu(nom,adresse,placeId,rating)VALUES(?,?,?,?)";
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        stat.setString(1,lieu.getNom());
        stat.setString(2,lieu.getAdresse());
        stat.setString(3,lieu.getPlaceId());
        stat.setDouble(4,lieu.getRating());
        int executeQuery = stat.executeUpdate();
        if(executeQuery <= 0){
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
    
    //méthode pour supprimer un lieu 
    public static boolean deletePlace(int idLieu) throws SQLException{
        String sql = "DELETE FROM lieu WHERE idLieu = ?";
        Connection cnx = DBConnect.ConnectDB();
        PreparedStatement stat = cnx.prepareStatement(sql);
        stat.setInt(1,idLieu);
        int executeQuery = stat.executeUpdate();
        if(executeQuery <= 0){
            return false;
        }else{
            return true;
        }
    }
}
