package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addEstanteria
 */
@WebServlet("/addEstanteria")
public class AddEstanteria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEstanteria() {
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
			String altura1 = request.getParameter("altura");
			String anchura1 = request.getParameter("anchura");
			boolean comprobador = false;
			
			int almacen = Integer.parseInt(almacen1);
			int pasillo = Integer.parseInt(pasillo1);
			int altura = Integer.parseInt(altura1);
			int anchura = Integer.parseInt(anchura1);
			comprobador = Bbdd.comprobarUsuario(usuari);
			
			if (comprobador == true) {
				Bbdd.addEstanteria(almacen, pasillo, altura, anchura);
				System.out.println(usuari+" está añadiendo un pasillo");
			} else { 
				System.out.println("No tienes permisos");
				}
			
		} catch (Exception e){
			
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
	}

}
