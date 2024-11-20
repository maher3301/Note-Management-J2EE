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
import tn.essat.model.Matiere;
import tn.essat.model.Note;
import tn.essat.model.User;

/**
 * Servlet implementation class PostAjout
 */
public class PostAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAjout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User u=(User) session.getAttribute("utilisateur"); //get ou set // recupuere ou modfifier
		
		if (u==null) {
			//utilisateur nexiste pas
	         request.getRequestDispatcher("connexion.jsp").forward(request, response);
		}
		// TODO Auto-generated method stub
int idmat=Integer.parseInt(request.getParameter("mat"));
int idetd=Integer.parseInt(request.getParameter("etd"));
float note=Float.parseFloat(request.getParameter("note"));
IGestion dao=new GestionImp();
Etudiant et=dao.getEtudiantById(idetd);
Matiere mt=dao.getMatiereById(idmat);

dao.addNote(new Note(1,note,et,mt));
request.getRequestDispatcher("PreNote?id="+idetd).forward(request, response);



	}

}
