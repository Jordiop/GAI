package core;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletePasillo
 */
@WebServlet("/deletePasillo")
public class DeletePasillo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePasillo() {
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
			try {
				String usuari = request.getParameter("usuario");
				String pasillo1 = request.getParameter("pasillo");
				String almacen1 = request.getParameter("almacen");
				
				boolean comprobador = false;
				
				int pasillo = Integer.parseInt(pasillo1);
				int almacen = Integer.parseInt(almacen1);
				
				comprobador = Bbdd.comprobarUsuario(usuari);
				if (comprobador == true) {
					Bbdd.deletePasillo(almacen, pasillo);
				} else { 
					System.out.println("No tienes permisos");
					}
			} catch (Exception e) {
				System.out.println(e);
			}
			response.addHeader("Access-Control-Allow-Origin", "*");
		}
}


