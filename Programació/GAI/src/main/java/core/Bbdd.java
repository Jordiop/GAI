package core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Bbdd {
	public static int contadorEstanterias = 0;
	public static int idTreballadorNum = 2;
	public static int idClientNum = 2;
	public static int idPasilloNum = 3;
	// Part logística / administrativa
	// Pasillos
	// Funcionant
	public static void addPasillo (int almacen, int numero) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		idPasilloNum = idPasilloNum + 1;
		int a = idPasilloNum;
		
		String query = "INSERT INTO pasillos VALUES ("+a+","+almacen+","+numero+")";
		st.executeUpdate(query);
		
		st.close();
	}
	// Funcionant
	public static void deletePasillo (int almacen, int pasillo) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		
		Statement st = con.createStatement();
		String query = "DELETE FROM pasillos WHERE idPasillo = '"+pasillo+"' AND idAlmacen = '"+almacen+"'";
		st.executeUpdate(query);
		st.close();
		con.close();
	}
	
	// Estanteries
	// Hauria de funcionar
	public static void addEstanteria (int almacen, int pasillo, int altura, int anchura) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		contadorEstanterias = contadorEstanterias + 1;
		int a = contadorEstanterias;
		String query = "INSERT INTO estanterias VALUES ('"+a+"', '"+almacen+"', '"+pasillo+"', '"+altura+"','"+anchura+"')";
		st.executeUpdate(query);
		st.close();
		con.close();
	}
	
	public static void deleteEstanteria (int almacen, int pasillo, int estanteria) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		String query = "DELETE FROM estanterias WHERE idAlmacen = '"+almacen+"' and idPasillo = '"+pasillo+"' and idEstanteria = '"+estanteria+"'";
		st.executeUpdate(query);
		st.close();
		con.close();
	}
	
	// Productes
	// Funcionant
 	public static void addProduct (int idProducto,String pname, String pdescription, int pquantity, int positionx, int positiony, int pestanteria, int ppasillo) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		
		String query = "INSERT INTO productos VALUES ('"+idProducto+"','"+pestanteria+"','"+ppasillo+"','"+pname+"','"+pquantity+"','"+pdescription+"','"+positionx+"','"+positiony+"')";
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	// Funcionant
	public static void removeProduct(int pasillo, int estanteria, int producto) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		
		Statement st = con.createStatement();
		String query = "DELETE FROM productos WHERE idPasillo = "+pasillo+" and idEstanteria = "+estanteria+" and idProducto = "+producto+"";
		st.executeUpdate(query);
		st.close();
		con.close();
	}
	
	public static void modProduct (int id, String nombre, int cantidad) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		
		Statement st = con.createStatement();
		String query = "UPDATE productos SET nom = '"+nombre+"', quantitat = '"+cantidad+"' WHERE idProducto = '"+id+"'";
		st.executeUpdate(query);
		st.close();
		con.close();
	}
	
	// Buscadores
	// Funcionant
	public static String mostrarPasillo (int pasillo) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		
		// Query amb es número de pasillo previament demanat per JS
		String query = "SELECT * FROM productos WHERE idPasillo = "+pasillo+"";
		ResultSet rs = st.executeQuery(query);
		
		// Imprimir tabla estil Miquel 
		String resultat = "<table border=\"1\">"
				+ "<tr>"
				+ "<th>idProducto</th>"
				+ "<th>idEstanteria</th>"
				+ "<th>idPasillo</th>"
				+ "<th>nom</th>"
				+ "<th>quantitat</th>"
				+ "<th>descripcio</th>"
				+ "<th>coordenadaX</th>"
				+ "<th>coordenadaY</th>"
				+ "</tr>";
		
		while (rs.next()) {
			resultat = resultat 
						+"<tr>"
						+ "<td>"+rs.getString("idProducto")+"</td>"
						+ "<td>"+rs.getString("idEstanteria")+"</td>"
						+ "<td>"+rs.getString("idPasillo")+"</td>"
						+ "<td>"+rs.getString("nom")+"</td>"
						+ "<td>"+rs.getString("quantitat")+"</td>"
						+ "<td>"+rs.getString("descripcio")+"</td>"
						+ "<td>"+rs.getString("coordenadaX")+"</td>"
						+ "<td>"+rs.getString("coordenadaY")+"</td>"
						+"</tr>";
		}
		resultat=resultat+"</table>";
		return resultat;
	}
	// Funcionant
	public static String mostrarEstanteria (int pasillo, int estanteria) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		
		// Query amb es número de estanteria a un pasillo en concret previament demanat per JS
		String query = "SELECT * FROM productos WHERE idPasillo = "+pasillo+" and idEstanteria = "+estanteria+"";
		ResultSet rs = st.executeQuery(query);
		
		// Imprimir tabla estil Miquel 
		String resultat = "<table border=\"1\">"
								+ "<tr>"
								+ "<th>idProducto</th>"
								+ "<th>idEstanteria</th>"
								+ "<th>idPasillo</th>"
								+ "<th>nom</th>"
								+ "<th>quantitat</th>"
								+ "<th>descripcio</th>"
								+ "<th>coordenadaX</th>"
								+ "<th>coordenadaY</th>"
								+ "</tr>";
		
		while (rs.next()) {
			resultat = resultat 
								+"<tr>"
								+ "<td>"+rs.getString("idProducto")+"</td>"
								+ "<td>"+rs.getString("idEstanteria")+"</td>"
								+ "<td>"+rs.getString("idPasillo")+"</td>"
								+ "<td>"+rs.getString("nom")+"</td>"
								+ "<td>"+rs.getString("quantitat")+"</td>"
								+ "<td>"+rs.getString("descripcio")+"</td>"
								+ "<td>"+rs.getString("coordenadaX")+"</td>"
								+ "<td>"+rs.getString("coordenadaY")+"</td>"
								+"</tr>";
		}
		resultat=resultat+"</table>";
		return resultat;
	}
	// Funcionant
	public static String buscarProducto (String nom) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		
		// Query amb es nom que dessitjam cercar.
		String query = "SELECT * FROM productos WHERE lower(nom) like '%"+nom+"%'";
		ResultSet rs = st.executeQuery(query);
		
		// Imprimir tabla estil Miquel 
		String resultat = "<table border=\"1\">"
				+ "<tr>"
				+ "<th>idProducto</th>"
				+ "<th>idEstanteria</th>"
				+ "<th>idPasillo</th>"
				+ "<th>nom</th>"
				+ "<th>quantitat</th>"
				+ "<th>descripcio</th>"
				+ "<th>coordenadaX</th>"
				+ "<th>coordenadaY</th>"
				+ "</tr>";
		
		while (rs.next()) {
			resultat = resultat 
						+"<tr>"
						+ "<td>"+rs.getString("idProducto")+"</td>"
						+ "<td>"+rs.getString("idEstanteria")+"</td>"
						+ "<td>"+rs.getString("idPasillo")+"</td>"
						+ "<td>"+rs.getString("nom")+"</td>"
						+ "<td>"+rs.getString("quantitat")+"</td>"
						+ "<td>"+rs.getString("descripcio")+"</td>"
						+ "<td>"+rs.getString("coordenadaX")+"</td>"
						+ "<td>"+rs.getString("coordenadaY")+"</td>"
						+"</tr>";
		}
		resultat=resultat+"</table>";
		return resultat;
	}
	// Funcionant
	
	// Registre i inici sessió treballadors
	public static void registroUsuari (int idAlmacen, String username, String password, String nombre, String apellidos, String rango) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		
		idTreballadorNum = idTreballadorNum +1;
		int a = idTreballadorNum;
		
		String query = "INSERT INTO treballadors VALUES ('"+a+"','"+idAlmacen+"','"+username+"','"+password+"','"+nombre+"','"+apellidos+"','"+rango+"')";
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	public static String iniciarSesion (String usuari, String password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		
		String query = "SELECT username FROM treballadors WHERE username = '"+usuari+"' AND password = '"+password+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultat = "";
		
		while (rs.next()) {
			resultat = rs.getString("username");
		}
		
		st.close();
		con.close();
		return resultat;
	}
	
	// Part comunicativa
	
	public static void missatge (String nombre, String email, String missatge) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();

		String query = "INSERT INTO missatges values ("+nombre+","+email+","+missatge+")";
		st.executeQuery(query);
		
		st.close();
		con.close();
	}
	
	// Registre i inici sessió clients
	
	public static void registreClient (String usuari, String password, String nom, String cognoms, String DNI, String email) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		
		idClientNum = idClientNum + 1;
		
		String query = "INSERT INTO Clients VALUES ("+idClientNum+","+usuari+","+password+","+nom+","+cognoms+","+DNI+","+email+")";
		st.execute(query);
		
		st.close();
		con.close();
	}
	
	
	public static String iniciClient (String usuari, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		String resultat = "";
		
		String query = "SELECT Usuari FROM Clients WHERE Usuari = '"+usuari+"' AND Passwd = '"+password+"'";
		ResultSet rs = st.executeQuery(query);
		
		while (rs.next()) {
			resultat = rs.getString("Usuari");
		}
		
		st.close();
		con.close();
		return resultat;
	}

	// Mètodes de verificació
	
	public static boolean comprobarUsuario(String usuari) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/gai";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		boolean comprobant = false;
		
		String query = "SELECT username FROM treballadors WHERE username = '"+usuari+"'";
		ResultSet rs = st.executeQuery(query);
		String resultat = "";
		
		while (rs.next()) {
			resultat = rs.getString("username");
		}
		
		resultat = resultat.toLowerCase();
		usuari = usuari.toLowerCase();
		System.out.println(resultat);
		System.out.println(usuari);
		
		if (usuari.equals(resultat)) {
			comprobant = true;
		}
		
		st.close();
		con.close();
		return comprobant;
	}
}
