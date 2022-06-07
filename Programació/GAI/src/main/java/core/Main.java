package core;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class Main {
	
	public static void main (String [] args) throws ClassNotFoundException, SQLException {
		Scanner teclat = new Scanner (System.in);
		System.out.println("Bienvenido a la interfaz de consola de GAI");
		System.out.println("Desde aquí podrás gestionar todo GAI sin interfaz Frontend");
		//////////////////////////////////////////////////////////////////////////////////
		boolean menu = true;
		while (menu == true) {
			System.out.println("0.- Matar consola");
			System.out.println("-------------------------");
			System.out.println("1.- Select personalizada");
			System.out.println("-------------------------");
			System.out.println("2.- Añadir almacén");
			System.out.println("-------------------------");
			System.out.println("3.- Añadir pasillo");
			System.out.println("4.- Eliminar pasillo");
			System.out.println("-------------------------");
			System.out.println("5.- Añadir estantería");
			System.out.println("6.- Eliminar estantería");
			System.out.println("-------------------------");
			System.out.println("7.- Añadir producto");
			System.out.println("8.- Eliminar producto");
			System.out.println("9.- Modificar producto");
			System.out.println("-------------------------");
			System.out.println("10.- Buscar producto por nombre");
			System.out.println("11.- Mostrar estantería");
			System.out.println("12.- Mostrar pasillo");
			System.out.println("-------------------------");
			System.out.println("13.- Registrar usuario");
			
			int eleccio = teclat.nextInt();
	
			if (eleccio == 0) {
				menu = false;
				break;
			}
			
			switch (eleccio) {
				case 1:
					
					break;
			
			}
			
		}
		
		
	}
}
