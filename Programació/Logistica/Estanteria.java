package first;

import java.util.Arrays;

public class Estanteria {
	private int id;
	private String pasillo;
	private Product[][] estanteria;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getPasillo() {return pasillo;}
	public void setPasillo(String pasillo) {this.pasillo = pasillo;}
	public Product[][] getEstanteria() {return estanteria;}
	public void setEstanteria(Product[][] estanteria) {this.estanteria = estanteria;}
	
	@Override
	public String toString() {
		return "Estanteria [id=" + id + ", pasillo=" + pasillo + ", estanteria=" + Arrays.toString(estanteria) + "]";
	}
	
	public Estanteria(int id, String pasillo, Product[][] estanteria) {
		super();
		this.id = id;
		this.pasillo = pasillo;
		this.estanteria = estanteria;
	}
	
	
	
	
	
	
}

