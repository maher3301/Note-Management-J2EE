package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Etudiant {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY) 

   private int id ;
   private String nom;
   private String prenom ;
public Etudiant() {
	super();
	// TODO Auto-generated constructor stub
}
public Etudiant(int id, String nom, String prenom) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
   
   
}
