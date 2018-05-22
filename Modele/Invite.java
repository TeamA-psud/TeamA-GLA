/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class Invite {
   
    private int idOrganisateur,idAmi,idSoiree,etatEnvoi,notiVue;
    
    public Invite(int idOrganisateur,int idAmi,int idSoiree,int etatEnvoi,int notiVue){
        this.idOrganisateur=idOrganisateur;
        this.idAmi=idAmi;
        this.idSoiree=idSoiree;
        this.etatEnvoi=etatEnvoi;
        this.notiVue=notiVue;
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
     * @return the idAmi
     */
    public int getIdAmi() {
        return idAmi;
    }

    /**
     * @param idAmi the idAmi to set
     */
    public void setIdAmi(int idAmi) {
        this.idAmi = idAmi;
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
     * @return the etatEnvoi
     */
    public int getEtatEnvoi() {
        return etatEnvoi;
    }

    /**
     * @param etatEnvoi the etatEnvoi to set
     */
    public void setEtatEnvoi(int etatEnvoi) {
        this.etatEnvoi = etatEnvoi;
    }

    /**
     * @return the notiVue
     */
    public int getNotiVue() {
        return notiVue;
    }

    /**
     * @param notiVue the notiVue to set
     */
    public void setNotiVue(int notiVue) {
        this.notiVue = notiVue;
    }
    
}
