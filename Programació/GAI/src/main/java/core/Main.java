package core;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class Main {
	
	public static void main (String [] args) throws ClassNotFoundException, SQLException {
		Scanner teclat = new Scanner (System.in);
		System.out.println("Bienvenido a la interfaz de consola de GAI");
		System.out.println("Desde aqu� podr�s gestionar todo GAI sin interfaz Frontend");
		//////////////////////////////////////////////////////////////////////////////////
		boolean menu = true;
		while (menu == true) {
			System.out.println("0.- Matar consola");
			System.out.println("-------------------------");
			System.out.println("1.- Select personalizada");
			System.out.println("-------------------------");
			System.out.println("2.- A�adir almac�n");
			System.out.println("-------------------------");
			System.out.println("3.- A�adir pasillo");
			System.out.println("4.- Eliminar pasillo");
			System.out.println("-------------------------");
			System.out.println("5.- A�adir estanter�a");
			System.out.println("6.- Eliminar estanter�a");
			System.out.println("-------------------------");
			System.out.println("7.- A�adir producto");
			System.out.println("8.- Eliminar producto");
			System.out.println("9.- Modificar producto");
			System.out.println("-------------------------");
			System.out.println("10.- Buscar producto por nombre");
			System.out.println("11.- Mostrar estanter�a");
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
