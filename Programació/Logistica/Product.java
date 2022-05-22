package first;

import java.util.*;

//authors jordi, biel, andreu
//Classe producte.
//Atributs: id, nom, descripció.
//Setters (comprobant de id) i getters
//Constructor buit i complet
//toString per veure els productes

public class Product {
	private int id;
	private String nombre;
	private String descripcion;
	
	 // Setters & getters
	
	public int getId() {return id;}
	public void setId(int id) {
	     boolean comprobante = false;
	     @SuppressWarnings("resource")
		Scanner teclat = new Scanner (System.in);
	     while (comprobante == false)
	         if (id<1) {
	             System.out.println("El ID que estás introduciendo no es correcto. Por favor, inténtelo de nuevo.");
	             id = teclat.nextInt();
	         } else {
	             comprobante = true;
	         }
	     this.id = id;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getDescripcion() {return descripcion;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

 // Constructor buit i complet

 public Product() {
     setId(id);
     setNombre(nombre);
     setDescripcion(descripcion);
 }

 public Product(int id, String nombre, String descripcion) {
     this.id = id;
     this.nombre = nombre;
     this.descripcion = descripcion;
 }

 // Product toString.

 @Override
 public String toString() {
     return "Product{" +
             "id=" + id +
             ", nombre='" + nombre + '\'' +
             ", descripcion='" + descripcion + '\'' +
             '}';
 }
}