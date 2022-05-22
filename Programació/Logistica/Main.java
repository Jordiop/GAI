package first;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int contador = 0;
	
	public void addAlmacen() {
		Scanner teclat = new Scanner(System.in);
		System.out.println("Hola");
		System.out.println("Bienvenido a la creación de almacén");
		System.out.println("Dame el id del almacén");
		int id = teclat.nextInt();
		teclat.nextLine();
		System.out.println("Dale un nombre");
		String nombre = teclat.nextLine();
		System.out.println("¿Cuál es su localización?");
		String localizacion = teclat.nextLine();
		ArrayList<Pasillo> listaPasillos = new ArrayList<Pasillo>();
		Almacen almacen = new Almacen(id,nombre,localizacion, listaPasillos);
		addEstanteria(listaPasillos);
	}
	
	public void addPasillo(ArrayList <Pasillo> listaPasillos){
		Scanner teclat = new Scanner(System.in);
		System.out.println("Hola");
		System.out.println("Bienvenido a la creación de pasillos");
		System.out.println("Dame un id para el pasillo");
		int id = teclat.nextInt();
		teclat.nextLine();
		System.out.println("Dame una breve descripción");
		String descripcion = teclat.nextLine();
		ArrayList<Estanteria> listaEstanterias = new ArrayList <Estanteria> ();
		Pasillo pasillo = new Pasillo (id, descripcion, listaEstanterias);
		listaPasillos.add(pasillo);
	}
	
	public void removePasillo(ArrayList <Pasillo> listaPasillos) {
		Scanner teclat = new Scanner(System.in);
		System.out.println("Hola");
		System.out.println("Bienvenido a la eliminación de pasillos");
		for (int i = 0; i < listaPasillos.size(); i++) {
			System.out.println(listaPasillos.get(i).toString());
		}
		int busqueda = teclat.nextInt();
		for (int i = 0; i < listaPasillos.size(); i++) {
			if (listaPasillos.get(i).getId() == busqueda) {
				System.out.println("¿Quieres eliminar el pasillo: "+busqueda+"?");
				System.out.println("Escribe 1 para confirmar o 2 para abortar");
				int eleccion = teclat.nextInt();
				if (eleccion == 1) {
					listaPasillos.remove(busqueda);
					System.out.println("Pasillo borrado");
				} 
				if (eleccion == 2) {
					System.out.println("Operación abortada");
				}
				else {
					System.out.println("Has escrito mal el número. Operación abortada.");
				}
			}
		}
		
	}
	
	public void addEstanteria(ArrayList <Pasillo> listaPasillos) {
		Scanner teclat = new Scanner(System.in);
		System.out.println("Hola");
		System.out.println("Bienvenido al asistente de creación de estanteria");
		System.out.println("Dame el id de la estanteria");
		int id = teclat.nextInt();
		teclat.nextLine();
		System.out.println("Dale un nombre a la estanteria");
		String nombre = teclat.nextLine();
		teclat.nextLine();
		System.out.println("¿Qué anchura deseas darle a la estanteria?");
		int anchura = teclat.nextInt();
		System.out.println("¿Cuánta altura tiene?");
		int altura = teclat.nextInt();
		Estanteria estanteria = new Estanteria(id,nombre, new Product[anchura][altura]);
		System.out.println("¿En qué pasillo estará?");
		int pasilloid = teclat.nextInt();
		boolean comprobante = false;
		for (int i=0;i < listaPasillos.size(); i++) {
			if (listaPasillos.get(i).getId() == pasilloid) {
				comprobante = true;
				listaPasillos.get(i).getListaEstanteriasPasillo().add(estanteria);
			} 
		}
		if (comprobante == false) {
			System.out.println("No encontrada");
		} else {
			System.out.println("Añadido completado");
		}
	}
	
	public void removeEstanteria(ArrayList <Pasillo> listaPasillos) {
		Scanner teclat = new Scanner(System.in);
		System.out.println("Hola");
		System.out.println("Bienvenido al asistente de eliminación de estanteria");
		System.out.println("Dame el id de la estanteria a eliminar");
		int busqueda = teclat.nextInt();
		for (int i = 0; i<listaPasillos.size(); i++) {
			if (listaPasillos.get(i).getId()==busqueda) {
				System.out.println("Quieres eliminar la estanteria: "+listaPasillos.get(i).getId()+"?");
				System.out.println("1 para confirmar");
				System.out.println("2 para abortar");
				int respuesta = teclat.nextInt();
				if (respuesta == 1) {
					listaPasillos.remove(i);
				}
				if (respuesta == 2) {
					System.out.println("Operación abortada");
				}
				else {
					System.out.println("No has puesto ni 1 ni 2");
				}
			}
		}
		
	}

	public void addProduct(ArrayList <Pasillo> listaPasillos) {
		Scanner teclat = new Scanner(System.in);
		System.out.println("Dame la id del producto");
		int id = teclat.nextInt();
		teclat.nextLine();
		System.out.println("Nombre del producto: ");
		String nombre = teclat.nextLine();
		System.out.println("Descripción del producto: ");
		String descripcion = teclat.nextLine();
		Product input = new Product(id, nombre, descripcion);
		colocarProduct(input,listaPasillos);
	}
	
	public void colocarProduct(Product product,ArrayList <Pasillo> listaPasillos) {
		Scanner teclat = new Scanner(System.in);
		System.out.println("Asignación de estanteria: ");
		for (int i = 0; i < listaPasillos.size(); i++) {
			System.out.println(listaPasillos.get(i).toString());
		}
		System.out.println("Dime en que pasillo irá: ");
		int pasilloid = teclat.nextInt();
		// Mostra sa llista de pasillos
		for (int i = 0; i < listaPasillos.size(); i++) {
			if (listaPasillos.get(i).getId() == pasilloid) {
				System.out.println("Muy bien, has seleccionado el pasillo: "+pasilloid);
				System.out.println("Ahora seleccionemos la estantería");
				// Mostra sa llista de estanteries
				for (int x= 0; x < listaPasillos.get(pasilloid).getListaEstanteriasPasillo().size(); x++) {
					System.out.println("listaPasillos.get(pasilloid).getListaEstanteriasPasillo()");
				}
				System.out.println("Elige: ");
				// Elegim estanteria
				// Input
				int eleccion = teclat.nextInt();
				for (int z = 0; z< listaPasillos.get(pasilloid).getListaEstanteriasPasillo().size();z++) {
					if (listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion) != null) {
						System.out.println("Muy bien, tenemos la estantería");
						System.out.println("Vamos a imprimir por pantalla la estantería: ");
						 for (int a = 0; i < (listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion).getEstanteria().length); a++) { 
					         for (int j = 0; j < listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion).getEstanteria()[a].length; j++) { 
					            System.out.print(listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion).getEstanteria()[a][j] + " ");
					         }
					         System.out.println();
					      }
						 System.out.println("Ahora vamos a establecer dónde irá el objeto entrante: ");
						 boolean colocat = false;
						 while (colocat == false) {
							 System.out.println("Dame la fila");
							 int fila = teclat.nextInt();
							 System.out.println("Dame la columna");
							 int columna = teclat.nextInt();
							 if (listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion).getEstanteria()[fila][columna]==null) {
								 listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion).getEstanteria()[fila][columna] = product;
								 colocat = true;
							 } else {
								 System.out.println("Hay algo en la estanteria en ese sitio.");
								 System.out.println("Vuelve a intentarlo");
						 	}
						 }
					} else {
						System.out.println("No se ni com has arribat aqui");
					}
				}
			}
		}
	}

	public void eliminarProduct(ArrayList <Pasillo> listaPasillos) {
		Scanner teclat = new Scanner(System.in);
		System.out.println("Asignación de estanteria: ");
		for (int i = 0; i < listaPasillos.size(); i++) {
			System.out.println(listaPasillos.get(i).toString());
		}
		System.out.println("Dime en que pasillo irá: ");
		int pasilloid = teclat.nextInt();
		// Mostra sa llista de pasillos
		for (int i = 0; i < listaPasillos.size(); i++) {
			if (listaPasillos.get(i).getId() == pasilloid) {
				System.out.println("Muy bien, has seleccionado el pasillo: "+pasilloid);
				System.out.println("Ahora seleccionemos la estantería");
				// Mostra sa llista de estanteries
				for (int x= 0; x < listaPasillos.get(pasilloid).getListaEstanteriasPasillo().size(); x++) {
					System.out.println("listaPasillos.get(pasilloid).getListaEstanteriasPasillo()");
				}
				System.out.println("Elige: ");
				// Elegim estanteria
				// Input
				int eleccion = teclat.nextInt();
				for (int z = 0; z< listaPasillos.get(pasilloid).getListaEstanteriasPasillo().size();z++) {
					if (listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion) != null) {
						System.out.println("Muy bien, tenemos la estantería");
						System.out.println("Vamos a imprimir por pantalla la estantería: ");
						 for (int a = 0; i < (listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion).getEstanteria().length); a++) { 
					         for (int j = 0; j < listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion).getEstanteria()[a].length; j++) { 
					            System.out.print(listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion).getEstanteria()[a][j] + " ");
					         }
					         System.out.println();
					      }
						 boolean colocat = false;
						 while (colocat == false) {
							 System.out.println("Dame la fila");
							 int fila = teclat.nextInt();
							 System.out.println("Dame la columna");
							 int columna = teclat.nextInt();
							 if (listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion).getEstanteria()[fila][columna] != null) {
								 listaPasillos.get(pasilloid).getListaEstanteriasPasillo().get(eleccion).getEstanteria()[fila][columna] = null;
							 colocat = true;}
							 else {
								 System.out.println("Vuelve a intentarlo");}
							 }
						 System.out.println("Producto eliminado");
					}
				}
			}
		}
	}

	public static void main (String []args) {
		
	}
}
