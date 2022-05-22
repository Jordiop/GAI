package first;

import java.util.ArrayList;

public class Almacen {
	private int id;
	private String nombre;
	private String localitzacio;
	private ArrayList<Pasillo> listaPasillos;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getLocalitzacio() {return localitzacio;}
	public void setLocalitzacio(String localitzacio) {this.localitzacio = localitzacio;}
	public ArrayList<Pasillo> getListaPasillos() {return listaPasillos;}
	public void setListaPasillos(ArrayList<Pasillo> listaPasillos) {this.listaPasillos = listaPasillos;}
	
	@Override
	public String toString() {
		return "Almacen [id=" + id + ", nombre=" + nombre + ", localitzacio=" + localitzacio + ", listaPasillos="
				+ listaPasillos + "]";
	}
	
	public Almacen(int id, String nombre, String localitzacio, ArrayList<Pasillo> listaPasillos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.localitzacio = localitzacio;
		this.listaPasillos = listaPasillos;
	}
	
}