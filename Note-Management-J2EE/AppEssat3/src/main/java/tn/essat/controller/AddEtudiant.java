package tn.essat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Etudiant;
import tn.essat.model.User;

/**
 * Servlet implementation class AddEtudiant
 */
public class AddEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.getRequestDispatcher("addEtudiant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   HttpSession session = request.getSession();
	        User user = (User) session.getAttribute("utilisateur");

	        if (user == null) {
	            // If the user is not authenticated, redirect to the login page
	            request.getRequestDispatcher("connexion.jsp").forward(request, response);
	            return;
	        }

	        int id = Integer.parseInt(request.getParameter("id"));
	        String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");

	        Etudiant etudiant = new Etudiant();
	        etudiant.setId(id);
	        etudiant.setNom(nom);
	        etudiant.setPrenom(prenom);

	        IGestion dao = new GestionImp();
	        dao.addEtudiant(etudiant);

	        // Redirect back to home.jsp to see the updated list of students
	        response.sendRedirect("home.jsp");
	    }
	

}
