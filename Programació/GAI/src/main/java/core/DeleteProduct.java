package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteProduct
 */
@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addHeader("Access-Control-Allow-Origin", "*");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String usuari = request.getParameter("usuario");
			String estanteria = request.getParameter("estanteria");
			String pasillo = request.getParameter("pasillo");
			String producto = request.getParameter("producto");
			
			int est = Integer.parseInt(estanteria);
			int pas = Integer.parseInt(pasillo);
			int pro = Integer.parseInt(producto);
			
			boolean comprobador = false;
			
			System.out.println(usuari+" està realitzant un delete");
			comprobador = Bbdd.comprobarUsuario(usuari);
			if (comprobador == true) {
				Bbdd.removeProduct(pas, est, pro);
			} 
			if (comprobador == false) {
				System.out.println("No estàs identificat o no et trobam a la base de dades");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error al eliminar el producto");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
	}

}
