package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Estanteria
 */
@WebServlet("/Estanteria")
public class Estanteria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Estanteria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resultat = "";
		boolean comprobador = false;
		try {
			String usuari = request.getParameter("usuario");
			String estanteria1 = request.getParameter("estanteria");
			String pasillo1 = request.getParameter("pasillo");
			int est = Integer.parseInt(estanteria1);
			int pas = Integer.parseInt(pasillo1);
			System.out.println(usuari+" està mostrant la estanteria"+est+" del pasillo"+pas);
			comprobador = Bbdd.comprobarUsuario(usuari);
			
			if (comprobador == true) {
				resultat = Bbdd.mostrarEstanteria(est,pas);}
			else {
				System.out.println("No se t'ha pogut identificar");
			}
			} catch (Exception e) {
				System.out.println(e);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultat);
	}
}
