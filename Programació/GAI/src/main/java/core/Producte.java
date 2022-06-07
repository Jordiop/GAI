package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Producte
 */
@WebServlet("/Producte")
public class Producte extends HttpServlet {
	public static int idProducto = 1	;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		idProducto = idProducto + 1;
		int a = idProducto;
		try {
			String usuari = request.getParameter("usuario");
			String quantity = request.getParameter("pquantity");
			String anchura = request.getParameter("x");
			String altura = request.getParameter("y");
			String estanteria = request.getParameter("pestanteria");
			String pasillo = request.getParameter("ppasillo");
			boolean comprobador = false;
			System.out.println(usuari);
			int q2 = Integer.parseInt(quantity);
			int x = Integer.parseInt(anchura);
			int y = Integer.parseInt(altura);
			int est = Integer.parseInt(estanteria);
			int pas = Integer.parseInt(pasillo);
			comprobador = Bbdd.comprobarUsuario(usuari);
			if (comprobador == true) {
				Bbdd.addProduct(a,request.getParameter("pname"),request.getParameter("pdescription"),q2,x,y,est,pas);
			}
			if (comprobador == false) {
				System.out.println("No se ha encontrado el usuario en la BBDD");
			}
		} catch (Exception e){
			System.out.println(e);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		// doGet(request, response);
	}

}
