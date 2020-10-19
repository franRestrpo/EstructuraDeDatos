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
		
		lista.InsertarAlPrincipio(picos);
		lista.InsertarAlPrincipio(gabiota);
		lista.InsertarAlPrincipio(plumas);

		lista.MostrarOrden();
		lista.InsertarDespues(2, picos);
		lista.MostrarOrden();
		lista.EliminarElFinal();
		lista.MostrarOrden();
		System.out.println("Ejecucion de listas");
		
	}
	

}
