package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class modProduct
 */
@WebServlet("/modProduct")
public class modProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modProduct() {
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
			String nom = request.getParameter("nombre");
			
			String identifier = request.getParameter("idProducto");
			String quantity = request.getParameter("cantidad");
			
			int cantidad = Integer.parseInt(quantity);
			int id = Integer.parseInt(identifier);
			
			
			boolean comprobante = false;
			
			comprobante = Bbdd.comprobarUsuario(usuari);
			
			if (comprobante == true) {
				Bbdd.modProduct(id, nom, cantidad);
				System.out.println(usuari + " está modificando el producto " + id);
			} else {
				System.out.println("No se te ha podido identificar");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
	}

}
