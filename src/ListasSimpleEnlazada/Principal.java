package ListasSimpleEnlazada;

public class Principal {
	public static void main(String[] args) {
		Libros plumas=new Libros();
		Libros gabiota=new Libros();
		Libros picos=new Libros();
		
		Listas lista=new Listas();
		plumas.setId(1);
		plumas.setNombre("primero");
		gabiota.setId(2);
		gabiota.setNombre("segundo");
		picos.setId(3);
		picos.setNombre("tercero");
		
		lista.InsertarAlPrincipio(plumas);
		lista.InsertarAlPrincipio(gabiota);
		lista.InsertarDespues(0, picos);
		lista.EliminarElPrincipio();
	}

}
