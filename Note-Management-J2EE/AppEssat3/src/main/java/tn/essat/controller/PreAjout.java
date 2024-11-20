package tn.essat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Etudiant;
import tn.essat.model.Matiere;
import tn.essat.model.Note;
import tn.essat.model.User;

/**
 * Servlet implementation class PreAjout
 */
public class PreAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreAjout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession();
		User u=(User) session.getAttribute("utilisateur"); //get ou set // recupuere ou modfifier
		
		if (u==null) {
			//utilisateur nexiste pas
	         request.getRequestDispatcher("connexion.jsp").forward(request, response);
		}

		IGestion dao=new GestionImp();
		List<Etudiant>  etd=dao.getALLEtudiant();
		
		List<Matiere> liste =dao.getAllMatiere();
		request.setAttribute("etd", etd);
		request.setAttribute("mats", liste);
		request.getRequestDispatcher("ajout.jsp").forward(request, response);

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
