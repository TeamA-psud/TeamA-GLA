package Models;

import java.util.ArrayList;
import java.sql.Date;

public class Utilisateur {
	private String nom,prenom,adresse,email,password,sex,transport;
	private int age,phone,id;
	private double budget;
	private String date;
	private ArrayList<Integer> idAlimPref;
	public Utilisateur(String nom,String prenom,String adresse,String email,String password,String sex,
							String transport,int age,int phone,double budget,String date,ArrayList<Integer> idAlimPref){
		this.nom=nom;
		this.prenom = prenom;
		this.adresse=adresse;
		this.email=email;
		this.password=password;
		this.sex=sex;
		this.transport=transport;
		this.age=age;
		this.phone =phone;
		this.budget=budget;
		this.date=date;
		this.idAlimPref = idAlimPref;
	}
        public Utilisateur(String nom){
            this.nom=nom;
        }
	public Utilisateur(String nom,String prenom,String email){
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
	}
	public Utilisateur(String nom,String prenom,int age,String adresse,String date,int phone,String sex,String transport, double budget){
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.adresse=adresse;
		this.date=date;
		this.phone=phone;
		this.sex=sex;
		this.transport=transport;
		this.budget=budget;
	}
	public Utilisateur(String nom,String prenom,int age,String adresse,int id){
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.adresse=adresse;
		this.id=id;
	}
	public Utilisateur(String nom,String prenom,int age,String adresse,int id,String transport,String date){
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.adresse=adresse;
		this.id=id;
		this.transport=transport;
                this.date=date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Integer> getIdAlimPref() {
		return idAlimPref;
	}

	public void setIdAlimPref(ArrayList<Integer> idAlimPref) {
		this.idAlimPref = idAlimPref;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
