package core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Methods {
	ArrayList <String> comandos = null;
	// Mètode que recollirà els registres de usuaris realitzant canvis
	public static void guardarRegistros(String comando, ArrayList<String> comandos) {
		comandos.add(comando);
	}
	
	public static void verRegistros( List<String> comandos) {
		for (int i = 0; i < comandos.size(); i++) {
			System.out.println(comandos.get(i));
		}
	}
	
	public static void customSelect () throws ClassNotFoundException, SQLException {
		Scanner teclat = new Scanner (System.in);
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3326/GAI";
		Connection con = DriverManager.getConnection(url, "jordi", "8018");
		Statement st = con.createStatement();
		
		boolean rescate = true;
		
		while (rescate == true) {
		
		System.out.println("Bienvenido al selector de métodos en local");
		System.out.println("¿Qué deseas hacer?");
		System.out.println("0.  Salir");
		System.out.println("1.  Añadir almacén");
		System.out.println("2.  Añadir pasillo");
		System.out.println("3.  Eliminar pasillo");
		System.out.println("4.  Añadir estantería");
		System.out.println("5.  Eliminar estantería");
		System.out.println("6.  Añadir producto");
		System.out.println("7.  Eliminar producto");
		System.out.println("8.  Modificar producto");
		System.out.println("9.  Mostrar pasillo");
		System.out.println("10. Mostrar estantería");
		System.out.println("11. Buscar producto por nombre");
		System.out.println("12. Registro de usuario");
		System.out.println("13. Login");
		System.out.println("14. Ver tickets");
		System.out.println("15. Comprobar usuario");
		System.out.println("16. Modo experto");
		
		int election = teclat.nextInt();
		
		switch (election) {
		case 0:
			rescate = false;
			break;
		case 1:
			System.out.println("Añadir almacén");
			System.out.println("Dame el número de almacén");
			int id = teclat.nextInt();
			System.out.println("Dame el nombre");
			String nom = teclat.nextLine();
			System.out.println("Dame la localización");
			String localitzacio = teclat.nextLine();
			Bbdd.addAlmacen(id, nom, localitzacio);
			break;
		case 2:
			System.out.println("Añadir pasillo");
			System.out.println("Dame el almacen");
			int almacen = teclat.nextInt();
			System.out.println("Dame un número personalizado");
			int numeroPer = teclat.nextInt();
			Bbdd.addPasillo(almacen, numeroPer);
			break;
		case 3:
			System.out.println("Eliminar pasillo");
			System.out.println("Dame el almacen");
			int numAlmacen = teclat.nextInt();
			System.out.println("Dame el pasillo");
			int numPasillo = teclat.nextInt();
			Bbdd.deletePasillo(numAlmacen, numPasillo);
			break;
		case 4:
			System.out.println("Añadir estantería");
			System.out.println("Dame el almacen");
			int almacen4 = teclat.nextInt();
			System.out.println("Dame el pasillo");
			int pasillo4 = teclat.nextInt();
			System.out.println("Dame la altura de la estantería");
			int altura4 = teclat.nextInt();
			System.out.println("Dame la anchura de la estantería");
			int anchura4 = teclat.nextInt();
			Bbdd.addEstanteria(almacen4, pasillo4, altura4, anchura4);
			break;
		case 5:
			System.out.println("Eliminar estantería");
			System.out.println("Dame el almacen");
			int almacen5 = teclat.nextInt();
			System.out.println("Dame el pasillo");
			int pasillo5 = teclat.nextInt();
			System.out.println("Dame la estantería a eliminar");
			int estanteria5 = teclat.nextInt();
			Bbdd.deleteEstanteria(almacen5, pasillo5, estanteria5);
			break;
		case 6:
			System.out.println("Añadir producto");
			System.out.println("Dame el id");
			int id6 = teclat.nextInt();
			System.out.println("Dame el nombre");
			String nom6 = teclat.nextLine();
			System.out.println("Dame la descripción");
			String descripcion6 = teclat.nextLine();
			System.out.println("Dame la cantidad de producto");
			int quantity6 = teclat.nextInt();
			System.out.println("Dame la posicion X");
			int posicioX6 = teclat.nextInt();
			System.out.println("Dame la posicion Y");
			int posicionY6 = teclat.nextInt();
			System.out.println("Dame el pasillo");
			int pasillo6 = teclat.nextInt();
			System.out.println("Dame la estantería");
			int estanteria6 = teclat.nextInt();
			Bbdd.addProduct(id6, nom6, descripcion6, quantity6, posicioX6, posicionY6, estanteria6, pasillo6);
			break;
		case 7:
			System.out.println("Eliminar producto");
			System.out.println("Dame el pasillo");
			int pasillo7 = teclat.nextInt();
			System.out.println("Dame la estanteria");
			int estanteria7 = teclat.nextInt();
			System.out.println("Dame el ID del producto a eliminar (Este debe estar a 0 de stock)");
			int id7 = teclat.nextInt();
			Bbdd.removeProduct(pasillo7, estanteria7, id7);
			break;
		case 8:
			System.out.println("Modificar producto");
			System.out.println("Dame el ID del producto");
			int id8 = teclat.nextInt();
			System.out.println("Dame el nombre (También lo puedes cambiar)");
			String nom8 = teclat.nextLine();
			System.out.println("Dame la nueva cantidad");
			int quantity8 = teclat.nextInt();
			Bbdd.modProduct(id8, nom8, quantity8);
			break;
		case 9:
			System.out.println("Mostrar pasillo");
			System.out.println("Dame el pasillo a mostrar");
			int pasillo9 = teclat.nextInt();
			System.out.println(Bbdd.mostrarPasillo(pasillo9));
			break;
		case 10:
			System.out.println("Mostrar estantería");
			System.out.println("Dame el pasillo");
			int pasillo10 = teclat.nextInt();
			System.out.println("Dame la estanteria");
			int estanteria10 = teclat.nextInt();
			System.out.println(Bbdd.mostrarEstanteria(pasillo10, estanteria10));
			break;
		case 11:
			System.out.println("Buscar producto por nombre");
			System.out.println("Dame el nombre o al menos 1 letra del producto");
			String busqueda = teclat.nextLine();
			System.out.println(Bbdd.buscarProducto(busqueda));
			break;
		case 12:
			System.out.println("Registro de usuario");
			System.out.println("Dame el almacen");
			int almacen12 = teclat.nextInt();
			System.out.println("Dame el nombre de ususario");
			String username = teclat.nextLine();
			System.out.println("Dame la contraseña");
			String password = teclat.nextLine();
			System.out.println("¿Como se llama el empleado (solo nombre)?");
			String nom12 = teclat.nextLine();
			System.out.println("¿Cuales son sus apellidos?");
			String apellidos12 = teclat.nextLine();
			System.out.println("¿Qué rango tiene el trabajador?");
			String rango12 = teclat.nextLine();
			Bbdd.registroUsuari(almacen12, username, password, nom12, apellidos12, rango12);
			break;
		case 13:
			System.out.println("Login");
			System.out.println("Username: ");
			String username13 = teclat.nextLine();
			System.out.println("Password: ");
			String password13 = teclat.nextLine();
			Bbdd.iniciarSesion(username13, password13);
			break;
		case 14:
			System.out.println("Ver tickets");
			break;
		case 15:
			System.out.println("Comprobar si un usuario existe");
			System.out.println("Dame el nombre");
			String username15 = teclat.nextLine();
			System.out.println(Bbdd.comprobarUsuario(username15));
			break;
		case 16:
			System.out.println("Bienvenido al modo experto");
			System.out.println("Si no tienes conocimientos de BBDD te recomendamos salir");
			System.out.println("¿Quieres seguir?");
			System.out.println("s / n");
			String eleccio16 = teclat.nextLine();
			if (eleccio16 == "s") {
				System.out.println("Introduce tu SELECT personalizada");
				System.out.println("Recuerda, las select empiezan y acaban con comillas");
				String instruccio = teclat.nextLine();
					Bbdd.customSelect(instruccio);
					break;
			} else {
				break;
			}
		}
}
		
	}
	
	public static void main (String [] args) throws ClassNotFoundException, SQLException {
		customSelect();
	}	
	
}
