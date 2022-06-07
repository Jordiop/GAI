package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Usuari
@WebServlet("/registreTreballador")
public class RegistreTreballador extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistreTreballador() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // DoGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addHeader("Access-Control-Allow-Origin", "*");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// DoPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String usuari = request.getParameter("usuario");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String almacen1 = request.getParameter("almacen");
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String rango = request.getParameter("rango");
			
			int almacen = Integer.parseInt(almacen1);
			
			boolean comprobant = false;
			comprobant = Bbdd.comprobarUsuario(usuari);
			if (comprobant == true) {
				Bbdd.registroUsuari(almacen, username, password, nombre, apellidos, rango);
			} else {
				System.out.println("No se te ha podido identificar");
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error al registrar");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
	}

}
