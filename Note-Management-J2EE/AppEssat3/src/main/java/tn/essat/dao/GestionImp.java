package tn.essat.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import tn.essat.model.Etudiant;
import tn.essat.model.Matiere;
import tn.essat.model.Note;
import tn.essat.model.User;

public class GestionImp implements IGestion {
    Session session;

    public GestionImp() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        session = sessionFactory.openSession();
    }

    public List<Matiere> getAllMatiere() {
        Query<Matiere> req = session.createQuery("select m from Matiere m");
        List<Matiere> liste = req.getResultList();
        return liste;
    }

    public void addMatiere(Matiere m) {
        session.getTransaction().begin();
        session.save(m);
        session.getTransaction().commit();
    }

    public void deleteMatiere(int id) {
        session.getTransaction().begin();
        Matiere m = session.load(Matiere.class, id);
        session.delete(m);
        session.getTransaction().commit();
    }

    public Matiere getMatiereById(int id) {
        return session.load(Matiere.class, id);
    }

    public List<Etudiant> getALLEtudiant() {
        Query<Etudiant> req = session.createQuery("select e from Etudiant e");
        List<Etudiant> liste = req.getResultList();
        return liste;
    }

    public void addEtudiant(Etudiant etudiant) {
        session.getTransaction().begin();
        session.save(etudiant);
        session.getTransaction().commit();
    }

    public void addUser(User user) {
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
    }

    public void addNote(Note n) {
        session.getTransaction().begin();
        session.save(n);
        session.getTransaction().commit();
    }

    public List<Note> getALLNoteById(int etd_id) {
        Query<Note> req = session.createQuery("select n from Note n where n.etd.id=?1");
        req.setParameter(1, etd_id);
        List<Note> liste = req.getResultList();
        return liste;
    }

    public Etudiant getEtudiantById(int id) {
        return session.load(Etudiant.class, id);
    }

    public User verifUser(String login, String password) {
        User u = null;
        try {
            Query<User> req = session.createQuery("select u from User u where u.login=?1 and u.password=?2");
            req.setParameter(1, login);
            req.setParameter(2, password);
            u = req.getSingleResult();
        } catch (NoResultException e) {
            u = null;
        }
        return u;
    }

	public void deleteEtudiant(int id) {
		 session.getTransaction().begin();
	        Etudiant t = session.load(Etudiant.class, id);
	        session.delete(t);
	        session.getTransaction().commit();		
	}
}
