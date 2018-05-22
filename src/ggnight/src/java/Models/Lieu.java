/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class Lieu {
       private String nom,adresse,placeId;
       private double rating;
       public Lieu(){
           
       }
       public Lieu(String nom,String adresse,String placeId,double rating){
           this.nom=nom;
           this.adresse=adresse;
           this.placeId=placeId;
           this.rating=rating;
       }
       
       public Lieu(String nom,String adresse){
           this.nom=nom;
           this.adresse=adresse;
       }
       
       public Lieu(String nom,String adresse,String placeId){
           this.nom=nom;
           this.adresse=adresse;
           this.placeId=placeId;
       }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the placeId
     */
    public String getPlaceId() {
        return placeId;
    }

    /**
     * @param placeId the placeId to set
     */
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(double rating) {
        this.rating = rating;
    }       
}
