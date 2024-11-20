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
import tn.essat.model.Note;
import tn.essat.model.User;

/**
 * Servlet implementation class PreNote
 */
public class PreNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreNote() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		Etudiant  etd=dao.getEtudiantById(id);
		List<Note> liste =dao.getALLNoteById(id);
		request.setAttribute("etd", etd);
		request.setAttribute("liste", liste);
		request.getRequestDispatcher("notes.jsp").forward(request, response);

	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
