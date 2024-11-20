package tn.essat.dao;

import java.util.List;

import tn.essat.model.Etudiant;
import tn.essat.model.Matiere;
import tn.essat.model.Note;
import tn.essat.model.User;

public interface IGestion {
    public List<Matiere> getAllMatiere();
    public void addMatiere(Matiere m);
    public void deleteMatiere(int id);
    public Matiere getMatiereById(int id);

    public List<Etudiant> getALLEtudiant();
    public void addEtudiant(Etudiant etudiant);
    public void addNote(Note n);
    public List<Note> getALLNoteById(int etd_id);
    public Etudiant getEtudiantById(int id);
    public void deleteEtudiant(int id);

    public User verifUser(String login, String password);
    public void addUser(User user);
}
