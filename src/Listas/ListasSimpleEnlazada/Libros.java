package Listas.ListasSimpleEnlazada;

public class Libros {
private int id=0;
private String nombre="";
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "Libro@"+nombre+"::"+id;
}
}
