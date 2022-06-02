package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ClientLogin
 */
@WebServlet("/ClientLogin")
public class ClientLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String resultat="";
				try {
					String usuario = request.getParameter("usuario");
					String password = request.getParameter("password");
					System.out.println(usuario);
					System.out.println(password);
					resultat = Bbdd.iniciClient(usuario, password);
					if (resultat != "") {
						HttpSession misession = request.getSession(true);
						
						Usuario miusuario = new Usuario(usuario, password);
						misession.setAttribute("Usuario", miusuario);
						
						PrintWriter pw = response.getWriter().append(miusuario.getNombre());
						pw.close();
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				response.addHeader("Access-Control-Allow-Origin", "*");
			}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
