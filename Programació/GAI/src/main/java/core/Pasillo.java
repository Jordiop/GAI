








package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Pasillo
 */
@WebServlet("/Pasillo")
public class Pasillo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pasillo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addHeader("Access-Control-Allow-Origin", "*");
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
			String pasillo1 = request.getParameter("pasillo");
			int pasillo = Integer.parseInt(pasillo1);
			System.out.println(pasillo);
			comprobador = Bbdd.comprobarUsuario(usuari);
			if (comprobador == true) {
				resultat = Bbdd.mostrarPasillo(pasillo);
			} 
			if (comprobador == false) {
				System.out.println("No ets un treballador de GAI");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultat);
		
	}

}
