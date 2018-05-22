/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class Soiree extends Lieu{
    
    private int idOrganisateur,idLieu,idSoiree;
    private String date,dHeure,fHeure,Organisateur;
    public Soiree(){
        
    }
    public Soiree(int idOrganisateur,int idLieu,String date,String dHeure,String fHeure){
        this.idOrganisateur = idOrganisateur;
        this.idLieu=idLieu;
        this.date=date;
        this.dHeure=dHeure;
        this.fHeure=fHeure;
    }
    public Soiree(String nom,String adresse,String placeId,String date,String dHeure,String fHeure,int idLieu,int idOrganisateur,int idSoiree){
        super(nom, adresse, placeId);
        this.date = date;
        this.dHeure=dHeure;
        this.fHeure=fHeure;
        this.idLieu=idLieu;
        this.idOrganisateur=idOrganisateur;
        this.idSoiree = idSoiree;
    }
    
    public Soiree(String Organisateur,String date,String dHeure,String fHeure,String nom,String adresse){
        super(nom,adresse);
        this.Organisateur=Organisateur;
        this.date=date;
        this.dHeure=dHeure;
        this.fHeure=fHeure;
    }
    /**
     * @return the idOrganisateur
     */
    public int getIdOrganisateur() {
        return idOrganisateur;
    }

    /**
     * @param idOrganisateur the idOrganisateur to set
     */
    public void setIdOrganisateur(int idOrganisateur) {
        this.idOrganisateur = idOrganisateur;
    }

    /**
     * @return the idLieu
     */
    public int getIdLieu() {
        return idLieu;
    }

    /**
     * @param idLieu the idLieu to set
     */
    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the dHeure
     */
    public String getdHeure() {
        return dHeure;
    }

    /**
     * @param dHeure the dHeure to set
     */
    public void setdHeure(String dHeure) {
        this.dHeure = dHeure;
    }

    /**
     * @return the fHeure
     */
    public String getfHeure() {
        return fHeure;
    }

    /**
     * @param fHeure the fHeure to set
     */
    public void setfHeure(String fHeure) {
        this.fHeure = fHeure;
    }

    /**
     * @return the idSoiree
     */
    public int getIdSoiree() {
        return idSoiree;
    }

    /**
     * @param idSoiree the idSoiree to set
     */
    public void setIdSoiree(int idSoiree) {
        this.idSoiree = idSoiree;
    }

    /**
     * @return the Organisateur
     */
    public String getOrganisateur() {
        return Organisateur;
    }

    /**
     * @param Organisateur the Organisateur to set
     */
    public void setOrganisateur(String Organisateur) {
        this.Organisateur = Organisateur;
    }
    
    
}
