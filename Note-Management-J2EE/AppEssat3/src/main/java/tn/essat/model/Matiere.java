package tn.essat.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
@Entity
//@Table(name="Course"); table nommée dans la BD est course  sinon par defaut le nom de la classe
//@JoinColumn(name="title", nullable=true, unique=false ) //spécifier le non de colonne ici on a nommee le colonne titre : Title



public class Matiere {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY) 
	private int id ;
	private String titre;
	private int niveau;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Matiere(int id, String titre, int niveau) {
		super();
		this.id = id;
		this.titre = titre;
		this.niveau = niveau;
	}
	
	
	
	
	
	

}
