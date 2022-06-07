package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addPasillo
 */
@WebServlet("/addPasillo")
public class AddPasillo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPasillo() {
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
			String numero1 = request.getParameter("numero");
			String almacen1 = request.getParameter("almacen");
			int almacen = Integer.parseInt(almacen1);
			int numero = Integer.parseInt(numero1);
			boolean comprobador = false;
			comprobador = Bbdd.comprobarUsuario(usuari);
			if (comprobador == true) {
				Bbdd.addPasillo(almacen, numero);
				System.out.println(usuari+" estáñadiendo un pasillo");
			} else { 
				System.out.println("No tienes permisos");
				}
		} catch (Exception e) {
			System.out.println(e);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
	}

}
