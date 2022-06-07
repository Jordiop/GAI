package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteEstanteria
 */
@WebServlet("/DeleteEstanteria")
public class DeleteEstanteria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEstanteria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.addHeader("Access-Control-Allow-Origin", "*");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String usuari = request.getParameter("usuario");
			String pasillo1 = request.getParameter("pasillo");
			String almacen1 = request.getParameter("almacen");
			String estanteria1 = request.getParameter("estanteria");
			
			int pasillo = Integer.parseInt(pasillo1);
			int almacen = Integer.parseInt(almacen1);
			int estanteria = Integer.parseInt(estanteria1);
			
			boolean comprobant = false;
			comprobant = Bbdd.comprobarUsuario(usuari);
			
			if (comprobant == true) {
				Bbdd.deleteEstanteria(almacen, pasillo, estanteria);
				System.out.println("Usuario "+usuari+" está eliminando una estanteria");
			} else {
				System.out.println("Usuari no trobat");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		doGet(request, response);
	}

}
