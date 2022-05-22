package first;

import java.util.ArrayList;

public class Pasillo {
	private int id;
	private String descripcio;
	private ArrayList <Estanteria> listaEstanteriasPasillo;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getDescripcio() {return descripcio;}
	public void setDescripcio(String descripcio) {this.descripcio = descripcio;}
	public ArrayList<Estanteria> getListaEstanteriasPasillo() {return listaEstanteriasPasillo;}
	public void setListaEstanteriasPasillo(ArrayList<Estanteria> listaEstanteriasPasillo) {this.listaEstanteriasPasillo = listaEstanteriasPasillo;}
	
	@Override
	public String toString() {
		return "Pasillo [id=" + id + ", descripcio=" + descripcio + ", listaEstanteriasPasillo=" + listaEstanteriasPasillo
				+ "]";
	}
	public Pasillo(int id, String descripcio, ArrayList<Estanteria> listaEstanteriasPasilo) {
		super();
		this.id = id;
		this.descripcio = descripcio;
		this.listaEstanteriasPasillo = listaEstanteriasPasilo;
	}
	
	
	

	
}
