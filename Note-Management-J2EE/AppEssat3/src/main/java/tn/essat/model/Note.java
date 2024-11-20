package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity


public class Note {
	

	@Id @GeneratedValue(strategy= GenerationType.IDENTITY) 
private int id;
	private float nt;
	@ManyToOne
	@JoinColumn(name="etd_id")
	private Etudiant etd;
	@ManyToOne
	@JoinColumn(name="mt_id")
    //liste one to many
	//type champs many to one =bidirectionnel
	private Matiere mt;
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Note(int id, float nt, Etudiant etd, Matiere mt) {
		super();
		this.id = id;
		this.nt = nt;
		this.etd = etd;
		this.mt = mt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getNt() {
		return nt;
	}
	public void setNt(float nt) {
		this.nt = nt;
	}
	public Etudiant getEtd() {
		return etd;
	}
	public void setEtd(Etudiant etd) {
		this.etd = etd;
	}
	public Matiere getMt() {
		return mt;
	}
	public void setMt(Matiere mt) {
		this.mt = mt;
	}
	

}
